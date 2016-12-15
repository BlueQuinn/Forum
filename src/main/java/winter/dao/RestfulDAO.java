package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.dto.Comment;
import winter.dto.Result;
import winter.model.User;

import java.io.Serializable;
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

    public void delete(Serializable model)
    {
        getSession().delete(model);
    }






    public ArrayList getSubscriptions(int userId)
    {
        String hql = String.format("select Sj.name from Subject Sj, Subscription Sc, User U where U.id = %d and U.id = Sc.userId and Sc.subjectId = Sj.id", userId);
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
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
        ArrayList<Result> results = new ArrayList<Result>();
        for (Object i : list)
        {
            Object[] o = (Object[])i;
            results.add(new Result((String)o[0], (Integer) o[1]));
        }
        return results;
    }

    public ArrayList getComments(int postId)
    {
        String hql = String.format("select C.content, C.rating, U.username from Comment C, Post P, User U where P.id = %d and P.id = C.postId and C.userId = U.id", postId);
        Query query = getSession().createQuery(hql);
        ArrayList list = (ArrayList) query.list();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        for (Object i : list)
        {
            Object[] o = (Object[])i;
            comments.add(new Comment((String)o[2], (String)o[0], (Integer) o[1]));
        }
        return comments;
    }

    public ArrayList getLikes(int postId)
    {
        String hql = String.format("select U.name from Post P, Likes L, User U where U.id = %d and U.id = L.userId and L.postId = P.id", postId);
        Query query = getSession().createQuery(hql);
        return (ArrayList) query.list();
    }
}
