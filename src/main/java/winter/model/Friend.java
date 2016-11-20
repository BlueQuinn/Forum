package winter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Friend
{
    private Integer user1;
    private Integer user2;

    @Basic
    @Column(name = "user1", nullable = true)
    public Integer getUser1()
    {
        return user1;
    }

    public void setUser1(Integer user1)
    {
        this.user1 = user1;
    }

    @Basic
    @Column(name = "user2", nullable = true)
    public Integer getUser2()
    {
        return user2;
    }

    public void setUser2(Integer user2)
    {
        this.user2 = user2;
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

        Friend friend = (Friend) o;

        if (user1 != null ? !user1.equals(friend.user1) : friend.user1 != null)
        {
            return false;
        }
        if (user2 != null ? !user2.equals(friend.user2) : friend.user2 != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = user1 != null ? user1.hashCode() : 0;
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        return result;
    }
}
