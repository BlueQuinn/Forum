package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.dto.Comment;
import winter.dto.Likes;
import winter.dto.Result;
import winter.dto.Subscription;
import winter.model.User;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

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

    public ArrayList getByReferenceId(String detail, String masterId, int id)
    {
        String hql = String.format("select * from %s where %s = %d", detail, masterId, id);
        //"select o from " + master + " o where " + masterid + " = " + id;
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
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

    ArrayList parseResult(Class<?> type, ArrayList<Object[]> rows)
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
        String hql = String.format("select Sc.id, Sj.name from Subject Sj, Subscription Sc, User U where U.id = %d and U.id = Sc.userId and Sc.subjectId = Sj.id", userId);
        Query query = getSession().createQuery(hql);
        ArrayList<Object[]> list = (ArrayList) query.list();
        return parseResult(Subscription.class, list);
    }

    public ArrayList getAchievement(int userId)
    {
        String hql = String.format("select B.name from Badge B, Achievement A, User U where U.id = %d and U.id = A.userId and A.badgeId = B.id", userId);
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
    }

    public ArrayList getResults(int userId)
    {
        String hql = String.format("select E.name, R.score from Result R, Exercise E, User U where U.id = %d and U.id = R.userId and R.exerciseId = E.id", userId);
        Query query = getSession().createQuery(hql);
        ArrayList list = (ArrayList) query.list();
        return parseResult(Result.class, list);
    }

    public ArrayList getComments(int postId)
    {
        String hql = String.format("select C.id, U.id, U.username, C.content, C.rating, C.date  from Comment C, Post P, User U where P.id = %d and P.id = C.postId and C.userId = U.id", postId);
        Query query = getSession().createQuery(hql);
        ArrayList list = (ArrayList) query.list();
        return parseResult(Comment.class, list);
    }

    public ArrayList getLikes(int postId)
    {
        String hql = String.format("select L.id, U.id, U.name from Post P, Likes L, User U where U.id = %d and U.id = L.userId and L.postId = P.id", postId);
        Query query = getSession().createQuery(hql);
        ArrayList list = (ArrayList) query.list();
        return parseResult(Likes.class, list);
    }
}
