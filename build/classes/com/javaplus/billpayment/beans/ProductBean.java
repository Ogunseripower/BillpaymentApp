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
public class ProductBean {
    private String ProductId;
    private String ProductTypeId;
    private String Product;
    private String ProductDescription;
    private String EntryDate;

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(String ProductTypeId) {
        this.ProductTypeId = ProductTypeId;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String ProductDescription) {
        this.ProductDescription = ProductDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }
    
    
    
    
}
