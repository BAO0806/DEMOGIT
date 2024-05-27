/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author VQN
 */
public class AccountDAO {
    //Ham nay de lay tat ca cac dong trong bang account
    //Tra ve ArrayList<Account>

    public ArrayList<Account> getAllAcounts() {
        ArrayList<Account> list = new ArrayList<>();

        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //B2: Viet query va exec query

                String sql = "select AccId, Email, FullName, Password\n"
                        + "from [dbo].[Accounts]";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    //b3: Doc cac dong trong rs va cat vao ArrayList
                    while (rs.next()) {
                        int id = rs.getInt("AccId");
                        String email = rs.getString("Email");
                        String fullname = rs.getString("FullName");
                        String password = rs.getString("Password");
                        Account acc = new Account(id, fullname, email, password);

                        list.add(acc);
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

    //Ham nay de remove 1 dong bang Account
    //input: acc id can xoa
    //out: 1 / 0
    public int removeUser(int accid) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "delete from [dbo].[Accounts]\n"
                        + "where AccId=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, accid);
                result = pst.executeUpdate();
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
        return result;
    }

    //Ham nay de lay 1 dong trong bang account
    //input: email
    //out: account tim thay
    public Account getUser(String email) {
        Account acc = null;
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Accid, Email, FullName, Password from [dbo].[Accounts] where Email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("AccId");
                    String fullname = rs.getString("FullName");
                    String password = rs.getString("Password");
                    acc = new Account(id, fullname, email, password);
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
        return acc;

    }

    //Ham nay de insert 1 dong vao bang Account
    //Tra ve 1/0
     public int insertUser(String fullname, String email, String password) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert dbo.Accounts(Email,FullName,Password) values (?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, fullname);
                pst.setString(2, email);
                pst.setString(3, password);
                rs = pst.executeUpdate();
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

        return rs;
    }
}
