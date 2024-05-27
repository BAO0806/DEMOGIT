/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.OrderDetailTest;
import dto.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author VQN
 */
public class OrderDetailTestDAO {

    public ArrayList<OrderDetailTest> getAllOrderDetail() {
        ArrayList<OrderDetailTest> orderDetailList = new ArrayList<>();

        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //B2: Viet query va exec query

                String sql = "SELECT DetailID, i.ItemId, ItemName, OrderID, Price, Image FROM OrderDetails od INNER JOIN Items i ON od.ItemID = i.ItemId";

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    //b3: Doc cac dong trong rs va cat vao ArrayList
                    while (rs.next()) {
                        int detailID = rs.getInt("DetailID");
                        int productID = rs.getInt("ItemId");
                        String productName = rs.getString("ItemName");
                        int orderID = rs.getInt("OrderID");
                        int price = rs.getInt("Price");
                        String image = rs.getString("Image");
                        OrderDetailTest od = new OrderDetailTest(detailID, productID, productName, orderID, price, image);
                        System.out.println(od);
                        orderDetailList.add(od);
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

        return orderDetailList;
    }
}
