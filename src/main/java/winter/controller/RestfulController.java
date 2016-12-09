package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.http.ResponseFactory;
import winter.service.RestfulService;

import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/{model}")
public class RestfulController<T extends Serializable>
{
    @Autowired
    RestfulService service;

    ObjectMapper mapper = new ObjectMapper();

    @JsonGet()
    public String get(@PathVariable("model") String model) throws JsonProcessingException
    {
        //model = model.substring(0, 1).toUpperCase() + model.substring(1);
        try
        {
            return mapper.writeValueAsString(service.getAll(model));
        }
        catch (JsonProcessingException ex)
        {
            ex.printStackTrace();
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    @JsonGet(path = "/{id}")
    public String get(@PathVariable("model") String model, @PathVariable("id") int id) throws JsonProcessingException
    {
        //model = model.substring(0, 1).toUpperCase() + model.substring(1);
        try
        {
            return mapper.writeValueAsString(service.get(model, id));
        }
        catch (JsonProcessingException ex)
        {
            ex.printStackTrace();
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    /*@JsonPost()
    public String add(@RequestBody T data) throws JsonProcessingException
    {
        try
        {
            Serializable id = service.add(data);
            return ResponseFactory.getResponse(200, id);
        }
        catch (Exception ex)
        {
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    @JsonPut(path = "/{id}")
    public String update(@PathVariable("id") int id, @RequestBody T data) throws JsonProcessingException
    {
        try
        {
            service.update(data);
        }
        catch (Exception ex)
        {
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
        return ResponseFactory.getResponse(200, id);
    }

    @JsonDelete(path = "/{id}")
    public String delete(@PathVariable("id") Serializable id) throws JsonProcessingException
    {
        try
        {
            //service.delete(id);
        }
        catch (Exception ex)
        {
            return "";
        }
        return "";
    }*/
}
