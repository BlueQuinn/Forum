package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.FriendDAO;
import winter.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by lequan on 12/15/2016.
 */
@Transactional
@Service("friendService")
public class FriendService
{
    @Autowired
    FriendDAO dao;

    public ArrayList<User> getFriends(int userId)
    {
        ArrayList<User> friends = dao.getFriends(userId);
        for (User f : friends)
            f.setPassword(null);
        return friends;
    }
}
