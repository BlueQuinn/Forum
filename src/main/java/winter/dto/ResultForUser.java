package winter.dto;

/**
 * Created by lequan on 12/15/2016.
 */
public class ResultForUser
{
    int exerciseId;
    String exercise;
    int score;

    public int getExerciseId()
    {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    public String getExercise()
    {
        return exercise;
    }

    public void setExercise(String exercise)
    {
        this.exercise = exercise;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
