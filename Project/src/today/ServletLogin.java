package today;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nttej on 2017-09-29.
 */
@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");

        JDBCconnect jdbCconnect = new JDBCconnect();

        jdbCconnect.checkLogin(userId, userPassword);


        UserDO userDO = new UserDO();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");

        if (userDO.getUserId() != null) {

            requestDispatcher.forward(request, response);

        } else {

            response.sendRedirect("/index.jsp");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
