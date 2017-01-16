package winter.dto;

/**
 * Created by lequan on 1/12/2017.
 */
public class Exercise       // not yet used
{
    int id;
    int subjectName;
    String name;
    String content;
    String difficulty;
    long examineeCount;

    int bestExamineeId;
    String bestExamineeName;
    long bestScore;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(int subjectName)
    {
        this.subjectName = subjectName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public long getExamineeCount()
    {
        return examineeCount;
    }

    public void setExamineeCount(long examineeCount)
    {
        this.examineeCount = examineeCount;
    }

    public int getBestExamineeId()
    {
        return bestExamineeId;
    }

    public void setBestExamineeId(int bestExamineeId)
    {
        this.bestExamineeId = bestExamineeId;
    }

    public String getBestExamineeName()
    {
        return bestExamineeName;
    }

    public void setBestExamineeName(String bestExamineeName)
    {
        this.bestExamineeName = bestExamineeName;
    }

    public long getBestScore()
    {
        return bestScore;
    }

    public void setBestScore(long bestScore)
    {
        this.bestScore = bestScore;
    }
}
