package winter.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lequan on 11/20/2016.
 */
@Entity
public class User implements Serializable
{
    private int id;
    private String username;
    private String password;
    private String email;
    private Integer role;

    public User(String email, String password)
    {
        this.password = password;
        this.email = email;
    }

    public User()
    {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 32)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 32)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "role", nullable = true)
    public Integer getRole()
    {
        return role;
    }

    public void setRole(Integer role)
    {
        this.role = role;
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

        User user = (User) o;

        if (id != user.id)
        {
            return false;
        }
        if (username != null ? !username.equals(user.username) : user.username != null)
        {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null)
        {
            return false;
        }
        if (email != null ? !email.equals(user.email) : user.email != null)
        {
            return false;
        }
        if (role != null ? !role.equals(user.role) : user.role != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
