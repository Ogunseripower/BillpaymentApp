/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.ProductDetailDAO;
import com.javaplus.billpayment.beans.ProductDetailBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class ProductDetailTester {

    ProductDetailDAO pddao = new ProductDetailDAO();

    public void testAddProductDetailMethod(String productDetailId, String productId, String merchantId, String productDetail, String productDetailDesc, String entryDate) {

        ProductDetailBean pdb = new ProductDetailBean();
        
        pdb.setProductDetailId(productDetailId);
        pdb.setProductId(productId);
        pdb.setMerchantId(merchantId);
        pdb.setProductDetail(productDetail);
        pdb.setProductDetailDescription(productDetailDesc);
        pdb.setEntryDate(entryDate);
        
        int status = pddao.addProductDetailRecord(pdb);
        System.out.println("Status: " + status);
    }

    public void testUpdateProductDetailMethod(String productDetailId, String productId, String merchantId, String productDetail, String productDetailDesc) {

        ProductDetailBean pdb = new ProductDetailBean();
        
        pdb.setProductId(productId);
        pdb.setMerchantId(merchantId);
        pdb.setProductDetail(productDetail);
        pdb.setProductDetailDescription(productDetailDesc);
        pdb.setProductDetailId(productDetailId);
       

        int status = pddao.updateProductDetailRecord(pdb);
        System.out.println("Status: " + status);
    }

    public void testDeleteProductDetailMethod(String id) {

        int status = pddao.deleteProductDetailRecord(id);
        System.out.println("Status: " + status);
    }

    public void testGetProductDetailMethod(String id) {
        ProductDetailBean pdb = pddao.getProductDetailRecord(id);
        if (pdb != null) {

            System.out.println("\tProduct ID: " + pdb.getProductDetailId());
            System.out.println("\tProduct ID: " + pdb.getProductId());
            System.out.println("\tMerchant ID: " + pdb.getMerchantId());
            System.out.println("\tproduct Detail: " + pdb.getProductDetail());
            System.out.println("\tProduct Detail Description: " + pdb.getProductDetailDescription());
            System.out.println("\tEntry Date: " + pdb.getEntryDate());
        }
    }

    public void testGetProductDetailListMethod() {

        List<ProductDetailBean> productDetails = pddao.getProductDetailRecord();
        for (ProductDetailBean productdetail : productDetails) {
            System.out.println("\tProduct Detail ID: " + productdetail.getProductId());
            System.out.println("\tProduct ID: " + productdetail.getProductId());
            System.out.println("\tMerchant ID: " + productdetail.getMerchantId());
            System.out.println("\tProduct Detail: " + productdetail.getProductDetail());
            System.out.println("\tPoduct Detail Description: " + productdetail.getProductDetailDescription());
            System.out.println("\tEntry Date: " + productdetail.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");

        }

    }

    public static void main(String[] args) {

        ProductDetailTester pdt = new ProductDetailTester();

        //pdt.testAddProductDetailMethod("pd02");
//        pdt.testUpdateProductDetailMethod("pd02");
//        pdt.testDeleteProductDetailMethod("p001");
        //pdt.testGetProductDetailMethod("pd02");
//         pdt.testGetProductDetailListMethod();
    }

}
