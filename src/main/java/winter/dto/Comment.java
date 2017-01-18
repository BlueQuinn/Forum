package winter.dto;

import java.util.ArrayList;

/**
 * Created by lequan on 12/15/2016.
 */
public class Comment
{
    int id;
    int userId;
    String username;
    String content;
    String image;
    int rating;
    private long date;

    ArrayList likes;

    public ArrayList getLikes()
    {
        return likes;
    }

    public void setLikes(ArrayList likes)
    {
        this.likes = likes;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public Long getDate()
    {
        return date;
    }

    public void setDate(Long date)
    {
        this.date = date;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setDate(long date)
    {
        this.date = date;
    }
}
