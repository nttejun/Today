import java.sql.*;
import java.util.Properties;

/**
 * Created by nttej on 2017-09-21.
 */
public class JDBCconnect {
    public void jdbc() {

        try {

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");

            java.sql.Statement st = null;

            ResultSet rs = null;

            st = con.createStatement();

            rs = st.executeQuery("use Today");

            if (st.execute("use Today")) {

                rs = st.getResultSet();

            }


            while (rs.next()) {

                String str = rs.getNString(1);

                System.out.println(str);

            }

        } catch (SQLException sqex) {

            System.out.println("SQLException: " + sqex.getMessage());

            System.out.println("SQLState: " + sqex.getSQLState());

        }

    }


    public int loginCheck(String userId, String userPassword) {

        try {

            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:8002/login", "root", "1234");

            ResultSet resultSet = null;

            PreparedStatement preparedStatement = null;

            String sql = "use Today; select userId, userPassword from User";

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userPassword);

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String str = resultSet.getNString(1);

                System.out.println(str+ " 결과 ");

            }

        } catch (SQLException sqex) {

            System.out.println("SQLException: " + sqex.getMessage());

            System.out.println("SQLState: " + sqex.getSQLState());

        }

        return 1;
    }

    public static void main(String[] args){
        JDBCconnect jdbc = new JDBCconnect();
        jdbc.jdbc();
    }
}

