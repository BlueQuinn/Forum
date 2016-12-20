package winter.http;

import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
public class Response
{
    int code;
    Serializable response;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Serializable getResponse()
    {
        return response;
    }

    public void setResponse(Serializable response)
    {
        this.response = response;
    }

    public Response(int code)
    {

        this.code = code;
    }

    public Response(int code, Serializable response)
    {

        this.code = code;
        this.response = response;
    }
}
