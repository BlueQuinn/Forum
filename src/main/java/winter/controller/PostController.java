package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.model.Post;
import winter.service.RestfulService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/post")
public class PostController extends RestfulController<Post>
{
    @Autowired
    ObjectMapper mapper;

    @Autowired
    RestfulService service;

    @JsonGet("/{id}/comments")
    public String getComments(@PathVariable("id") int id) throws JsonProcessingException
    {
        //return mapper.writeValueAsString(service.getByReferenceId("Comment", "postId", id));
        return mapper.writeValueAsString(service.getComments(id));
    }

    @JsonGet("/{id}/likes")
    public String getLikes(@PathVariable("id") int id) throws JsonProcessingException
    {
        //return mapper.writeValueAsString(service.getByReferenceId("Likes", "postId", id));
        return mapper.writeValueAsString(service.getLikes(id));
    }
}
