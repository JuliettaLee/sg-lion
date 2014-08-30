/**
 * Login Servlet
 *
 * @author Wen Xin
 */
package com.merlionportal.servlets;

import com.merlionportal.utility.MD5Generator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("q") != null){
            String result = MD5Generator.hash(request.getParameter("q"));
            PrintWriter pw = response.getWriter();
            pw.write("<html><head></head><body>");
            pw.write("<div>"+result+"</div><br/>");
            pw.write("<div>Length: "+result.length()+"</div>");
            pw.write("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
