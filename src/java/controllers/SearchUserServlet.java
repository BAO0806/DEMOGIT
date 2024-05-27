/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VQN
 */
public class SearchUserServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("txtsearch");
            AccountDAO d = new AccountDAO();

            Account acc = d.getUser(email.trim());

            if (acc == null) {
                out.print("<p>Not found</p>");
                out.print("<a href='ManageUserServlet'></a>");
            } else {
                out.print("<form action='SearchUserServlet'>");
                out.print("<input type='text'  name='txtsearch' placeholder='enter email' />");
                out.printf("<input type='submit' value='Go'/>");
                out.print("</form>");

                out.print("<table>");
                out.print("<tr><th>id</th><th>name</th><th>email</th><th>password</th></tr>");
                out.print("<tr>");
                out.print("<td>" + acc.getId() + "</td>");
                out.print("<td>" + acc.getFullname() + "</td>");
                out.print("<td>" + acc.getEmail() + "</td>");
                out.print("<td>" + acc.getPassword() + "</td>");
                out.print("<td><a href='RemoveUserServlet?id=" + acc.getId() + "' onclick='return window.confirm(\"Co chac muon xoa? \")' >remove</a></td>");
                out.print("</tr>");
                out.print("</table>");
            }
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
