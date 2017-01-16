package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Comment;
import winter.model.Post;

import java.util.Date;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/comment")
public class CommentController extends RestfulController<Comment>
{
    @Override
    void parseBeforeAdd(Comment comment)
    {
        long date = new Date().getTime();
        comment.setDate(date);
    }
}
