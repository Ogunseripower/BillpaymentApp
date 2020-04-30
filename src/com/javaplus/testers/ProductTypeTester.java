/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.ProductTypeDAO;
import com.javaplus.billpayment.beans.ProductBean;
import com.javaplus.billpayment.beans.ProductTypeBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class ProductTypeTester {

    ProductTypeDAO ptdao = new ProductTypeDAO();

    public void testAddProductTypeMethod(String productTypeId, String productType, String productTypeDesc, String entryDate) {

        ProductTypeBean ptb = new ProductTypeBean();
        
        ptb.setProductTypeId(productTypeId);
        ptb.setProductType(productType);
        ptb.setProductTypeDescription(productTypeDesc);
        ptb.setEntryDate(entryDate);
        
        int status = ptdao.addProductTypeRecord(ptb);
        System.out.println("Status: " + status);
    }

    public void testUpdateProductTypeMethod(String productTypeId, String productType, String productTypeDesc) {

        ProductTypeBean ptb = new ProductTypeBean();
        
        
        ptb.setProductType(productType);
        ptb.setProductTypeDescription(productTypeDesc);
       ptb.setProductTypeId(productTypeId);

        int status = ptdao.updateProductTypeRecord(ptb);
        System.out.println("Status: " + status);
    }

    public void testDeleteProductTypeMethod(String id) {

        int status = ptdao.deleteProductTypeRecord(id);
        System.out.println("Status: " + status);
    }

    public void testGetProductTypeMethod(String id) {
        ProductTypeBean ptb = ptdao.getProductTypeRecord(id);
        if (ptb != null) {
            
            System.out.println("\tProduct Type ID: " + ptb.getProductTypeId());
            System.out.println("\tProduct Type: " + ptb.getProductType());
            System.out.println("\tProduct Type Description: " + ptb.getProductTypeDescription());
            System.out.println("\tEntry Date: " + ptb.getEntryDate());
        }
    }

    public void testGetProductTypeListMethod() {

        List<ProductTypeBean> productTypes = ptdao.getProductTypeRecord();

        for (ProductTypeBean productType : productTypes) {
            System.out.println("\tPoduct Type ID: " + productType.getProductTypeId());
            System.out.println("\tPoduct Type: " + productType.getProductType());
            System.out.println("\tPoduct Type Description: " + productType.getProductTypeDescription());
            System.out.println("\tEntry Date: " + productType.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");

        }

    }

    public static void main(String[] args) {

        ProductTypeTester ptt = new ProductTypeTester();

        //ptt.testAddProductTypeMethod("p008");
//        ptt.testUpdateProductTypeMethod("p008");
//        ptt.testDeleteProductTypeMethod("pt01");
        //ptt.testGetProductTypeMethod("p002");
//        ptt.testGetProductTypeListMethod();
    }

}
