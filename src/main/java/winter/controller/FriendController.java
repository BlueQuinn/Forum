package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Friend;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/friend")
public class FriendController extends RestfulController<Friend>
{
}
