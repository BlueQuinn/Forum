package winter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Result
{
    private Integer userId;
    private Integer exerciseId;
    private Integer score;

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
    @Column(name = "exerciseId", nullable = true)
    public Integer getExerciseId()
    {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
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

        Result result = (Result) o;

        if (userId != null ? !userId.equals(result.userId) : result.userId != null)
        {
            return false;
        }
        if (exerciseId != null ? !exerciseId.equals(result.exerciseId) : result.exerciseId != null)
        {
            return false;
        }
        if (score != null ? !score.equals(result.score) : result.score != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (exerciseId != null ? exerciseId.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
