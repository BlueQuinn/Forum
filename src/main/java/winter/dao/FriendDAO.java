package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.model.User;

import java.util.ArrayList;

/**
 * Created by lequan on 12/15/2016.
 */
public class FriendDAO
{
    @Autowired
    SessionFactory sessionFactory;

    Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public ArrayList<User> getFriends(int userId)
    {
        String hql = String.format("select u from Friend f, Users u where (f.user1 = %d and f.user2 = u.id) or (f.user2 = %d and f.user1 = u.id)", userId);
        Query query = getSession().createQuery(hql);
        return (ArrayList<User>) query.list();
    }
}
