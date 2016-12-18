package winter.dto;

/**
 * Created by lequan on 12/18/2016.
 */
public class Subscription
{
    int id;
    String subjectName;

    public Subscription(){}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }
}
