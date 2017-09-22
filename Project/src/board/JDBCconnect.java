package board;

import java.sql.*;
import java.util.Properties;

/**
 * Created by nttej on 2017-09-21.
 */
public class JDBCconnect {

    public static void main(String[] args) {

        try {

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");

            java.sql.Statement st = null;

            ResultSet rs = null;

            st = con.createStatement();

            rs = st.executeQuery("SHOW DATABASES");


            if (st.execute("SHOW DATABASES")) {

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

}

