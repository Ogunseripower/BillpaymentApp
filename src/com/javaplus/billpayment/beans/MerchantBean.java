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
public class MerchantBean {
    private String MerchantId;
    private String MerchantClassId;
    private String Merchant;
    private String MerchantDescription;
    private String EntryDate;

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String MerchantId) {
        this.MerchantId = MerchantId;
    }

    public String getMerchantClassId() {
        return MerchantClassId;
    }

    public void setMerchantClassId(String MerchantClassId) {
        this.MerchantClassId = MerchantClassId;
    }

    public String getMerchant() {
        return Merchant;
    }

    public void setMerchant(String Merchant) {
        this.Merchant = Merchant;
    }

    public String getMerchantDescription() {
        return MerchantDescription;
    }

    public void setMerchantDescription(String MerchantDescription) {
        this.MerchantDescription = MerchantDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }

    

    
    
}
