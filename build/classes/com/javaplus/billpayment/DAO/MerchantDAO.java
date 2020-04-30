/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.MerchantBean;
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
public class MerchantDAO {
    
    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;
    
    public int addMerchantRecord(MerchantBean bean) {
        int status = -1;
        String query = "insert into merchants values(?,?,?,?,?)";
        
        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getMerchantId());
            ps.setString(2, bean.getMerchantClassId());
            ps.setString(3, bean.getMerchant());
            ps.setString(4, bean.getMerchantDescription());
            ps.setString(5, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int updateMerchantRecord(MerchantBean bean) {
        int status = -1;
        String query = "update merchants set merchant = ?, merchant_description = ? where merchant_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getMerchant());
            ps.setString(2, bean.getMerchantDescription());
            ps.setString(3, bean.getMerchantClassId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public int deleteMerchantRecord(String merchantId) {
        int status = -1;
        String querry = "delete from merchants where merchant_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, merchantId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            }
            else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public MerchantBean getMerchantRecord(String merchantId) {
        MerchantBean mb = new MerchantBean();

        String query = "select * from merchants where merchant_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, merchantId);
            result = ps.executeQuery();
            if (result.next()) {
                mb.setMerchantId(result.getString("merchant_id"));
                mb.setMerchantClassId(result.getString("merchant_class_id"));
                mb.setMerchant(result.getString("merchant"));
                mb.setMerchantDescription(result.getString("merchant_description"));
                mb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MerchantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mb;
    }
    
    public List<MerchantBean>getMerchantRecordList() {
        List<MerchantBean> merchants = new ArrayList<>();
        
        String query = "select * from merchants";
        Statement statement = null;
        ResultSet result = null;
        
        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                MerchantBean mb = new MerchantBean();
                
                mb.setMerchantId(result.getString("merchant_id"));
                mb.setMerchantClassId(result.getString("merchant_class_id"));
                mb.setMerchant(result.getString("merchant"));
                mb.setMerchantDescription(result.getString("merchant_description"));
                mb.setEntryDate(result.getString("entry_date"));
                
                merchants.add(mb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MerchantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return merchants;
    }
    
    public static void main(String[] args) {
        //   To add record
        MerchantDAO DAO = new MerchantDAO();
        MerchantBean mb = new MerchantBean();
        mb.setMerchantId("m001");
        mb.setMerchantClassId("mc001");
        mb.setMerchant("bags");
        mb.setMerchantDescription(" Very good");
        mb.setEntryDate("2016/09/11");
        int status = DAO.addMerchantRecord(mb);
        System.out.println("Status: "+ status);

//      To update record
//        MerchantDAO DAO = new MerchantDAO();
//        MerchantBean mb = new MerchantBean();
//        
//        mb.setMerchant("rytguh");
//        mb.setMerchantDescription("wsxecdrftvg");
//        mb.setMerchantId("m001");
//        
//        int status = DAO.updateMerchantRecord(mb);
//       System.out.println("Status: "+ status);

//      To delete record
//        MerchantDAO DAO = new MerchantDAO();
//        
//        int status = DAO.deleteMerchantRecord("m001");
//        System.out.println("Status: "+ status);

//      To get record
//        MerchantDAO DAO = new MerchantDAO();
//        MerchantBean mb = DAO.getMerchantRecord("m001");
//        
//        System.out.println("\tMerchant ID: "+ mb.getMerchantClassId());
//        System.out.println("\tMerchant Class ID: "+ mb.getMerchantClassId());
//        System.out.println("\tMerchant: "+ mb.getMerchant());
//        System.out.println("\tMerchant Description: "+ mb.getMerchantDescription());
//        System.out.println("\tEntry Date: "+ mb.getEntryDate());

//        MerchantDAO DAO = new MerchantDAO();
//        List<MerchantBean> merchants = DAO.getMerchantRecord();
//        
//        for (MerchantBean merchant : merchants) {
//            System.out.println("\tMerchant Class ID: "+ merchant.getMerchantId());
//            System.out.println("\tMerchant Class ID: "+ merchant.getMerchantClassId());
//            System.out.println("\tMerchant Class: "+ merchant.getMerchant());
//            System.out.println("\tMerchant ClassDescription: "+ merchant.getMerchantDescription());
//            System.out.println("\tEntry Date: "+ merchant.getEntryDate());
//            
//            System.out.println("******************************************");
//            System.out.println("**********************");
//    }
    
    }
}



