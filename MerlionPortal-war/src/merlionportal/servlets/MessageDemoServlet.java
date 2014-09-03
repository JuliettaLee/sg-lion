package merlionportal.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import merlionportal.messagingmodule.MessagesDemoBean;

@WebServlet(name = "MessageDemo", urlPatterns = {"/createMsg"})
public class MessageDemoServlet extends HttpServlet {

    @EJB
    MessagesDemoBean messagesDemoBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
}
