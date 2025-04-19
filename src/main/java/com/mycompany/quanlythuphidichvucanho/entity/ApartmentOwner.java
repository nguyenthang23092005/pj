/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */

@XmlRootElement(name = "ApartmentOwner")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentOwner extends Person{
    private String IDFamily;
    private String sex;
    private String role;
    private String birthPlace;
    private Date birthDay;
    private String phoneNumber;
    
    public ApartmentOwner()
    {
    }
    
    public ApartmentOwner(String cccd, String name, Date birthday, String address, String IDFamily, String sex, String role, String birthPlace, String typeCMT, String CMT, String phoneNumber)
    {
        super();
        SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
        this.birthDay = birthday;
        this.IDFamily = IDFamily;
        this.sex = sex;
        this.role = role;
        this.birthPlace = birthPlace;
        
    }

    public String getIDFamily() {
        return this.IDFamily;
    }

    public void setIDFamily(String IDFamily) {
        this.IDFamily = IDFamily;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Mã gia đình: " + this.IDFamily + ", giới tính: " + this.sex + ", vai trò: " + this.role + ", nơi sinh: " + this.birthPlace + ", ngày sinh: " + this.birthDay + ", SĐT: " + this.phoneNumber ;
    }
    
}
