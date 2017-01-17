package winter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import winter.dto.Criteria;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.toIntExact;

/**
 * Created by lequan on 1/17/2017.
 */
public class ChallengeDAO
{
    @Autowired
    SessionFactory sessionFactory;

    Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

  /*  int[] generate(int count)
    {
        String hql = "select count(*) from Question";
        Query query = getSession().createQuery(hql);
        Long result = (Long)query.uniqueResult();
       int max = toIntExact(result);
        int[] id = new int[max];
        for (int i = 0; i <= max; i++){ //to generate from 0-10 inclusive.
            //For 0-9 inclusive, remove the = on the <=
            a.add(i);
        }
        Collections.shuffle(a);
        a = a.sublist(0,count);
    }*/

    public ArrayList get(int limit)
    {
        String hql = "FROM Question ORDER BY rand()";
        Query query = getSession().createQuery(hql);
        query.setMaxResults(limit);
        return (ArrayList) query.list();
    }
}
