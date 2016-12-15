package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.model.Exercise;
import winter.service.RestfulService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/exercise")
public class ExerciseController extends RestfulController<Exercise>
{
    @Autowired
    ObjectMapper mapper;

    @Autowired
    RestfulService service;

    @JsonGet("/{id}/questions")
    public String getQuestions(@PathVariable("id") int id) throws JsonProcessingException
    {
        return mapper.writeValueAsString(service.getByReferenceId("Question", "exerciseId", id));
    }

    @JsonGet("/{id}/results")
    public String getResults(@PathVariable("id") int id) throws JsonProcessingException
    {
        return mapper.writeValueAsString(service.getByReferenceId("Result", "exerciseId", id));
    }
}
