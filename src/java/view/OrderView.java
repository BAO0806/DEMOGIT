/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VQN
 */
public class OrderView extends HttpServlet {

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
            out.print("<form action='ManageOrderServlet' id='f'>");
            out.print("<select name='txtstatus' onchange='document.getElementById(\"f\").submit()'>");
            out.print("<option value=''> select order's status </option>");
            out.print("<option value='1'> Pending </option>");
            out.print("<option value='2'> Processing </option>");
            out.print("<option value='3'> Complete </option>");
            out.print("<option value='4'> Cancel </option>");
            out.print("</select>");
            out.print("</form>");

            //Cho nay de xuat cac orders
            String[] arr = {"", "Pending", "Processing", "Complete", "Cancel"};
            HttpSession session = request.getSession();
            ArrayList<Order> list = (ArrayList<Order>) session.getAttribute("ListOrders");

            if (list != null) {
                out.print("<table>");
                out.print("<tr><th>ID</th><th>OrderDate</th><th>Customer</th><th>Status</th></tr>");
                for (Order d : list) {
                    out.print("<tr>");
                    out.print("<td>" + d.getOrderID() + "</td>");
                    out.print("<td>" + d.getOrderDate() + "</td>");
                    out.print("<td>" + d.getAccid() + "</td>");
                    out.print("<td>" + arr[d.getStatus()] + "</td>");
                    out.print("<td><a href='#'> Processing</a></td>");
                    out.print("<td><a href='#'> Complete</a></td>");
                    out.print("<td><a href='#'> Cancel</a></td>");
                    out.print("<td><a href='#'> Detail</a></td>");
                    out.print("</tr>");
                }
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
