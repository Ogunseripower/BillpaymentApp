/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.ProductDetailBean;
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
public class ProductDetailDAO {

    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;

    public int addProductDetailRecord(ProductDetailBean bean) {
        int status = -1;
        String query = "insert into product_details values(?,?,?,?,?,?)";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProductDetailId());
            ps.setString(2, bean.getProductId());
            ps.setString(3, bean.getMerchantId());
            ps.setString(4, bean.getProductDetail());
            ps.setString(5, bean.getProductDetailDescription());
            ps.setString(6, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int updateProductDetailRecord(ProductDetailBean bean) {
        int status = -1;
        String query = "update product_details set product_detail = ?, product_detail_description = ? where product_detail_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getProductDetail());
            ps.setString(2, bean.getProductDetailDescription());
            ps.setString(3, bean.getProductDetailId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int deleteProductDetailRecord(String productdetailId) {
        int status = -1;
        String querry = "delete from product_details where product_detail_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, productdetailId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public ProductDetailBean getProductDetailRecord(String productdetailId) {
        ProductDetailBean pdb = new ProductDetailBean();

        String query = "select * from product_details where product_detail_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, productdetailId);
            result = ps.executeQuery();
            if (result.next()) {
                pdb.setProductDetailId(result.getString("product_detail_id"));
                pdb.setProductId(result.getString("product_id"));
                pdb.setMerchantId(result.getString("merchant_id"));
                pdb.setProductDetail(result.getString("product_detail"));
                pdb.setProductDetailDescription(result.getString("product_detail_description"));
                pdb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pdb;
    }

    public List<ProductDetailBean> getProductDetailRecord() {
        List<ProductDetailBean> productDetails = new ArrayList<>();

        String query = "select * from product_details";
        Statement statement = null;
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                ProductDetailBean pdb = new ProductDetailBean();

                pdb.setProductDetailId(result.getString("product_detail_id"));
                pdb.setProductId(result.getString("product_id"));
                pdb.setMerchantId(result.getString("merchant_id"));
                pdb.setProductDetail(result.getString("product_detail"));
                pdb.setProductDetailDescription(result.getString("product_detail_description"));
                pdb.setEntryDate(result.getString("entry_date"));

                productDetails.add(pdb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productDetails;
    }

    public static void main(String[] args) {
        //   To add record
//        ProductDetailDAO DAO = new ProductDetailDAO();
//        ProductDetailBean pdb = new ProductDetailBean();
//        pdb.setProductDetailId("pd01");
//        pdb.setProductId("p001");
//        pdb.setMerchantId("m001");
//        pdb.setProductDetail("pt01");
//        pdb.setProductDetailDescription("tfgyuh");
//        pdb.setEntryDate("2016/9/11");
//        int status = DAO.addProductDetailRecord(pdb);
//        System.out.println("Status: " +status);

        // To update record
//        ProductDetailDAO DAO = new ProductDetailDAO();
//        ProductDetailBean pdb = new ProductDetailBean();
//        pdb.setProductDetailId("pd01");
//        pdb.setProductDetail("rtghjnm");
//        pdb.setProductDetailDescription("cvbnm");
//        
//        int status = DAO.updateProductDetailRecord(pdb);
//       System.out.println("Status: "+ status);
        //      To delete record
//       ProductDetailDAO DAO = new ProductDetailDAO();
//       
//        int status = DAO.deleteProductDetailRecord("pd01");
//        System.out.println("Status: "+ status);
//        
//      To get record
//        ProductDetailDAO DAO = new ProductDetailDAO();
//        ProductDetailBean pdb = DAO.getProductDetailRecord("pd01");
//        
//        System.out.println("\tProduct ID: "+ pdb.getProductDetailId());
//        System.out.println("\tProduct ID: "+ pdb.getProductId());
//        System.out.println("\tMerchant ID: "+ pdb.getMerchantId());
//        System.out.println("\tproduct Detail: "+ pdb.getProductDetail());
//        System.out.println("\tProduct Detail Description: "+ pdb.getProductDetailDescription());
//        System.out.println("\tEntry Date: "+ pdb.getEntryDate());
//       
            
        ProductDetailDAO DAO = new ProductDetailDAO();
        List<ProductDetailBean> productDetails = DAO.getProductDetailRecord();
        for (ProductDetailBean productdetail : productDetails) {
            System.out.println("\tProduct Detail ID: " + productdetail.getProductId());
            System.out.println("\tProduct ID: " + productdetail.getProductId());
            System.out.println("\tMerchant ID: " + productdetail.getMerchantId());
            System.out.println("\tProduct Detail: " + productdetail.getProductDetail());
            System.out.println("\tPoduct Detail Description: " + productdetail.getProductDetailDescription());
            System.out.println("\tEntry Date: " + productdetail.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");

        }

    }
}
