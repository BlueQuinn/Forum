package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import winter.annotation.JsonDelete;
import winter.annotation.JsonGet;
import winter.annotation.JsonPost;
import winter.annotation.JsonPut;
import winter.dto.Criteria;
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

    @Autowired
    ObjectMapper mapper;

    /*@JsonGet()
    public String get(@PathVariable("model") String model) throws JsonProcessingException
    {
        //model = model.substring(0, 1).toUpperCase() + model.substring(1);
        try
        {
            return ResponseFactory.getResponse(200, service.getAll(model));
        }
        catch (JsonProcessingException ex)
        {
            ex.printStackTrace();
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }*/

    /* @JsonGet()
     public String get(@RequestParam(value = "order", required = false, defaultValue = "id") String order,
                       @RequestParam(value = "sort", required = false, defaultValue = "asc") String sort,
                       @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit", required = false) Integer limit,
                       @PathVariable("model") String model) throws JsonProcessingException*/
    @JsonGet
    public String get(@PathVariable("model") String model, Criteria criteria) throws JsonProcessingException
    {
        System.out.println(mapper.writeValueAsString(criteria));
        try
        {
            model = model.substring(0, 1).toUpperCase() + model.substring(1);
            return ResponseFactory.getResponse(200, service.getAll(model, criteria));
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
            return ResponseFactory.getResponse(200, service.get(model, id));
        }
        catch (JsonProcessingException ex)
        {
            ex.printStackTrace();
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    @JsonPost
    public String add(@RequestBody T data) throws JsonProcessingException
    {
        try
        {
            parseBeforeAdd(data);
            Serializable id = service.add(data);
            return ResponseFactory.getResponse(200, id);
        }
        catch (Exception ex)
        {
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    @JsonPut("/{id}")
    public String update(@PathVariable("id") int id, @RequestBody T data) throws JsonProcessingException
    {
        try
        {
            service.update(data);
            return ResponseFactory.getResponse(200, id);
        }
        catch (Exception ex)
        {
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    @JsonDelete("/{id}")
    public String delete(@PathVariable("model") String model, @PathVariable("id") int id) throws JsonProcessingException
    {
        try
        {
            model = model.substring(0, 1).toUpperCase() + model.substring(1);
            service.delete(model, id);
            return ResponseFactory.getResponse(200);
        }
        catch (Exception ex)
        {
            return ResponseFactory.getResponse(400, ex.getMessage());
        }
    }

    void parseBeforeAdd(T data)
    {

    }

    void parseAfterGet(T data)
    {

    }
}
