/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.MerchantClassDAO;
import com.javaplus.billpayment.beans.MerchantClassBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class MerchantClassTester {

    MerchantClassDAO mcdao = new MerchantClassDAO();

    public void testAddMerchantClassMethod(String merchantClassId, String merchantClass, String merchantDesc, String entryDate) {

        MerchantClassBean mcb = new MerchantClassBean();
        
        mcb.setMerchantClassId(merchantClassId);
        mcb.setMerchantClass(merchantClass);
        mcb.setMerchantClassDescription(merchantDesc);
        mcb.setEntryDate(entryDate);
        
        int status = mcdao.addMerchantClassRecord(mcb);
        System.out.println("Status: " + status);
    }

    public void testUpdateMerchantClassMethod(String merchantClassId, String merchantClass, String merchantDesc) {

        MerchantClassBean mcb = new MerchantClassBean();
        
        mcb.setMerchantClass(merchantClass);
        mcb.setMerchantClassDescription(merchantDesc);
        mcb.setMerchantClassId(merchantClassId);

        int status = mcdao.updateMerchantClassRecord(mcb);
        System.out.println("Status: " + status);
    }

    public void testDeleteMerchantClassMethod(String id) {

        int status = mcdao.deleteMerchantClassRecord(id);
        System.out.println("Status: " + status);
    }

    public void testGetMerchantClassMethod(String id) {
        MerchantClassBean mcb = mcdao.getMerchantClassRecord(id);

        if (mcb != null) {
            
            System.out.println("\tMerchant Class ID: " + mcb.getMerchantClassId());
            System.out.println("\tMerchant Class: " + mcb.getMerchantClass());
            System.out.println("\tMerchant Description: " + mcb.getMerchantClassDescription());
            System.out.println("\tEntry Date: " + mcb.getEntryDate());
        }
    }

    public void testGetMerchantClassListMethod() {

        List<MerchantClassBean> merchantClasses = mcdao.getMerchantClassRecord();

        for (MerchantClassBean merchantClass : merchantClasses) {
            System.out.println("\tMerchant Class ID: " + merchantClass.getMerchantClassId());
            System.out.println("\tMerchant Class: " + merchantClass.getMerchantClass());
            System.out.println("\tMerchant Description: " + merchantClass.getMerchantClassDescription());
            System.out.println("\tEntry Date: " + merchantClass.getEntryDate());

            System.out.println("******************************************");

        }

    }

    public static void main(String[] args) {

        MerchantClassTester mct = new MerchantClassTester();

        //mct.testAddMerchantClassMethod("mc02");
        //mct.testUpdateMerchantClassMethod("mc02");
        //mct.testDeleteMerchantClassMethod("mc02");
//        mct.testGetMerchantClassMethod("mc02");
//        mct.testGetMerchantClassListMethod();
    }

}
