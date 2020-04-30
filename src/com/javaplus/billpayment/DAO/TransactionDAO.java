/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.DAO;

import CONN.JConnect;
import com.javaplus.billpayment.beans.TransactionBean;
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
public class TransactionDAO {

    JConnect jc = new JConnect();
    Connection connect = null;
    PreparedStatement ps = null;

    public int addTransactionRecord(TransactionBean bean) {
        int status = -1;
        String query = "insert into transactions values(?,?,?,?,?)";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getTransactionId());
            ps.setString(2, bean.getProductDetailId());
            ps.setString(3, bean.getTransaction());
            ps.setString(4, bean.getTransactionDescription());
            ps.setString(5, bean.getEntryDate());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int updateTransactionRecord(TransactionBean bean) {
        int status = -1;
        String query = "update transactions set product_detail_id = ?, transaction = ?, transaction_description = ? where transaction_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            
            ps.setString(1, bean.getProductDetailId());
            ps.setString(2, bean.getTransaction());
            ps.setString(3, bean.getTransactionDescription());
            ps.setString(4, bean.getTransactionId());

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int deleteTransactionRecord(String TransactionId) {
        int status = -1;
        String querry = "delete from transactions where transaction_id = ?";

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(querry);
            ps.setString(1, TransactionId);

            int count = ps.executeUpdate();
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public TransactionBean getTransactionRecord(String TransactionId) {
        TransactionBean tb = new TransactionBean();

        String query = "select * from transactions where transaction_id = ?";
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, TransactionId);
            result = ps.executeQuery();
            if (result.next()) {
                tb.setTransactionId(result.getString("transaction_id"));
                tb.setProductDetailId(result.getString("product_detail_id"));
                tb.setTransaction(result.getString("transaction"));
                tb.setTransactionDescription(result.getString("transaction_description"));
                tb.setEntryDate(result.getString("entry_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<TransactionBean> getTransactionRecord() {
        List<TransactionBean> transactons = new ArrayList<>();

        String query = "select * from transactions";
        Statement statement = null;
        ResultSet result = null;

        connect = jc.getNewConnection();
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                TransactionBean tb = new TransactionBean();

                tb.setTransactionId(result.getString("transaction_id"));
                tb.setProductDetailId(result.getString("product_detail_id"));
                tb.setTransaction(result.getString("transaction"));
                tb.setTransactionDescription(result.getString("transaction_description"));
                tb.setEntryDate(result.getString("entry_date"));

                transactons.add(tb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return transactons;
    }

    public static void main(String[] args) {
        //   To add record
//        TransactionDAO DAO = new TransactionDAO();
//        TransactionBean tb = new TransactionBean();
//        tb.setTransactionId("t001");
//        tb.setProductDetailId("pd01");
//        tb.setTransaction("bags");
//        tb.setTransactionDescription(" Very good");
//        tb.setEntryDate("2016/09/11");
//        int status = DAO.addTransactionRecord(tb);
//        System.out.println("Status: "+ status);

        //      To update record
//        TransactionDAO DAO = new TransactionDAO();
//       TransactionBean tb = new TransactionBean();
//        
//        tb.setTransaction("rytguh");
//        tb.setTransactionDescription("wsxecdrftvg");
//        tb.setTransactionId("t001");
//        
//        int status = DAO.updateTransactionRecord(tb);
//       System.out.println("Status: "+ status);
        //      To delete record
//        TransactionDAO DAO = new TransactionDAO();
//        
//        int status = DAO.deleteTransactionRecord("t001");
//        System.out.println("Status: "+ status);
        //      To get record
//        TransactionDAO DAO = new TransactionDAO();
//       TransactionBean tb = new TransactionBean();
//        
//        System.out.println("\tTransaction ID: "+ tb.getTransactionId());
//        System.out.println("\tProduct Detail ID: "+ tb.getProductDetailId());
//        System.out.println("\tTransaction: "+ tb.getTransaction());
//        System.out.println("\tTransaction Description: "+ tb.getTransactionDescription());
//        System.out.println("\tEntry Date: "+ tb.getEntryDate());
        TransactionDAO DAO = new TransactionDAO();
        List<TransactionBean> transcations = DAO.getTransactionRecord();

        for (TransactionBean transaction : transcations) {
            System.out.println("\tTransaction ID: " + transaction.getTransactionId());
            System.out.println("\tProduct Detail ID: " + transaction.getProductDetailId());
            System.out.println("\tTransaction: " + transaction.getTransaction());
            System.out.println("\tTransaction Description: " + transaction.getTransactionDescription());
            System.out.println("\tEntry Date: " + transaction.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");
        }
    }

}
