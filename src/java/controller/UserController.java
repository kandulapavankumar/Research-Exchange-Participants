package controller;

import db.UserDB;
import model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Varun Amin
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String email = String.valueOf(request.getParameter("email"));
        String password = String.valueOf(request.getParameter("password"));
        String signup = request.getParameter("signup");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("Remote_port")) {
                session.setAttribute("Remote_port", cookie.getValue());
            }
            if (cookie.getName().equalsIgnoreCase("Remote_host")) {
                session.setAttribute("Remote_host", cookie.getValue());
            }
        }

        if (action == null) {
            String hostname = request.getServerName();
            String portnum = Integer.toString(request.getServerPort());
            Cookie c1 = new Cookie("host", hostname);
            Cookie c2 = new Cookie("port", portnum);
            c1.setPath("/");
            c2.setPath("/");
            response.addCookie(c1);
            response.addCookie(c2);
            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
            rd.forward(request, response);
        }
        //login
//        try{
//            String dbURL="jdbd:mysql://http://localhost:8080/JSP_Web_Site_Prototyping/home.jsp";
//            email="root";
//            password="varun";
//            Connection connection= DriverManager.getConnection(dbURL,email,password);
//        }
//        catch(SQLException e){
//            for(Throwable t:e)
//                t.printStackTrace();
//        }

        if ("login".equals(action)) {
            if (user != null) {
                getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
            } else {
                email = String.valueOf(request.getParameter("email"));
                password = String.valueOf(request.getParameter("password"));
                UserDB u = new UserDB();
                User loggedInUser = u.getUser(email, password);
                if (loggedInUser != null) {
                    
                    session.setAttribute("theUser", loggedInUser);
                    getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Invalid username and/or password.");
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }

        //signup
        if ("create".equals(action)) {
            if (user != null) {
                RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
                rd.forward(request, response);
            } else {
                String name = request.getParameter("name");
                String semail = request.getParameter("semail");
                String spassword = request.getParameter("spassword");
                String cpassword = request.getParameter("cpassword");

                if (!spassword.equals(cpassword)) {
                    String message = "Both passwords do not match";
                    RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
                    rd.forward(request, response);

                } else {

                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setName(name);
                    session.setAttribute("theUser", newUser);
                    RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
                    rd.forward(request, response);

                }
            }
        }

        //how
        if ("how".equals(action)) {
            if (session.getAttribute("theUser") == null) {
                getServletContext().getRequestDispatcher("/how.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
            }
        }

        //about
        if ("about".equals(action)) {
            if (session.getAttribute("theUser") == null) {
                getServletContext().getRequestDispatcher("/about.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/aboutl.jsp").forward(request, response);
            }
        }

        //home
        if ("home".equals(action)) {
            if (session.getAttribute("theUser") == null) {
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
            }
        }

        if ("main".equals(action)) {
            if (session.getAttribute("theUser") == null) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
