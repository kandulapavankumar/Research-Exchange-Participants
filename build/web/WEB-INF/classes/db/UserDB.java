package db;

import model.ConnectionPool;
import model.User;
import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pinkesh
 */
public class UserDB {

    ConnectionPool pool;
    Connection connection;

    public UserDB() {
        pool = ConnectionPool.getInstance();
        
    }

    public User getUser(String email, String password) {
        PreparedStatement ps = null;
        connection = pool.getConnection();
        User user = null;
        String pass;
        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                pass = resultSet.getString("password");
                if (pass.equals(password)) {
                    user = new User(resultSet.getString("name"), resultSet.getString("email"), resultSet.getInt("coins"), resultSet.getInt("participations"), resultSet.getInt("participation"));
                    return user;
                } else {
                    return user;
                }
            } else {
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public List<User> getUsers() {
        return new ArrayList<User>() {
        };
    }

    public int createUser(String name, String semail, String spassword) {
        PreparedStatement ps = null;
        connection = pool.getConnection();
        String query
                = "INSERT INTO User (name, email, password, participations, participation, coins) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, semail);
            ps.setString(3, spassword);
            ps.setString(4, "0");
            ps.setString(5, "0");
            ps.setString(6, "0");
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public boolean emailExists(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = pool.getConnection();
        String query = "SELECT Email FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}