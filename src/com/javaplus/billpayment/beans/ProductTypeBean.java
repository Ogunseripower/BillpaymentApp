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
public class ProductTypeBean {
    private String ProductTypeId;
    private String ProductType;
    private String ProductTypeDescription;
    private String EntryDate;

    public String getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(String ProductTypeId) {
        this.ProductTypeId = ProductTypeId;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    public String getProductTypeDescription() {
        return ProductTypeDescription;
    }

    public void setProductTypeDescription(String ProductTypeDescription) {
        this.ProductTypeDescription = ProductTypeDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }
    
    
    
}
