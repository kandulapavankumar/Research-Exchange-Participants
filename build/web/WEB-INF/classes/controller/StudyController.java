package controller;

import db.StudyDB;
import db.UserDB;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Study;
import model.User;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@WebServlet(name = "StudyController", urlPatterns = {"/StudyController"})
public class StudyController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String StudyCode = request.getParameter("StudyCode");
        String choice = request.getParameter("choice");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("theUser");
        String url;
        StudyDB studyDB = new StudyDB();
        //List<Study>=request.getParameter("study");

//        if (session.getAttribute("theUser")==null) {
//            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
//            } 
//            else {
//            getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
//            }
        if ("participate_page".equals(action)) {

            if (session.getAttribute("Studies") == null) {
                session.setAttribute("Studies", studyDB.getStudies());
            }
            if (user == null) {
                url = "login.jsp";
            } else {

                url = "participate.jsp";
                session.setAttribute("StudiesParticipate", studyDB.getStudiesParticipate(user.getEmail()));
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("participate".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "question.jsp";
                String studyCode = request.getParameter("studyCode");
                Study study = studyDB.getStudy(studyCode);
                session.setAttribute("Study", study);
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("studies".equalsIgnoreCase(action)) {
           
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "studies.jsp";
                session.setAttribute("Studies", studyDB.getStudies(user.getEmail()));
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("newstudy_pg".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "newstudy.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("newstudy".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhmmss");
                url = "studies.jsp";
                String studyname = request.getParameter("studyname");
                String questiontext = request.getParameter("question");
                //String image_upload = request.getParameter("image_upload");
                String image_upload = String.valueOf(session.getAttribute("newImageUploadFilePath"));
                String participants = request.getParameter("participants");
                String description = request.getParameter("description");
                
                
                
                //Study study = new Study(questiontext, "Sample3", studyname, "ddmmyy", "@", image_upload, participants, "0", description, "Stop", null);
                //Study study = new Study(studyname, "3", "01/09/2015", "varun@abc.com", questiontext, participants, "10", description, "Start", image_upload, "answers");
                Study study = new Study(studyname, "studyname" + sdf.format(new Date()), "2015-11-03 00:00:00" , user.getEmail() ,questiontext, participants, "0", description, "Stop",image_upload, null);
                int status = studyDB.addstudy(study);
                if (status == 1) {
                    session.setAttribute("Studies", studyDB.getStudies(user.getEmail()));
                    request.setAttribute("message", "New study added successfully");
                } else {
                    request.setAttribute("message", "Exception in adding a new study. Please contact administrator.");
                }
//                List<Study> studies = (List) session.getAttribute("Studies");
//                studies.add(study);
               //session.setAttribute("Studies", studies);
//
//                request.setAttribute("message", "New study added successfully");
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
           
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "editstudy.jsp";

                session.setAttribute("myStudy", studyDB.getStudy(request.getParameter("studyCode")));
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("editstudy".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "studies.jsp";
                Study study = new Study();
                String studyCode = request.getParameter("studyCode");
                study.setCode(studyCode);
                System.out.println(studyCode);
                String studyname = request.getParameter("studyname");
                study.setName(studyname);

                String questiontext = request.getParameter("questiontext");
                study.setQuestion(questiontext);
                System.out.println("questiontext is " +questiontext);

                //String image_upload = request.getParameter("image_upload");
                if (session.getAttribute("getImage") != null) {
                    study.setGetImage(String.valueOf(session.getAttribute("getImage")));
                }
                String participants = request.getParameter("participants");
                study.setRequestedparticipants(participants);
                System.out.println("participants" + participants);
                String description = request.getParameter("description");
                study.setDescription(description);
                int status = studyDB.editStudy(study);
                session.setAttribute("Studies", studyDB.getStudies(user.getEmail()));
                request.setAttribute("message", "Study updated successfully");
            }
                session.setAttribute("newImageUploadFilePath", null);
                response.sendRedirect(url);
            
        } 
        else if ("stop".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "studies.jsp";
                String studyCode = request.getParameter("studyCode");
                Study study = studyDB.getStudy(studyCode);
                study.setStatus("Stop");
                int status = studyDB.editStatus(study);
                session.setAttribute("Studies", studyDB.getStudies(user.getEmail()));
            }
            response.sendRedirect(url);

//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
        } else if ("start".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "studies.jsp";
                String studyCode = request.getParameter("studyCode");
                Study study = studyDB.getStudy(studyCode);
                study.setStatus("Start");
                int status = studyDB.editStatus(study);
                session.setAttribute("Studies", studyDB.getStudies(user.getEmail()));
            }
             response.sendRedirect(url);

//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
        } else if ("answer".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "participate.jsp";
                String studyCode = request.getParameter("studyCode");
                String answer = request.getParameter("answer");
                String email = user.getEmail();

                int status = studyDB.submitAnswer(studyCode, answer, user.getEmail());
                if (status == 1) {
                    studyDB.updateParticipation(user.getEmail());
                    //session.setAttribute("User", userDB.getUser(email));
                    
                    session.setAttribute("StudiesParticipate", studyDB.getStudiesParticipate(user.getEmail()));
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("recommend".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "recommend.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } 
        
        else if ("confirmr".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "confirmr.jsp";
                try {
                    String senderemail = request.getParameter("senderemail");
                    String receiveremail = request.getParameter("receiveremail");
                    //String message = request.getParameter("message");
                    
                    //email starts
                    
         final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
       // Get a Properties object
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
         props.setProperty("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.auth", "true");
         props.put("mail.debug", "true");
         props.setProperty("mail.smtp.socketFactory.port", "465");
         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.setProperty("mail.smtp.socketFactory.fallback", "false");
         props.setProperty("mail.smtp.port", "465");
         
         
        
         props.put("mail.store.protocol", "pop3");
         
         final String username = "varunamin1990@gmail.com";
         final String password = "19902decembergujarat";
 
               Session sessionuser = Session.getDefaultInstance(props, 
               new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }
                });

                // -- Create a new message --
                Message message = new MimeMessage(sessionuser);

               // -- Set the FROM and TO fields --
                message.setFrom(new InternetAddress(senderemail));
                message.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(receiveremail,false));
                message.setSubject("SMTP email Test");
                message.setText("email test");
                message.setSentDate(new Date());
                
                Session session_mail = sessionuser.getInstance(props,null);
                Transport transport = session_mail.getTransport("smtps");
                transport.connect ("smtp.gmail.com", 465, username, password);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();   
                
                Transport.send(message);
                System.out.println("Message sent.");
            }
            catch (MessagingException e)
            { 
                System.out.println("ERROR: " + e);
            }
                getServletContext().getRequestDispatcher("/confirmr.jsp").forward(request, response); 
         } 
     }
          
        
        
        else if ("contact".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "contact.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if ("confirmc".equalsIgnoreCase(action)) {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "confirmc.jsp";
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String message = request.getParameter("message");
                try {
                   // EmailUtil.sendEmail(email, "Message from: " + name + ". Sent using REP", message);
                    request.setAttribute("msg", "Message sent successfully");
                } catch (Exception ex) {
                    request.setAttribute("msg", "Unable to send message. Please try again after some time");
                    Logger.getLogger(StudyController.class.getName()).log(Level.SEVERE, null, ex); 
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            if (user == null) {
                url = "login.jsp";
            } else {
                url = "main.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(StudyController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(StudyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
