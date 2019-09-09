package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/testdrie")
public class TestDrieServlet extends HttpServlet {

    private String username = "username";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().isNew()){
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        HttpSession session = req.getSession();

        if (name.isEmpty()){

            String message = ", gelieve een geldige naam in te voeren!";
            session.setAttribute("message",message);
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);

        }else{
            session.setAttribute("name",name);
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req,resp);
        }
    }


}
