package winter.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class Question implements Serializable
{
    private int id;
    private Integer exerciseId;
    private String content;
    private String a;
    private String b;
    private String c;
    private String d;

    @Id
    @Column(name = "id", nullable = false)
   /* @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
    @Column(name = "content", nullable = true, length = 1024)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "A", nullable = true, length = 128)
    public String getA()
    {
        return a;
    }

    public void setA(String a)
    {
        this.a = a;
    }

    @Basic
    @Column(name = "B", nullable = true, length = 128)
    public String getB()
    {
        return b;
    }

    public void setB(String b)
    {
        this.b = b;
    }

    @Basic
    @Column(name = "C", nullable = true, length = 128)
    public String getC()
    {
        return c;
    }

    public void setC(String c)
    {
        this.c = c;
    }

    @Basic
    @Column(name = "D", nullable = true, length = 128)
    public String getD()
    {
        return d;
    }

    public void setD(String d)
    {
        this.d = d;
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

        Question question = (Question) o;

        if (id != question.id)
        {
            return false;
        }
        if (exerciseId != null ? !exerciseId.equals(question.exerciseId) : question.exerciseId != null)
        {
            return false;
        }
        if (a != null ? !a.equals(question.a) : question.a != null)
        {
            return false;
        }
        if (b != null ? !b.equals(question.b) : question.b != null)
        {
            return false;
        }
        if (c != null ? !c.equals(question.c) : question.c != null)
        {
            return false;
        }
        if (d != null ? !d.equals(question.d) : question.d != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (exerciseId != null ? exerciseId.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }
}
