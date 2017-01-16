package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import winter.annotation.JsonGet;
import winter.dto.Criteria;
import winter.http.ResponseFactory;
import winter.model.Post;
import winter.service.RestfulService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/post")
public class PostController extends RestfulController<Post>
{
    @Override
    void parseBeforeAdd(Post post)
    {
        long date = new Date().getTime();
        post.setDate(date);
    }

    @JsonGet("/{id}/comments")
    public String getComments(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getComments(id, criteria));
    }

    @JsonGet("/{id}/likes")
    public String getLikes(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getLikes(id, criteria));
    }
}
