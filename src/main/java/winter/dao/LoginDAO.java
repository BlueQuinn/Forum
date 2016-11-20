package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.model.User;

/**
 * Created by lequan on 11/20/2016.
 */
public class LoginDAO
{
    @Autowired
    SessionFactory sessionFactory;

    Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    public User getUser(String email, String password)
    {
        String hql = "from User where email = :email and password = :password";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (User) query.uniqueResult();
    }
}
