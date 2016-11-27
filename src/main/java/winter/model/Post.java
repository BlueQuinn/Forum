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
public class Post implements Serializable
{
    private int id;
    private Integer userId;
    private Integer subjectId;
    private String content;
    private String media;
    private Integer comments;

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
    @Column(name = "content", nullable = true, length = 1024)
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
    @Column(name = "comments", nullable = true)
    public Integer getComments()
    {
        return comments;
    }

    public void setComments(Integer comments)
    {
        this.comments = comments;
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
        if (media != null ? !media.equals(post.media) : post.media != null)
        {
            return false;
        }
        if (comments != null ? !comments.equals(post.comments) : post.comments != null)
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
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
