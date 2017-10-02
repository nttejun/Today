package today;

import org.json.simple.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nttej on 2017-09-21.
 */
public class JDBCconnect {

    public static Connection jdbc() {

        Connection connection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Today", "root", "1234");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return connection;

    }


    public String checkLogin(String userId, String userPassword) {

        String loginName = null;

        try {

            Connection connection = jdbc();

            String sql = "SELECT userId, userPassword, userName FROM Today.User WHERE userId = ? AND userPassword = ? ";

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userId);

            preparedStatement.setString(2, userPassword);

            ResultSet resultSet = null;

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                loginName = resultSet.getString("userName");

            }

            resultSet.close();

            preparedStatement.close();

            if (!connection.isClosed())

                System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");

            connection.close();

        } catch (SQLException sqex) {

            System.out.println("SQLException: " + sqex.getMessage());

            System.out.println("SQLState: " + sqex.getSQLState());

        }

        return loginName;

    }

    public JSONObject mainReset() {

        Connection connection = jdbc();

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        String sql = "SELECT * FROM board";

        List<String> data = new ArrayList<>();

        List<String> seq = new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();

        JSONObject jsonObject = new JSONObject();

        try {

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                seq.add(Integer.toString(resultSet.getInt("seq")));
                data.add(resultSet.getString("title"));

            }

            hashMap.put("seq", seq);
            hashMap.put("data", data);

            System.out.println(hashMap);
            jsonObject.putAll(hashMap);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return jsonObject;

    }


    public static void main(String[] args) {

        System.out.println(jdbc());

    }
}

