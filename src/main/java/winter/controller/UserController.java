package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.http.ResponseFactory;
import winter.model.User;
import winter.service.FriendService;
import winter.service.RestfulService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends RestfulController<User>
{
    @Autowired
    FriendService friendService;

    @JsonGet("/{id}/friends")
    public String getFriends(@PathVariable("id") int id) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, friendService.getFriends(id));
    }

    @JsonGet("/{id}/subscriptions")
    public String getSubscriptions(@PathVariable("id") int id) throws JsonProcessingException
    {
        //return mapper.writeValueAsString(service.getByReferenceId("Subscription", "userId", id));
        return ResponseFactory.getResponse(200, service.getSubscriptions(id));
    }

    @JsonGet("/{id}/badges")
    public String getAchievements(@PathVariable("id") int id) throws JsonProcessingException
    {
        //return mapper.writeValueAsString(service.getByReferenceId("Achievement", "userId", id));
        return ResponseFactory.getResponse(200, service.getAchievement(id));
    }

    @JsonGet("/{id}/results")
    public String getResults(@PathVariable("id") int id) throws JsonProcessingException
    {
        //return mapper.writeValueAsString(service.getByReferenceId("Achievement", "userId", id));
        return ResponseFactory.getResponse(200, service.getResults(id));
    }

    @JsonGet("/{id}/posts")
    public String getPosts(@PathVariable("id") int id) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getByReferenceId("Post", "userId", id));
    }
}
