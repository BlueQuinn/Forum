package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.RestfulDAO;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lequan on 11/20/2016.
 */
@Transactional
@Service("restfulService")
public class RestfulService
{
    @Autowired
    RestfulDAO dao;

    public Serializable get(String modelName, Serializable id)
    {
        return dao.get(modelName, id);
    }

    public ArrayList getAll(String modelName)
    {
        return  dao.getAll(modelName);
    }

    public ArrayList getAll(String modelName, String order, String sort)
    {
        return  dao.getAll(modelName, order, sort);
    }

    public ArrayList getByReferenceId(String detail, String masterId, int id)
    {
        return  dao.getByReferenceId(detail, masterId, id);
    }

    public Serializable add(Serializable obj)
    {
       return dao.add(obj);
    }

    public void update(Serializable obj)
    {
        dao.update(obj);
    }

    public void delete(String model, int id)
    {
        dao.delete(model, id);
    }




    public ArrayList getResults(int userId)
    {
        return dao.getResults(userId);
    }

    public ArrayList getSubscriptions(int userId)
    {
        return dao.getSubscriptions(userId);
    }

    public ArrayList getAchievement(int userId)
    {
        return dao.getAchievement(userId);
    }

    public ArrayList getComments(int postId)
    {
        return dao.getComments(postId);
    }

    public ArrayList getLikes(int postId)
    {
        return dao.getLikes(postId);
    }

}
