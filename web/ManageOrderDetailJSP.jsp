<%-- 
    Document   : ManageOrderDetailJSP
    Created on : May 15, 2024, 7:57:52 PM
    Author     : VQN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDetailDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Manage Order Detail</h1>
        <%
            ArrayList<OrderDetail> orderLists = (ArrayList<OrderDetail>) request.getAttribute("orderDetails");
        %>
        <table border = "1">
            <tr>
                <th>Detail ID</th>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Order ID</th>
                <th>Price</th>
                <th>Image</th>
            </tr>
            <%
                for (OrderDetail o : orderLists) {
                    out.print("<tr>");
                    out.print("<th>" + o.getDetailID() + "</th>");
                    out.print("<th>" + o.getProductID() + "</th>");
                    out.print("<th>" + o.getProductName() + "</th>");
                    out.print("<th>" + o.getOrderID() + "</th>");
                    out.print("<th>" + o.getPrice() + "</th>");
                    out.print("<th>" + o.getImage() + "</th>");
                    out.print("</tr>");
                }
            %>
        </table> 

        <table border = "1">
            <tr>
                <th>Detail ID</th>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Order ID</th>
                <th>Price</th>
                <th>Image</th>
            </tr>
            <c:forEach var="order" items="${requestScope.orderDetails}">
                <tr>
                    <th>${order.detailID}</th>
                    <th>${order.productID}</th>
                    <th>${order.productName}</th>
                    <th>${order.orderID}</th>
                    <th>${order.price}</th>
                    <th>${order.image}</th>
                </tr>
            </c:forEach>
        </table> 
    </body>
</html>
