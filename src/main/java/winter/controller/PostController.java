package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Post;
import winter.model.User;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/post")
public class PostController extends RestfulController<Post>
{
}
