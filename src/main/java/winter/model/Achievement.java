package winter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Achievement
{
    private Integer userId;
    private Integer badgeId;

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
    @Column(name = "badgeId", nullable = true)
    public Integer getBadgeId()
    {
        return badgeId;
    }

    public void setBadgeId(Integer badgeId)
    {
        this.badgeId = badgeId;
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

        Achievement that = (Achievement) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
        {
            return false;
        }
        if (badgeId != null ? !badgeId.equals(that.badgeId) : that.badgeId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (badgeId != null ? badgeId.hashCode() : 0);
        return result;
    }
}
