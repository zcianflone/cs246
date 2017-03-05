/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.discussionforum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zaccianflone
 */
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
              
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        Boolean match = false;
              
        String filename = "/WEB-INF/logins.txt";
        
        ServletContext context = getServletContext();
        
        InputStream is = context.getResourceAsStream(filename);
        
        if(is != null){
                
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);
                String text = "";
                
                while ((text = reader.readLine()) != null) {
                    String [] loginPair = text.split("/");
                    String savedUsername = loginPair[0];
                    String savedPass = loginPair[1];
                    
                   if (username != null && password != null
                    && username.equals(savedUsername) && password.equals(savedPass)) {
                            // correct username and password!
                               request.getSession().setAttribute("username", username);
                               response.sendRedirect("newPost.jsp");
                               match = true;
                    } 
                    
                    
                }
        }
        
        //if we're unable to find a match, then we redirect to badlogin
        if (match == false){
            response.sendRedirect("badLogin.jsp");
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
        processRequest(request, response);
        
        
    }

 
   

}
