package winter.dto;

/**
 * Created by lequan on 12/15/2016.
 */
public class Comment
{
    int id;
    int userId;
    String username;
    String content;
    int rating;

    public Comment(int userId, String username, String content, int rating)
    {
        this.userId = userId;
        this.username = username;
        this.content = content;
        this.rating = rating;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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
