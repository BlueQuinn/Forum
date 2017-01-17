package winter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import winter.annotation.JsonGet;
import winter.dto.Criteria;
import winter.service.ChallengeService;

/**
 * Created by lequan on 1/17/2017.
 */
@Controller
@RequestMapping("/api/challenge")
public class ChallengeController
{
    @Autowired
    ObjectMapper mapper;

    @Autowired
    ChallengeService service;

    @JsonGet
    public String get(@RequestParam(value="limit", required = false, defaultValue = "50") Integer limit) throws JsonProcessingException
    {
return mapper.writeValueAsString(service.get(limit));
}
}
