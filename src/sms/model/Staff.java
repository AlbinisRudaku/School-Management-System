package sms.model;

public class Staff {

    private int empNo;
    private String teacherName;
    private String dob;
    private String gender;
    private String email;
    private String assumpOfDuties;
    private String phone;
    private String address;
    private String prsntGrade;

    public Staff(int empNo, String teacherName, String dob, String gender, String email, String assumpOfDuties, String phone, String address, String prsntGrade) {
        this.empNo = empNo;
        this.teacherName = teacherName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.assumpOfDuties = assumpOfDuties;
        this.phone = phone;
        this.address = address;
        this.prsntGrade = prsntGrade;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssumpOfDuties() {
        return assumpOfDuties;
    }

    public void setAssumpOfDuties(String assumpOfDuties) {
        this.assumpOfDuties = assumpOfDuties;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrsntGrade() {
        return prsntGrade;
    }

    public void setPrsntGrade(String prsntGrade) {
        this.prsntGrade = prsntGrade;
    }
}
