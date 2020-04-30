/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.MerchantDAO;
import com.javaplus.billpayment.beans.MerchantBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class MerchantTester {

    MerchantDAO mdao = new MerchantDAO();

    public void testAddMerchantMethod(String merchantid, String merchantClassId, String merchant, String merchantDesc, String entryDate) {

        MerchantBean mb = new MerchantBean();
        
        mb.setMerchantId(merchantid);
        mb.setMerchantClassId(merchantClassId);
        mb.setMerchant(merchant);
        mb.setMerchantDescription(merchantDesc);
        mb.setEntryDate(entryDate);
        
        int status = mdao.addMerchantRecord(mb);
        System.out.println("Status: " + status);
    }

    public void testUpdateMerchantMethod(String merchantid, String merchantClassId, String merchant, String merchantDesc) {

        MerchantBean mb = new MerchantBean();

        mb.setMerchantClassId(merchantClassId);
        mb.setMerchant(merchant);
        mb.setMerchantDescription(merchantDesc);
        mb.setMerchantId(merchantid);

        int status = mdao.updateMerchantRecord(mb);
        System.out.println("Status: " + status);
    }

    public void testDeleteMerchantMethod(String id) {

        int status = mdao.deleteMerchantRecord(id);
        System.out.println("Status: " + status);
    }

    public void testGetMerchantMethod(String id) {
        MerchantBean mb = mdao.getMerchantRecord(id);
        if (mb != null) {

            System.out.println("\tMerchant ID: " + mb.getMerchantClassId());
            System.out.println("\tMerchant Class ID: " + mb.getMerchantClassId());
            System.out.println("\tMerchant: " + mb.getMerchant());
            System.out.println("\tMerchant Description: " + mb.getMerchantDescription());
            System.out.println("\tEntry Date: " + mb.getEntryDate());
        }
    }

    public void testGetMerchantClassListMethod() {

        List<MerchantBean> merchants = mdao.getMerchantRecordList();

        for (MerchantBean merchant : merchants) {
            System.out.println("\tMerchant Class ID: " + merchant.getMerchantId());
            System.out.println("\tMerchant Class ID: " + merchant.getMerchantClassId());
            System.out.println("\tMerchant Class: " + merchant.getMerchant());
            System.out.println("\tMerchant ClassDescription: " + merchant.getMerchantDescription());
            System.out.println("\tEntry Date: " + merchant.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");

        }

    }

    public static void main(String[] args) {

        MerchantTester mt = new MerchantTester();

        //mt.testAddMerchantMethod("m002");
        //mt.testUpdateMerchantMethod("m002");
        //mt.testDeleteMerchantMethod("m002");
        //mt.testGetMerchantMethod("m002");
//        mt.testGetMerchantClassListMethod();
    }
}
