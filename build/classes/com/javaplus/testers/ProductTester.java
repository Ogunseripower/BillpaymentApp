/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.testers;

import com.javaplus.billpayment.DAO.ProductDAO;
import com.javaplus.billpayment.beans.ProductBean;
import java.util.List;

/**
 *
 * @author VSTECH
 */
public class ProductTester {

    ProductDAO pdao = new ProductDAO();

    public void testAddProductMethod(String productId, String productTypeId, String product, String productDesc, String entryDate) {

        ProductBean pb = new ProductBean();

        pb.setProductId(productId);
        pb.setProductTypeId(productTypeId);
        pb.setProduct(product);
        pb.setProductDescription(productDesc);
        pb.setEntryDate(entryDate);
        
        int status = pdao.addProductRecord(pb);
        System.out.println("Status: " + status);
    }

    public void testUpdateProductMethod(String productId, String productTypeId, String product, String productDesc) {

        ProductBean pb = new ProductBean();
        
        pb.setProductTypeId(productTypeId);
        pb.setProduct(product);
        pb.setProductDescription(productDesc);
        pb.setProductId(productId);

        int status = pdao.updateProductRecord(pb);
        System.out.println("Status: " + status);
    }

    public void testDeleteProductMethod(String id) {

        int status = pdao.deleteProductRecord(id);
        System.out.println("Status: " + status);
    }

    public void testGetProductMethod(String id) {
        ProductBean pb = pdao.getProductRecord(id);
        if (pb != null) {
            System.out.println("\tProduct ID: " + pb.getProductId());
            System.out.println("\tProduct Type ID: " + pb.getProductTypeId());
            System.out.println("\tProduct: " + pb.getProduct());
            System.out.println("\tProduct Description: " + pb.getProductDescription());
            System.out.println("\tEntry Date: " + pb.getEntryDate());
        }
    }

    public void testGetProductListMethod() {

        List<ProductBean> products = pdao.getProductRecord();

        for (ProductBean product : products) {
            System.out.println("\tPoduct ID: " + product.getProductId());
            System.out.println("\tPoduct Type ID: " + product.getProductTypeId());
            System.out.println("\tPoduct: " + product.getProduct());
            System.out.println("\tPoduct Description: " + product.getProductDescription());
            System.out.println("\tEntry Date: " + product.getEntryDate());

            System.out.println("******************************************");
            System.out.println("**********************");

        }

    }

    public static void main(String[] args) {

        ProductTester pt = new ProductTester();

        //pt.testAddProductMethod("p002");
//        pt.testUpdateProductMethod("p002");
        pt.testDeleteProductMethod("p001");
        //pt.testGetProductMethod("p002");
//         pt.testGetProductListMethod();
    }

}
