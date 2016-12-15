package winter.dto;

/**
 * Created by lequan on 12/15/2016.
 */
public class Result
{
    String exercise;
    int score;

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

    public Result(String exercise, int score)
    {

        this.exercise = exercise;
        this.score = score;
    }
}
