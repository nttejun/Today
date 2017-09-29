package today;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");

        JDBCconnect jdbCconnect = new JDBCconnect();

        String loginName = jdbCconnect.checkLogin(request.getParameter("userId"), request.getParameter("userPassword"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");

        if (loginName != null) {

            session.setAttribute("userLoginStatus", loginName);
            requestDispatcher.forward(request, response);

        } else {

            response.sendRedirect("/index.jsp");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
