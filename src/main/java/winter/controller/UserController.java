package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.annotation.JsonPost;
import winter.dto.Criteria;
import winter.http.ResponseFactory;
import winter.model.User;
import winter.service.FriendService;
import winter.service.LoginService;
import winter.service.RestfulService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends RestfulController<User>
{
    @Autowired
    LoginService loginService;

    @Autowired
    FriendService friendService;

    @Override
    public String add(@RequestBody User data) throws JsonProcessingException
    {
        if (!loginService.validUsername(data.getUsername()))
        {
            return ResponseFactory.getResponse(400, "Username has been taken");
        }

        String error = loginService.validEmail(data.getEmail());
        if (error != null)
        {
            return ResponseFactory.getResponse(400, error);
        }

        return super.add(data);
    }

    @JsonGet("/{id}/friends")
    public String getFriends(@PathVariable("id") int id) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, friendService.getFriends(id));
    }

    @JsonGet("/{id}/subscriptions")
    public String getSubscriptions(@PathVariable("id") int id) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getSubscriptions(id));
    }

    @JsonGet("/{id}/badges")
    public String getAchievements(@PathVariable("id") int id) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getAchievement(id));
    }

    @JsonGet("/{id}/results")
    public String getResults(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getResultsForUser(id, criteria));
    }

    @JsonGet("/{userId}/exercises/{exerciseId}/results")
    public String getResults(@PathVariable("userId") int userId, @PathVariable("exerciseId") int exerciseId, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getResults(userId, exerciseId, criteria));
    }

    @JsonGet("/{id}/posts")
    public String getPosts(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getByReferenceId("Post", "userId", id, criteria));
    }

    @JsonGet("/{id}/newsfeed")
    public String getNewsfeed(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getNewsfeed(id, criteria));
    }

  /*  @JsonGet("/{id}/hasLiked")
    public String checkLiked(@PathVariable("target") String target,@PathVariable("targetId") int targetId) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getNewsfeed(id, criteria));
    }*/
}
