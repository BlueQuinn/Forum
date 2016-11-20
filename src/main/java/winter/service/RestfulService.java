package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.RestfulDAO;
import winter.model.User;

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

    public Serializable add(Serializable obj)
    {
       return dao.add(obj);
    }

    public void update(Serializable obj)
    {
        dao.update(obj);
    }

    /*public void delete(Serializable id)
    {
        dao.delete(dao.get(id));
    }*/
}
