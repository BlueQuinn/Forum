package winter.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.annotation.JsonGet;
import winter.model.Achievement;
import winter.model.Question;

import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/achievement")
public class AchievementController extends RestfulController<Achievement>
{
    /*public static Connection getOracleConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/chemistry";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, "root", "25051995");
        return conn;
    }

    @JsonGet("/hehe")
    public void a()
    {
        Connection connection = null;
        try
        {
*//*   File jar = new File("D:/Doc/IT/IV-1/Mobile/Project/Database/chemistry.sqlite");
            URL[] cp = new URL[1];
            cp[0] = jar.toURI().toURL();
            URLClassLoader ora8loader = new URLClassLoader(cp, ClassLoader.getSystemClassLoader());
            Class drvClass = ora8loader.loadClass("org.sqlite.JDBC");
            Driver driver = (Driver) drvClass.newInstance();

            Properties props = new Properties();
            Class.forName("org.sqlite.JDBC");
            connection = driver.connect("jdbc:sqlite:D:/Doc/IT/IV-1/Mobile/Project/Database/chemistry.sqlite", props);
          *//*
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
                        int id = rs.getInt("id");
                        String content = rs.getString("content");
                        int exerciseId = rs.getInt("topic_id");

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
    }*/
}
