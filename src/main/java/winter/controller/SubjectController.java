package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.dto.Criteria;
import winter.http.ResponseFactory;
import winter.model.Subject;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/subject")
public class SubjectController extends RestfulController<Subject>
{
    @JsonGet("/{id}/posts")
    public String getPosts(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getPosts(id, criteria));
    }

    @JsonGet("/{id}/exercises")
    public String getExercises(@PathVariable("id") int id, Criteria criteria) throws JsonProcessingException
    {
        return ResponseFactory.getResponse(200, service.getByReferenceId("Exercise", "subjectId", id, criteria));
    }
}
