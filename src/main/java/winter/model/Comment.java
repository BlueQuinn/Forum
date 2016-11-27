package winter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Comment implements Serializable
{
    private int id;
    private Integer postId;
    private Integer userId;
    private String content;
    private String media;
    private Integer rating;

    @Id
    @Column(name = "id", nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "postId", nullable = true)
    public Integer getPostId()
    {
        return postId;
    }

    public void setPostId(Integer postId)
    {
        this.postId = postId;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 128)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "media", nullable = true, length = 64)
    public String getMedia()
    {
        return media;
    }

    public void setMedia(String media)
    {
        this.media = media;
    }

    @Basic
    @Column(name = "rating", nullable = true)
    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Comment comment = (Comment) o;

        if (id != comment.id)
        {
            return false;
        }
        if (postId != null ? !postId.equals(comment.postId) : comment.postId != null)
        {
            return false;
        }
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null)
        {
            return false;
        }
        if (content != null ? !content.equals(comment.content) : comment.content != null)
        {
            return false;
        }
        if (media != null ? !media.equals(comment.media) : comment.media != null)
        {
            return false;
        }
        if (rating != null ? !rating.equals(comment.rating) : comment.rating != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
