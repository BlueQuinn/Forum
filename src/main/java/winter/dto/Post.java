package winter.dto;

/**
 * Created by lequan on 1/10/2017.
 */
public class Post
{
    private int id;
    private int userId;
    private String username;
    private String content;
    private String image;
    private int rating;
    private long date;
    private long commentCount;

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

    public long getCommentCount()
    {
        return commentCount;
    }

    public void setCommentCount(long commentCount)
    {
        this.commentCount = commentCount;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setDate(long date)
    {
        this.date = date;
    }
}
