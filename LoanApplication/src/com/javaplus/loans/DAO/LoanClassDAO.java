/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.loans.DAO;

import CONN.JConnect;
import com.javaplus.loans.beans.LoanBean;
import com.javaplus.loans.beans.LoanClassBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP1
 */
public class LoanClassDAO {
    
    Connection connect = null;
    JConnect jConnect = new JConnect();
    
    public int addLoanClassesRecord(LoanClassBean bean){
        
        String query = "insert into loan_classes values (?,?,?,?)";
        PreparedStatement ps = null;
        int status = -1;

        connect = jConnect.getNewConnection();

        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getLoanClassId());
            ps.setString(2, bean.getLoanClass());
            ps.setString(3, bean.getDescription());
            ps.setString(4, bean.getEntryDate());

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
               // Log.info("User Add Success");
            } else {
                status = 1;
                //Log.info("User Add Failed");
            }

        } catch (SQLException ex) {
           // Log.error("Exception Message: ", ex);
        } catch (Exception ex) {
           // Log.error("Exception Message: ", ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
        }

        return status;
    }
    
    public int updateLoanClassRecord(LoanClassBean bean){
        
       String query = "update loan_classes set loan_class=?, description=? where loan_class_id=?";
        PreparedStatement ps = null;
        int status = -1;

        connect = jConnect.getNewConnection();

        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getLoanClass());
            ps.setString(2, bean.getDescription());
            ps.setString(3, bean.getLoanClassId());

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
               // Log.info("User Add Success");
            } else {
                status = 1;
                //Log.info("User Add Failed");
            }

        } catch (SQLException ex) {
           // Log.error("Exception Message: ", ex);
        } catch (Exception ex) {
           // Log.error("Exception Message: ", ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
        }

        return status;
    
    }
    
    public int deleteLoanClassRecord(String loanClassId){
        
        String query = "delete from loan_classes where loan_class_id=?";
        PreparedStatement ps = null;
        int status = -1;

        connect = jConnect.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, loanClassId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
                //Log.info(userId + ":Deleted Successful");
            } else {
                status = 1;
               // Log.info(userId + ":Deleted Failed");
            }

        } catch (SQLException ex) {
           // Log.error("Exception Message: ", ex);
        } catch (Exception ex) {
           // Log.error("Exception Message: ", ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    //Log.error("Exception Message: ", ex);
                }
            }
        }

        return status;
    }
    
    public LoanClassBean getLoanClassRecord(String loanClassId){
        
       LoanClassBean bean = new LoanClassBean();

        ResultSet result = null;

        String query = "select * from loan_classes where loan_class_id=?";
        PreparedStatement ps = null;

        connect = jConnect.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, loanClassId);

            result = ps.executeQuery();
            if (result.next()) {
                bean.setLoanClassId(result.getString("loan_class_id"));
                bean.setLoanClass(result.getString("loan_class"));
                bean.setDescription(result.getString("description"));
                bean.setEntryDate(result.getString("entry_date"));
            }

        } catch (SQLException ex) {
           // Log.error("Exception Message: ", ex);
        } catch (Exception ex) {
           // Log.error("Exception Message: ", ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                   // Log.error("Exception Message: ", ex);
                }
            }
        }

        return bean;
    }
    
    public List<LoanClassBean> getLoanClassList(){
        
        List<LoanClassBean> loanClass = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from loan_classes";

        Statement statement = null;

        connect = jConnect.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                LoanClassBean bean = new LoanClassBean();

                bean.setLoanClassId(result.getString("loan_class_id"));
                bean.setLoanClass(result.getString("loan_class"));
                bean.setDescription(result.getString("description"));
                bean.setEntryDate(result.getString("entry_date"));

                loanClass.add(bean);
            }

        } catch (SQLException ex) {
            //    Log.error("Exception Message: ",ex);
        } catch (Exception ex) {
            //   Log.error("Exception Message: ",ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
//                    Log.error("Exception Message: ",ex);
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
//                    Log.error("Exception Message: ",ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
//                    Log.error("Exception Message: ",ex);
                }
            }
        }

        return loanClass;
    }
    
    public static void main(String[] args) {
        
        //Testing the methods
        LoanClassBean bean = new LoanClassBean();
        LoanClassDAO dao = new LoanClassDAO();
        
        //Adding Record to the database
        bean.setLoanClassId("LC01");
        bean.setLoanClass("Personal Loan");
        bean.setDescription("Personal Class of Loan");
        bean.setEntryDate("christalent@yahoo.com");

//        int status = dao.addLoanClassesRecord(bean);
//        System.out.println("Record Added Successfully: "+status);
        
        //Updating Record in the database
        bean.setLoanClassId("LC01");
        bean.setLoanClass("Personal Loan");
        bean.setDescription("Personal Loan is a cllass of loan that is for personal need");

//        int status = dao.updateLoanClassRecord(bean);
//        System.out.println("Record updated Successfully: "+status);

        //Deleting Record in the database
//        int status = dao.deleteLoanClassRecord("LC01");
//        System.out.println("Record deleted Successfully: "+status);

        //Geting a single Record from the database
        bean = dao.getLoanClassRecord("A1");

        System.out.println("\tLoanClassID: "+bean.getLoanClassId());
        System.out.println("\tLoanClass: "+bean.getLoanClass());
        System.out.println("\tDescription: "+bean.getDescription());
        System.out.println("\tEntryDate: "+bean.getEntryDate());
        
        //Getting List of Record in a table
        List<LoanClassBean> users = dao.getLoanClassList();
        for (LoanClassBean user : users) {

            System.out.println("\tLoanClassID: "+bean.getLoanClassId());
            System.out.println("\tLoanClass: "+bean.getLoanClass());
            System.out.println("\tDescription: "+bean.getDescription());
            System.out.println("\tEntryDate: "+bean.getEntryDate());

            System.out.println("*****************************************");
            System.out.println("");
            
        }
    }
    
    
    
}
