package winter.dto;

/**
 * Created by lequan on 12/15/2016.
 */
public class Comment
{
    String user;
    String content;
    int rating;

    public Comment(String user, String content, int rating)
    {
        this.user = user;
        this.content = content;
        this.rating = rating;
    }

    public String getUser()
    {

        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }
}
