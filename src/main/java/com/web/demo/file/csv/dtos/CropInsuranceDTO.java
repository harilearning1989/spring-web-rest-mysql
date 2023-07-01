package com.web.demo.file.csv.dtos;

public class CropInsuranceDTO {

    private int id;
    private String mandalName;
    private String villageName;
    private String nameOfTheBeneficiary;
    private String crop;
    private double extentHa;
    private double claimAmountRs;
    private String categoryLoaneeNonLoanee;
    private String bankName;
    private String branchName;
    private String accountNumber;

    public int getId() {
        return id;
    }

    public void setId(int serialNumber) {
        this.id = serialNumber;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getNameOfTheBeneficiary() {
        return nameOfTheBeneficiary;
    }

    public void setNameOfTheBeneficiary(String nameOfTheBeneficiary) {
        this.nameOfTheBeneficiary = nameOfTheBeneficiary;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getExtentHa() {
        return extentHa;
    }

    public void setExtentHa(double extentHa) {
        this.extentHa = extentHa;
    }

    public double getClaimAmountRs() {
        return claimAmountRs;
    }

    public void setClaimAmountRs(double claimAmountRs) {
        this.claimAmountRs = claimAmountRs;
    }

    public String getCategoryLoaneeNonLoanee() {
        return categoryLoaneeNonLoanee;
    }

    public void setCategoryLoaneeNonLoanee(String categoryLoaneeNonLoanee) {
        this.categoryLoaneeNonLoanee = categoryLoaneeNonLoanee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
