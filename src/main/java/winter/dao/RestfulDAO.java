package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.dto.*;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by lequan on 11/20/2016.
 */
public class RestfulDAO
{
    @Autowired
    SessionFactory sessionFactory;

    Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public Serializable add(Serializable model)
    {
        return getSession().save(model);
    }

    public Serializable get(String modelName, Serializable id)
    {
        try
        {
            Class<?> type = Class.forName("winter.model." + modelName);
            return (Serializable) getSession().get(type, id);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getAll(String modelName)
    {
        return (ArrayList) getSession().createQuery("from " + modelName).list();
    }

    public void update(Serializable model)
    {
        getSession().update(model);
    }

    public void delete(String model, int id)
    {
        String hql = String.format("delete from %s where id = %d", model, id);
        Query query = getSession().createQuery(hql);
        query.executeUpdate();
    }

    void addPrefix(Criteria criteria, String table)
    {
        String order = criteria.getOrder();
        if (!order.equals("id"))
        {
            criteria.setOrder(table + "." + order);
        }
    }

    ArrayList query(String hql, Criteria criteria)
    {
        if (criteria.getTable() != null)
        {
            if (criteria.getOrder() != null)
            {
                hql += " order by " + criteria.getTable() + "." + criteria.getOrder();
            }
        }
        else
        {
            if (!criteria.getOrder().equals("id") || !criteria.getSort().equals("asc"))
            {
                hql += " order by " + criteria.getOrder();
            }
        }

        if (!criteria.getSort().equals("asc"))
        {
            hql += " desc";
        }

        System.out.println(hql);
        Query query = getSession().createQuery(hql);
        if (criteria.getOffset() != 0)
        {
            query.setFirstResult(criteria.getOffset());
        }
        if (criteria.getLimit() != null)
        {
            query.setMaxResults(criteria.getLimit());
        }
        return (ArrayList) query.list();
    }

    public ArrayList getAll(String modelName, Criteria criteria)
    {
        String hql = "from " + modelName;
        return query(hql, criteria);
    }

    public ArrayList getByReferenceId(String detail, String masterId, int id, Criteria criteria)
    {
        String hql = String.format("from %s where %s = %d", detail, masterId, id);
        return query(hql, criteria);
    }

    ArrayList parse(Class<?> type, ArrayList<Object[]> rows)
    {
        try
        {
            Field[] fields = type.getDeclaredFields();      //createField(type, columns);
            for (Field field : fields)
            {
                field.setAccessible(true);
            }

            ArrayList list = new ArrayList<>();
            Constructor<?> constructor = type.getConstructor();     // throw exception
            Object model;
            for (Object[] row : rows)
            {
                model = constructor.newInstance();      // throw exception
                for (int i = 0; i < fields.length; ++i)
                {
                    fields[i].set(model, row[i]);
                }
                list.add(model);
            }
            return list;
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList getSubscriptions(int userId)
    {
        String hql = String.format("select subscription.id, subject.name from Subject subject, Subscription subscription where subscription.userId = %d and subscription.subjectId = subject.id", userId);
        Query query = getSession().createQuery(hql);
        ArrayList<Object[]> list = (ArrayList) query.list();
        return parse(Subscription.class, list);
    }

    public ArrayList getAchievement(int userId)
    {
        String hql = String.format("select badge.name from Badge badge, Achievement achievement where achievement.userId = %d and achievement.badgeId = badge.id", userId);
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
    }

    public ArrayList getResultsForUser(int userId, Criteria criteria)
    {
        String hql = String.format("select exercise.id, exercise.name, result.score from Result result, Exercise exercise where result.userId = %d and result.exerciseId = exercise.id", userId);
        ArrayList list = query(hql, criteria);
        return parse(ResultForUser.class, list);
    }

    public ArrayList getResultsForExercise(int exerciseId, Criteria criteria)
    {
        String hql = String.format("select user.id, user.username, result.score from Result result, User user where result.exerciseId = %d and user.id = result.userId", exerciseId);
        ArrayList list = query(hql, criteria);
        return parse(ResultForExercise.class, list);
    }

    public ArrayList getResults(int userId, int exerciseId, Criteria criteria)
    {
        String hql = String.format("from Result result where result.userId = %d and result.exerciseId = %d", userId, exerciseId);
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
    }

    public ArrayList getComments(int postId, Criteria criteria)
    {
        String hql = String.format("select comment.id, user.id, user.username, comment.content, comment.image, comment.rating, comment.date from Comment comment, User user where comment.postId = %d and comment.userId = user.id", postId);
        ArrayList list = query(hql, criteria);
        return parse(Comment.class, list);
    }

    public ArrayList getLikes(int postId, Criteria criteria)
    {
        String hql = String.format("select likes.id, user.id, user.username from Likes likes, User user where likes.postId = %d and user.id = likes.userId", postId);
        ArrayList list = query(hql, criteria);
        return parse(Likes.class, list);
    }

    public ArrayList getPosts(int subjectId, Criteria criteria)
    {
        String hql = String.format("select post.id, user.id, user.username, post.content, post.image, post.rating, post.date, count(comment.id) from Post post, User user, Comment comment" +
                " where post.subjectId = %d" +
                " and post.userId = user.id and post.id = comment.postId" +
                " group by post.id", subjectId);
        ArrayList list = query(hql, criteria);
        return parse(Post.class, list);
    }

    public ArrayList getNewsfeed(int userId, Criteria criteria)     // userId here is belong to the subscription, not post's userId
    {
        String hql = String.format("select post.id, user.id, user.username, post.content, post.image, post.rating, post.date, count(comment.id) from Post post, Subscription subscription, User user, Comment comment" +
                " where subscription.userId = %d and subscription.subjectId = post.subjectId" +
                " and post.userId = user.id and post.id = comment.postId" +
                " group by post.id", userId);
        ArrayList list = query(hql, criteria);
        return parse(Post.class, list);
    }
}



    /* Field[] createField(Class<?> type, String[] columns)
   {
       Field[] fields = new Field[columns.length];
       try
       {
           Field field;
           for (int i = 0; i < columns.length; ++i)
           {
               fields[i] = type.getDeclaredField(columns[i]);
               fields[i].setAccessible(true);
           }
       }
       catch (NoSuchFieldException e)
       {
           e.printStackTrace();
       }
       return fields;
   }*/







    /*
ArrayList query(String hql, Criteria criteria)
    {
        if (!criteria.getOrder().equals("id"))
        {
            hql += " order by " + criteria.getOrder();
            if (!criteria.getSort().equals("asc"))
            {
                hql += " desc";
            }
        }

        Query query = getSession().createQuery(hql);
        if (criteria.getOffset() != 0)
        {
            query.setFirstResult(criteria.getOffset());
        }
        if (criteria.getLimit() != null)
        {
            query.setMaxResults(criteria.getLimit());
        }
        return (ArrayList) query.list();
    }


    ArrayList query(String hql, String order, String sort, int offset, Integer limit)
    {
        if (!order.equals("id"))
        {
            hql += " order by " + order;
            if (!sort.equals("asc"))
                hql += " desc";
        }

        Query query = getSession().createQuery(hql);
        if (offset != 0)
            query.setFirstResult(offset);
        if (limit != null)
            query.setMaxResults(limit);
        return (ArrayList) query.list();
    }*/