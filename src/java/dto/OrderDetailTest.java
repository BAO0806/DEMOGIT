/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author VQN
 */
public class OrderDetailTest implements Serializable {

    private int detailID;
    private int productID;
    private String productName;
    private int orderID;
    private int price;
    private String image;

    public OrderDetailTest() {
    }

    public OrderDetailTest(int detailID, int productID, String productName, int orderID, int price, String image) {
        this.detailID = detailID;
        this.productID = productID;
        this.productName = productName;
        this.orderID = orderID;
        this.price = price;
        this.image = image;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

  

}
