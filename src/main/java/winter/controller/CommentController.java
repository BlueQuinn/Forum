package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.dto.Criteria;
import winter.http.ResponseFactory;
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

    @JsonGet("/{id}/likes")
    public String getLikes(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getLikesForComment(id, criteria));
    }
}
