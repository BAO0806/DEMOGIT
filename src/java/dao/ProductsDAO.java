/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class ProductsDAO {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = new ArrayList<>();

        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //B2: Viet query va exec query

                String sql = "SELECT [ItemId]\n"
                        + "      ,[ItemName]\n"
                        + "      ,[Price]\n"
                        + "      ,[Status]\n"
                        + "      ,[Image]\n"
                        + "  FROM [dbo].[Items]";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    //b3: Doc cac dong trong rs va cat vao ArrayList
                    while (rs.next()) {
                        int productID = rs.getInt("ItemId");
                        String productName = rs.getString("ItemName");
                        int productPrice = rs.getInt("Price");
                        int productStatus = rs.getInt("Status");
                        String productImage = rs.getString("Image");

                        Product pro = new Product(productID, productName, productPrice, productStatus, productImage);
                        productList.add(pro);
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

        return productList;
    }
}
