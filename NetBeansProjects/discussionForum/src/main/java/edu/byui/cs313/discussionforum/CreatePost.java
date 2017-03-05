/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.discussionforum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;

/**
 *
 * @author zaccianflone
 */
@WebServlet(name = "CreatePost", urlPatterns = {"/CreatePost"})
public class CreatePost extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
  
        String username = request.getParameter("Username");
        
        //quick and dirty way to skip straight to posts.  if we link straight to page, existing posts won't load
        //existing issue where this causes an internal error if there are no posts.
        if (!username.equals("skipToPosts")){
            
        String newPost = request.getParameter("postText");
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String currTime = df.format(dateobj).toString();
        
        String prepPost = username + "~" +newPost + "~" + currTime +"&";
        
           String filename = "/WEB-INF/posts.txt";
        
        ServletContext context = getServletContext();
        String filepath = context.getRealPath(filename);
        
        //FileOutputStream is = context.getResourceAsStream(filename);
        
    try(FileWriter fw = new FileWriter(filepath, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
    {
    out.println(prepPost);   
    } catch (IOException e) {
   
    }
}
        else{
            System.out.println("skipped");
        }
    
      
              
        String filenameread = "/WEB-INF/posts.txt";
        
        ServletContext context2 = getServletContext();
        
        InputStream is = context2.getResourceAsStream(filenameread);
        
        String content ="";
        
        if(is != null){
                
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);
                String text = "";
                
                while ((text = reader.readLine()) != null) {
                    content+=text;
                }
                
               String[] posts = content.split("&");
               
               List<Post> postList = new ArrayList<Post>();
               
               
               for (String post : posts)
               {
                   
                
                String [] onePost = post.split("~");
                
                   //username is first, posttext is second, currtime is last
                   Post postToAdd = new Post(onePost[0], onePost[1], onePost[2]);
                   
                   postList.add(postToAdd);
               }
           
                request.getSession().setAttribute("posts", postList);
                response.sendRedirect("viewPosts.jsp");
             
        }
        else {
            System.out.println("Null File...");
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
