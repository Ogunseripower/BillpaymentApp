/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.ProductTypeBean;
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
public class ProductTypeDAO {
    
    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;
    
    public int addProductTypeRecord(ProductTypeBean bean) {
        int status = -1;
        String query = "insert into product_types values(?,?,?,?)";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProductTypeId());
            ps.setString(2, bean.getProductType());
            ps.setString(3, bean.getProductTypeDescription());
            ps.setString(4, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int updateProductTypeRecord(ProductTypeBean bean) {
        int status = -1;
        String query = "update product_types set product_type = ?, product_type_description = ? where product_type_id = ?";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProductType());
            ps.setString(2, bean.getProductTypeDescription());
            ps.setString(3, bean.getProductTypeId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int deleteProductTypeRecord(String productTypeId) {
        int status = -1;
        String querry = "delete from product_types where product_type_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, productTypeId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            }
            else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public ProductTypeBean getProductTypeRecord(String productTypeId) {
        ProductTypeBean ptb = new ProductTypeBean();

        String query = "select * from product_types where product_type_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, productTypeId);
            result = ps.executeQuery();
            if (result.next()) {
                ptb.setProductTypeId(result.getString("product_type_id"));
                ptb.setProductType(result.getString("product_type"));
                ptb.setProductTypeDescription(result.getString("product_type_description"));
                ptb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ptb;
    }
    
    public List<ProductTypeBean>getProductTypeRecord() {
        List<ProductTypeBean> productTypes = new ArrayList<>();
        
        String query = "select * from product_types";
        Statement statement = null;
        ResultSet result = null;
        
        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                ProductTypeBean ptb = new ProductTypeBean();
                
                ptb.setProductTypeId(result.getString("product_type_id"));
                ptb.setProductType(result.getString("Product_type"));
                ptb.setProductTypeDescription(result.getString("product_type_description"));
                ptb.setEntryDate(result.getString("entry_date"));
                
                productTypes.add(ptb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return productTypes;
    }
    
    public static void main(String[] args) {
        //   To add record
        ProductTypeDAO DAO = new ProductTypeDAO();
        ProductTypeBean ptb = new ProductTypeBean();
        ptb.setProductTypeId("pt01");
        ptb.setProductType("tfgyuh");
        ptb.setProductTypeDescription("dftvgj");
        ptb.setEntryDate("2016/09/11");
        int status = DAO.addProductTypeRecord(ptb);
        System.out.println("Status: " +status);
       
        //      To update record
//        ProductTypeDAO DAO = new ProductTypeDAO();
//        ProductTypeBean ptb = new ProductTypeBean();
//        ptb.setProductTypeId("pt01");
//        ptb.setProductType("tdrfgh");
//        ptb.setProductTypeDescription("wertyu");
//        
//        int status = DAO.updateProductTypeRecord(ptb);
//       System.out.println("Status: "+ status);
//       
       //      To delete record
//       ProductTypeDAO DAO = new ProductTypeDAO();
//       
//        int status = DAO.deleteProductTypeRecord("pt01");
//        System.out.println("Status: "+ status);
        
        //      To get record
//        ProductTypeDAO DAO = new ProductTypeDAO();
//        ProductTypeBean ptb = DAO.getProductTypeRecord("pt01");
//        
//        System.out.println("\tProduc Type ID: "+ ptb.getProductTypeId());
//        System.out.println("\tProduct Type: "+ ptb.getProductType());
//        System.out.println("\tProduct Type Description: "+ ptb.getProductTypeDescription());
//        System.out.println("\tEntry Date: "+ ptb.getEntryDate());


//        ProductTypeDAO DAO = new ProductTypeDAO();
//        List<ProductTypeBean> productTypes = DAO.getProductTypeRecord();
//        
//        for (ProductTypeBean productType : productTypes) {
//            System.out.println("\tPoduct Type ID: "+ productType.getProductTypeId());
//            System.out.println("\tPoduct Type: "+ productType.getProductType());
//            System.out.println("\tPoduct Type Description: "+ productType.getProductTypeDescription());
//            System.out.println("\tEntry Date: "+ productType.getEntryDate());
//            
//            System.out.println("******************************************");
//            System.out.println("**********************");
 
   
    }
}


