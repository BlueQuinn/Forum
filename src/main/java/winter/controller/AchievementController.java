package winter.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.model.Achievement;
import winter.model.Exercise;
import winter.model.Question;

import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/achievement")
public class AchievementController extends RestfulController<Achievement>
{
    public static Connection getOracleConnection() throws Exception
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/chemistry";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, "root", "25051995");
        return conn;
    }

    @JsonGet("/hihi")
    public void hihi() throws Exception
    {
        Connection  connection = getOracleConnection();
        Statement statement = connection.createStatement();
        Random random = new Random();

        Exercise exercise;
        ResultSet rs = statement.executeQuery("select * from topics where id > 3 and id < 15");
        while (rs.next())
        {
            int id = rs.getInt("id") + 45;
            String name = rs.getString("title");
            int diff = random.nextInt(5);
            String difficulty;
            switch (diff)
            {
                case 0:
                    difficulty = "Dễ";
                    break;
                case 1:
                    difficulty = "Trung bình";
                    break;
                case 2:
                    difficulty = "Khó";
                    break;
                case 3:
                    difficulty = "Rất khó";
                    break;
                default:
                    difficulty = "Rất dễ";
                    break;
            }

            exercise  = new Exercise();
            exercise.setId(id);
            exercise.setName(name);
            exercise.setSubjectId(6);
            exercise.setDifficulty(difficulty);

            Serializable i=   service.add(exercise);
            System.out.println(i);
        }
        if (connection != null)
        {
            connection.close();
        }
    }

    @JsonGet("/hehe")
    public void a()
    {
        Connection connection = null;
        try
        {

            connection = getOracleConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            int count = 0;
            Question question = new Question();

            ResultSet rs = statement.executeQuery("select Q.id, Q.content, Q.topic_id, A.content as A_content from answers A, questions Q where A.question_id = Q.id");
            while (rs.next())
            {
                String answer = rs.getString("A_content");
                switch (count)
                {
                    case 0:
                    {
                        question = new Question();
                        question.setA(answer);
                        break;
                    }

                    case 1:
                        question.setB(answer);
                        break;

                    case 2:
                        question.setC(answer);
                        break;

                    case 3:
                    {
                        int id = rs.getInt("id") + 1915;
                        String content = rs.getString("content");
                        int exerciseId = rs.getInt("topic_id") + 45;

                        question.setId(id);
                        question.setContent(content);
                        question.setExerciseId(exerciseId);
                        question.setD(answer);

                        Serializable i = service.add(question);
                        System.out.println(i);

                        count = 0;
                        continue;
                    }
                }
                count++;

            }
        }
        catch (SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
