package winter.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
public class Result
{
    private int id;
    private Integer userId;
    private Integer exerciseId;
    private Integer score;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getExerciseId()
    {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

}
