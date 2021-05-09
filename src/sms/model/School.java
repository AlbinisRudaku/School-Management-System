package sms.model;

public class School {

    private String schoolName;
    private String schoolAddress;
    private String classAvailable;
    private String postalCode;
    private String dateOfEstd;
    private String totalLandArea;
    private String province;
    private String nameOfPrincipal;
    private String pricipalNo;

    public School() {
    }

    public School(String schoolName, String schoolAddress, String classAvailable, String postalCode, String dateOfEstd, String totalLandArea, String province, String nameOfPrincipal, String pricipalNo) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.classAvailable = classAvailable;
        this.postalCode = postalCode;
        this.dateOfEstd = dateOfEstd;
        this.totalLandArea = totalLandArea;
        this.province = province;
        this.nameOfPrincipal = nameOfPrincipal;
        this.pricipalNo = pricipalNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        schoolAddress = schoolAddress;
    }

    public String getClassAvailable() {
        return classAvailable;
    }

    public void setClassAvailable(String classAvailable) {
        this.classAvailable = classAvailable;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDateOfEstd() {
        return dateOfEstd;
    }

    public void setDateOfEstd(String dateOfEstd) {
        this.dateOfEstd = dateOfEstd;
    }

    public String getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(String totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNameOfPrincipal() {
        return nameOfPrincipal;
    }

    public void setNameOfPrincipal(String nameOfPrincipal) {
        this.nameOfPrincipal = nameOfPrincipal;
    }

    public String getPricipalNo() {
        return pricipalNo;
    }

    public void setPricipalNo(String pricipalNo) {
        this.pricipalNo = pricipalNo;
    }
}
