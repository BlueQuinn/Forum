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
public class Exercise implements Serializable
{
    private int id;
    private Integer ownerId;
    private String nane;
    private String content;

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
    @Column(name = "ownerId", nullable = true)
    public Integer getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId)
    {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 32)
    public String getNane()
    {
        return nane;
    }

    public void setNane(String nane)
    {
        this.nane = nane;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 512)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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

        Exercise exercise = (Exercise) o;

        if (id != exercise.id)
        {
            return false;
        }
        if (ownerId != null ? !ownerId.equals(exercise.ownerId) : exercise.ownerId != null)
        {
            return false;
        }
        if (content != null ? !content.equals(exercise.content) : exercise.content != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
