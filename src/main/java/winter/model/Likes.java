package winter.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lequan on 1/18/2017.
 */
@Entity
public class Likes implements Serializable
{
    private int id;
    private String target;
    private Integer targetId;
    private Integer userId;

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
    @Column(name = "target", nullable = true, length = 16)
    public String getTarget()
    {
        return target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    @Basic
    @Column(name = "targetId", nullable = true)
    public Integer getTargetId()
    {
        return targetId;
    }

    public void setTargetId(Integer targetId)
    {
        this.targetId = targetId;
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

        if (id != likes.id)
        {
            return false;
        }
        if (target != null ? !target.equals(likes.target) : likes.target != null)
        {
            return false;
        }
        if (targetId != null ? !targetId.equals(likes.targetId) : likes.targetId != null)
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
        int result = id;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (targetId != null ? targetId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
