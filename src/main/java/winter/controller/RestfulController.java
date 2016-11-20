package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import winter.service.RestfulService;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/{model}")
public class RestfulController
{
    @Autowired
    RestfulService service;

    ObjectMapper mapper = new ObjectMapper();

    @ResponseBody
    @GetMapping()
    public String get(@PathVariable("model") String model)
    {
        try
        {
            return mapper.writeValueAsString(service.getAll(model));
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
            return   "";
        }
    }
}
