<%-- 
    Document   : ManagerProductJSP
    Created on : May 15, 2024, 1:45:32 PM
    Author     : VQN
--%>

<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Manage Product</h1>
        <table>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Status</th>
                <th>Image</th>

            </tr>
            <%
                ProductDAO proDAO = new ProductDAO();
                ArrayList<Product> productList = proDAO.getAllProduct();
                for (Product p : productList) {
                    out.print("<tr>");
                    out.print("<th>" + p.getProductID() + "</th>");
                    out.print("<th>" + p.getProductName() + "</th>");
                    out.print("<th>" + p.getProductPrice() + "</th>");
                    out.print("<th>" + p.getProductStatus() + "</th>");
                    out.print("<th>" + p.getProductImage() + "</th>");
                    out.print("</tr>");
                }
            %>
            
           
        </table>
    </body>
</html>
