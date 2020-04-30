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
public class MerchantClassBean {
    private String MerchantClassId;
    private String MerchantClass;
    private String MerchantClassDescription;
    private String EntryDate;

    public String getMerchantClassId() {
        return MerchantClassId;
    }

    public void setMerchantClassId(String MerchantClassId) {
        this.MerchantClassId = MerchantClassId;
    }

    public String getMerchantClass() {
        return MerchantClass;
    }

    public void setMerchantClass(String MerchantClass) {
        this.MerchantClass = MerchantClass;
    }

    public String getMerchantClassDescription() {
        return MerchantClassDescription;
    }

    public void setMerchantClassDescription(String MerchantDescription) {
        this.MerchantClassDescription = MerchantDescription;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    } 
    
}
