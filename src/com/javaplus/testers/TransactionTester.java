/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.TransactionDAO;
import com.javaplus.billpayment.beans.TransactionBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class TransactionTester {
    
    TransactionDAO tdao = new TransactionDAO();

    public void testAddtransactionMethod(String id) {

        TransactionBean tb = new TransactionBean();
        tb.setTransactionId(id);
        tb.setProductDetailId("pd02");
        tb.setTransaction("bags");
        tb.setTransactionDescription(" Very good");
        tb.setEntryDate("2016/09/11");
        int status = tdao.addTransactionRecord(tb);
        System.out.println("Status: "+ status);
    }

    public void testUpdateTransactionMethod(String id) {

        TransactionBean tb = new TransactionBean();
        
        tb.setTransaction("rytguh");
        tb.setTransactionDescription("wsxecdrftvg");
        tb.setTransactionId(id);
        
        int status = tdao.updateTransactionRecord(tb);
       System.out.println("Status: "+ status);
    }

    public void testDeleteTransactionMethod(String id) {

      int status = tdao.deleteTransactionRecord(id);
        System.out.println("Status: "+ status);
    }

    public void testGetTransactionMethod(String id) {
        TransactionBean tb = tdao.getTransactionRecord(id);
        if (tb != null) {
        System.out.println("\tTransaction ID: "+ tb.getTransactionId());
        System.out.println("\tProduct Detail ID: "+ tb.getProductDetailId());
        System.out.println("\tTransaction: "+ tb.getTransaction());
        System.out.println("\tTransaction Description: "+ tb.getTransactionDescription());
        System.out.println("\tEntry Date: "+ tb.getEntryDate());
        }
    }

    public void testGetTransactionListMethod() {

        List<TransactionBean> transcations = tdao.getTransactionRecord();
 
        for (TransactionBean transaction : transcations) {
            System.out.println("\tTransaction ID: " + transaction.getTransactionId());
            System.out.println("\tProduct Detail ID: " + transaction.getProductDetailId());
            System.out.println("\tTransaction: " + transaction.getTransaction());
            System.out.println("\tTransaction Description: " + transaction.getTransactionDescription());
            System.out.println("\tEntry Date: " + transaction.getEntryDate());

            System.out.println("******************************************");
            System.out.println("******************************************");
        }

    }

    public static void main(String[] args) {

        TransactionTester tt = new TransactionTester();

       //tt.testAddtransactionMethod("419");
        //tt.testUpdateTransactionMethod("419");
        //tt.testDeleteTransactionMethod("419");
       tt.testGetTransactionMethod("419");
        //tt.testGetTransactionListMethod();
    }
    
}
