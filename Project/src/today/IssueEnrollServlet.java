package today;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nttej on 2017-10-04.
 */
@WebServlet(name = "IssueEnrollServlet")
public class IssueEnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        JDBCconnect jdbCconnect = new JDBCconnect();
        jdbCconnect.issueEnroll(title, contents);

    }

}
