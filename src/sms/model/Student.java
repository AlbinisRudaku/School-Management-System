package sms.model;

public class Student {

    private int adNo;
    private String fullName;
    private String dob;
    private String doa;
    private String gender;
    private String grade;
    private String parentName;
    private String nic;
    private String phone;
    private String address;


    public Student(int adNo, String fullName, String dob, String doa, String gender, String grade, String parentName, String nic, String phone, String address) {
        this.adNo = adNo;
        this.fullName = fullName;
        this.dob = dob;
        this.doa = doa;
        this.gender = gender;
        this.grade = grade;
        this.parentName = parentName;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
    }

    public Student(String grade) {
        this.grade = grade;
    }

    public Integer getAdNo() {return adNo;}

    public void setAdNo(int adNo) {
        this.adNo = adNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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
}
