/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author VQN
 */
public class OrderDAO {
    //Ham nay de lay cac order trong DB dua vao status
    ///Tra ve array cac orders

    public ArrayList<Order> getAllOrder(int status) {
        ArrayList<Order> list = new ArrayList<>();

        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID,OrderDate,Status,Total,AccID\n"
                        + "from dbo.Orders\n"
                        + "where Status=?\n"
                        + "Order by OrderDate desc";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                
                ResultSet rs = pst.executeQuery();
                if (rs != null){
                    while (rs.next()){
                        int orderID = rs.getInt("OrderID");
                        Date date = rs.getDate("OrderDate");
                        int total = rs.getInt("Total");
                        int accID = rs.getInt("AccID");
                        Order d = new Order(orderID, date, status, total, accID);
                        list.add(d);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
