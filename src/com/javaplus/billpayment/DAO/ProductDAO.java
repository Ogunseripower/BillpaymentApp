/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.ProductBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSTECH
 */
public class ProductDAO {
    
    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;
    
    public int addProductRecord(ProductBean bean) {
        int status = -1;
        String query = "insert into products values(?,?,?,?,?)";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProductId());
            ps.setString(2, bean.getProductTypeId());
            ps.setString(3, bean.getProduct());
            ps.setString(4, bean.getProductDescription());
            ps.setString(5, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int updateProductRecord(ProductBean bean) {
        int status = -1;
        String query = "update products set product = ?, product_description = ? where product_id = ?";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProduct());
            ps.setString(2, bean.getProductDescription());
            ps.setString(3, bean.getProductId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int deleteProductRecord(String productId) {
        int status = -1;
        String querry = "delete from products where product_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, productId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            }
            else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public ProductBean getProductRecord(String productId) {
        ProductBean pb = new ProductBean();

        String query = "select * from products where product_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, productId);
            result = ps.executeQuery();
            if (result.next()) {
                pb.setProductId(result.getString("product_type_id"));
                pb.setProductTypeId(result.getString("product_type_Id"));
                pb.setProduct(result.getString("product"));
                pb.setProductDescription(result.getString("product_description"));
                pb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pb;
    }
    
    public List<ProductBean>getProductRecord() {
        List<ProductBean> products = new ArrayList<>();
        
        String query = "select * from products";
        Statement statement = null;
        ResultSet result = null;
        
        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                ProductBean pb = new ProductBean();
                
                pb.setProductId(result.getString("product_id"));
                pb.setProductTypeId(result.getString("product_type_Id"));
                pb.setProduct(result.getString("Product"));
                pb.setProductDescription(result.getString("product_description"));
                pb.setEntryDate(result.getString("entry_date"));
                
                products.add(pb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }
    
    public static void main(String[] args) {
        //   To add record
        ProductDAO DAO = new ProductDAO();
        ProductBean pb = new ProductBean();
        
        pb.setProductId("p001");
        pb.setProductTypeId("pt01");
        pb.setProduct("tfgyuh");
        pb.setProductDescription("dftggj");
        pb.setEntryDate("2016/09/11");
        int status = DAO.addProductRecord(pb);
        System.out.println("Status: " +status);
//    }
    
    
//                  To update record
//        ProductDAO DAO = new ProductDAO();
//        ProductBean pb = new ProductBean();
//        pb.setProductId("pt02");
//        pb.setProduct("rtghjnm");
//        pb.setProductDescription("cvbnm");
//        
//        int status = DAO.updateProductRecord(pb);
//       System.out.println("Status: "+ status);
//    
//    }
    
    //      To delete record
//       ProductDAO DAO = new ProductDAO();
//       
//        int status = DAO.deleteProductRecord("p001");
//        System.out.println("Status: "+ status);
    
    //      To get record
//        ProductDAO DAO = new ProductDAO();
//        ProductBean pb = DAO.getProductRecord("p001");
//        
//        System.out.println("\tProduct ID: "+ pb.getProductId());
//        System.out.println("\tProduct Type ID: "+ pb.getProductTypeId());
//        System.out.println("\tProduct: "+ pb.getProduct());
//        System.out.println("\tProduct Description: "+ pb.getProductDescription());
//        System.out.println("\tEntry Date: "+ pb.getEntryDate());
        
        
//                ProductDAO DAO = new ProductDAO();
//        List<ProductBean> products = DAO.getProductRecord();
//        
//        for (ProductBean product : products) {
//            System.out.println("\tPoduct ID: "+ product.getProductId());
//            System.out.println("\tPoduct Type ID: "+ product.getProductTypeId());
//            System.out.println("\tPoduct: "+ product.getProductId());
//            System.out.println("\tPoduct Description: "+ product.getProductDescription());
//            System.out.println("\tEntry Date: "+ product.getEntryDate());
//            
//            System.out.println("******************************************");
//            System.out.println("**********************");
//
//   
//    }
    }
}


