package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.RestfulDAO;
import winter.dto.Criteria;

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

    public ArrayList getAll(String modelName)
    {
        return  dao.getAll(modelName);
    }

    public ArrayList getAll(String modelName, Criteria criteria)
    {
        return  dao.getAll(modelName, criteria);
    }

    public ArrayList getByReferenceId(String detail, String masterId, int id, Criteria criteria)
    {
        return  dao.getByReferenceId(detail, masterId, id, criteria);
    }




    public ArrayList getResultsForUser(int userId, Criteria criteria)
    {
        return dao.getResultsForUser(userId, criteria);
    }

    public ArrayList getResultsForExercise(int exerciseId, Criteria criteria)
    {
        return dao.getResultsForExercise(exerciseId, criteria);
    }

    public ArrayList getResults(int userId, int exerciseId, Criteria criteria)
    {
        return dao.getResults(userId, exerciseId, criteria);
    }

    public ArrayList getSubscriptions(int userId)
    {
        return dao.getSubscriptions(userId);
    }

    public ArrayList getAchievement(int userId)
    {
        return dao.getAchievement(userId);
    }

    public ArrayList getComments(int postId, Criteria criteria)
    {
        return dao.getComments(postId, criteria);
    }

    public ArrayList getLikes(int postId, Criteria criteria)
    {
        return dao.getLikes(postId, criteria);
    }

    public ArrayList getPosts(int subjectId, Criteria criteria)
    {
        return dao.getPosts(subjectId, criteria);
    }

    public ArrayList getNewsfeed(int userId, Criteria criteria)
    {
        return dao.getNewsfeed(userId, criteria);
    }

}
