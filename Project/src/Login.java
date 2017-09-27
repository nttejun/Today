/**
 * Created by nttej on 2017-09-25.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");

        JDBCconnect jdbCconnect = new JDBCconnect();
        int loginReuslt = jdbCconnect.loginCheck(userId, userPassword);

        PrintWriter writer = response.getWriter();
        writer.println("<html><head></head><body>");
        writer.println("아이디 : " + userId + "<br/>");
        writer.println("비밀번호 : " + userPassword + "<br/>");
        writer.println("</body></html>");
        writer.close();
    }
}
