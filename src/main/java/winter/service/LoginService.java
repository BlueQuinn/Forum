package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.LoginDAO;
import winter.model.User;

import javax.transaction.Transactional;

/**
 * Created by lequan on 11/20/2016.
 */
@Transactional
@Service("loginService")
public class LoginService
{
    @Autowired
    LoginDAO dao;

    public User login(User user)
    {
        return dao.getUser(user.getEmail(), user.getPassword());
    }

    public boolean validUsername(String username)
    {
        return dao.validUsername(username);
    }

    public String validEmail(String email)
    {
        return dao.validEmail(email);
    }
}
