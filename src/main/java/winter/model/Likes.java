package winter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Likes
{
    private Integer postId;
    private Integer userId;

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

        Likes likes = (Likes) o;

        if (postId != null ? !postId.equals(likes.postId) : likes.postId != null)
        {
            return false;
        }
        if (userId != null ? !userId.equals(likes.userId) : likes.userId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
