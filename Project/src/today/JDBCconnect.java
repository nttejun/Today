package today;

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by nttej on 2017-09-21.
 */
public class JDBCconnect {
    public String checkLogin(String userId, String userPassword) {

        String loginName = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Today", "root", "1234");

            String sql = "SELECT userId, userPassword, userName FROM Today.User WHERE userId = ? AND userPassword = ? ";

            PreparedStatement preparedStatement = null;

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, userId);

            preparedStatement.setString(2, userPassword);

            ResultSet resultSet = null;

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                loginName = resultSet.getString("userName");

            }

            resultSet.close();
            preparedStatement.close();

            if (!con.isClosed())

                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

            con.close();

        } catch (SQLException sqex) {

            System.out.println("SQLException: " + sqex.getMessage());

            System.out.println("SQLState: " + sqex.getSQLState());

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return loginName;

    }
}

