/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.billpayment.beans;

/**
 *
 * @author VSTECH
 */
public class TransactionBean {
    private String TransactionId;
    private String ProductDetailId;
    private String Transaction;
    private String TransactionDescription;
    private String EntryDate;

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String TransactionId) {
        this.TransactionId = TransactionId;
    }

    public String getProductDetailId() {
        return ProductDetailId;
    }

    public void setProductDetailId(String ProductDetailId) {
        this.ProductDetailId = ProductDetailId;
    }

    public String getTransaction() {
        return Transaction;
    }

    public void setTransaction(String Transaction) {
        this.Transaction = Transaction;
    }

    public String getTransactionDescription() {
        return TransactionDescription;
    }

    public void setTransactionDescription(String TransactionDescription) {
        this.TransactionDescription = TransactionDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }
    
    
    
}
