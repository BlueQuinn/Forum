package winter.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Post implements Serializable
{
    private int id;
    private Integer userId;
    private Integer subjectId;
    private String content;
    private Integer rating;
    private Long date;
    private String image;
    private Integer commentCount;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
    @Column(name = "subjectId", nullable = true)
    public Integer getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId)
    {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 2048)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Long getDate()
    {
        return date;
    }

    public void setDate(Long date)
    {
        this.date = date;
    }

    @Transient
    public Integer getCommentCount()
    {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount)
    {
        this.commentCount = commentCount;
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

        Post post = (Post) o;

        if (id != post.id)
        {
            return false;
        }
        if (userId != null ? !userId.equals(post.userId) : post.userId != null)
        {
            return false;
        }
        if (subjectId != null ? !subjectId.equals(post.subjectId) : post.subjectId != null)
        {
            return false;
        }
        if (content != null ? !content.equals(post.content) : post.content != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
