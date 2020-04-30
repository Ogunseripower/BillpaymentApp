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
public class ProductDetailBean {
    private String ProductDetailId;
    private String ProductId;
    private String MerchantId;
    private String ProductDetail;
    private String ProductDetailDescription;
    private String EntryDate;

    public String getProductDetailId() {
        return ProductDetailId;
    }

    public void setProductDetailId(String ProductDetailId) {
        this.ProductDetailId = ProductDetailId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String MerchantId) {
        this.MerchantId = MerchantId;
    }

    public String getProductDetail() {
        return ProductDetail;
    }

    public void setProductDetail(String ProductDetail) {
        this.ProductDetail = ProductDetail;
    }

    public String getProductDetailDescription() {
        return ProductDetailDescription;
    }

    public void setProductDetailDescription(String ProductDetailDescription) {
        this.ProductDetailDescription = ProductDetailDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }
    
    
    
}
