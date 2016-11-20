package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.User;

import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends RestfulController<User>
{
}
