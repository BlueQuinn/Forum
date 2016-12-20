package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import winter.http.ResponseFactory;
import winter.model.User;
import winter.service.LoginService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    LoginService service;

    @ResponseBody
    @PostMapping
    public String login(@RequestBody User user) throws JsonProcessingException
    {
        try
        {
            user = service.login(user);
            if (user == null)
            {
                return ResponseFactory.getResponse(401, "Can't authorize user");
            }

            return ResponseFactory.getResponse(200, user);
        }
        catch (JsonProcessingException ex)
        {
            //e.printStackTrace();
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }
}
