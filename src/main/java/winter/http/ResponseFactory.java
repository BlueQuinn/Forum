package winter.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
public class ResponseFactory
{
    static ObjectMapper mapper = new ObjectMapper();

    public static String getResponse(int code) throws JsonProcessingException
    {
        return mapper.writeValueAsString(new Response(code));
    }

    public static String getResponse(int code, Serializable message) throws JsonProcessingException
    {
        return mapper.writeValueAsString(new Response(code, message));
    }
}
