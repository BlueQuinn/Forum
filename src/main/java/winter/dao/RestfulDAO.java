package winter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
            Class<?> type = Class.forName(modelName);
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

    public void delete(Serializable model)
    {
        getSession().delete(model);
    }
}
