/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaplus.loans.beans;

/**
 *
 * @author HP1
 */
public class LoanClassBean {
    
    private String loanClassId;
    private String loanClass;
    private String description;
    private String entryDate;

    
    public String getLoanClassId() {
        return loanClassId;
    }

    public void setLoanClassId(String loanClassId) {
        this.loanClassId = loanClassId;
    }

    public String getLoanClass() {
        return loanClass;
    }

    public void setLoanClass(String loanClass) {
        this.loanClass = loanClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
    
    
}
