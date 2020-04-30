/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.MerchantClassBean;
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
public class MerchantClassDAO {
    
    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;
    
    public int addMerchantClassRecord(MerchantClassBean bean) {
        
        int status = -1;
        String query = "insert into merchant_classes values(?,?,?,?)";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getMerchantClassId());
            ps.setString(2, bean.getMerchantClass());
            ps.setString(3, bean.getMerchantClassDescription());
            ps.setString(4, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int updateMerchantClassRecord(MerchantClassBean bean) {
        int status = -1;
        String query = "update merchant_classes set merchant_class = ?, merchant_class_description = ? where merchant_class_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getMerchantClass());
            ps.setString(2, bean.getMerchantClassDescription());
            ps.setString(3, bean.getMerchantClassId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int deleteMerchantClassRecord(String merchantClassId ) {
        int status = -1;
        String querry = "delete from merchant_classes where merchant_class_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, merchantClassId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            }
            else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public MerchantClassBean getMerchantClassRecord(String merchantclassId) {
        MerchantClassBean mcb = new MerchantClassBean();

        String query = "select * from merchant_classes where merchant_class_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, merchantclassId);
            result = ps.executeQuery();
            if (result.next()) {
                mcb.setMerchantClassId(result.getString("merchant_class_id"));
                mcb.setMerchantClass(result.getString("merchant_class"));
                mcb.setMerchantClassDescription(result.getString("merchant_class_description"));
                mcb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mcb;
    }
    
    public List<MerchantClassBean>getMerchantClassRecord() {
        List<MerchantClassBean> merchantClasses = new ArrayList<>();
        
        String query = "select * from merchant_classes";
        Statement statement = null;
        ResultSet result = null;
        
        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                MerchantClassBean mcb = new MerchantClassBean();
                
                mcb.setMerchantClassId(result.getString("merchant_class_id"));
                mcb.setMerchantClass(result.getString("merchant_class"));
                mcb.setMerchantClassDescription(result.getString("merchant_class_description"));
                mcb.setEntryDate(result.getString("entry_date"));
                
                merchantClasses.add(mcb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MerchantClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return merchantClasses;
    }
    
    public static void main(String[] args) {
           //   To add record
//        MerchantClassDAO DAO = new MerchantClassDAO();
//        MerchantClassBean mcb = new MerchantClassBean();
//        mcb.setMerchantClassId("mc001");
//        mcb.setMerchantClass("mc001");
//        mcb.setMerchantClassDescription("good");
//        mcb.setEntryDate("2016/09/11");
//        int status = DAO.addMerchantClassRecord(mcb);
//        System.out.println("Status: "+ status);
        
        
//      To update record
//        MerchantClassDAO DAO = new MerchantClassDAO();
//        MerchantClassBean mcb = new MerchantClassBean();
//        
//        mcb.setMerchantClass("rytguh");
//        mcb.setMerchantClassDescription("wsxecdrftvg");
//        mcb.setMerchantClassId("mc001");
//        
//        int status = DAO.updateMerchantClassRecord(mcb);
//        System.out.println("Status: "+ status);

//      To delete record
//        MerchantClassDAO DAO = new MerchantClassDAO();
//        
//        int status = DAO.deleteMerchantClassRecord("mc001");
//        System.out.println("Status: "+ status);
        
        //      To get record
//        MerchantClassDAO DAO = new MerchantClassDAO();
//        MerchantClassBean mcb = DAO.getMerchantClassRecord("MC001");
//        
//        System.out.println("\tMerchant Class ID: "+ mcb.getMerchantClassId());
//        System.out.println("\tMerchant Class: "+ mcb.getMerchantClass());
//        System.out.println("\tMerchant Description: "+ mcb.getMerchantClassDescription());
//        System.out.println("\tEntry Date: "+ mcb.getEntryDate());

//        MerchantClassDAO DAO = new MerchantClassDAO();
//        List<MerchantClassBean> merchantClasses = DAO.getMerchantClassRecord();
//        
//        for (MerchantClassBean merchantClass : merchantClasses) {
//            System.out.println("\tMerchant Class ID: "+ merchantClass.getMerchantClassId());
//            System.out.println("\tMerchant Class: "+ merchantClass.getMerchantClass());
//            System.out.println("\tMerchant ClassDescription: "+ merchantClass.getMerchantClassDescription());
//            System.out.println("\tEntry Date: "+ merchantClass.getEntryDate());
//            
//            System.out.println("******************************************");
//            System.out.println("**********************");

   }
    
 }

