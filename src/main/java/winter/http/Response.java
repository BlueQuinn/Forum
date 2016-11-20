package winter.http;

import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
public class Response
{
    int code;
    Serializable message;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Serializable getMessage()
    {
        return message;
    }

    public void setMessage(Serializable message)
    {
        this.message = message;
    }

    public Response(int code)
    {

        this.code = code;
    }

    public Response(int code, Serializable message)
    {

        this.code = code;
        this.message = message;
    }
}
