/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

public class Apartment {
    private String apartmentID;
    private String building;
    private int floor;
    private double acreage;
    private String status;
    private String ownerName;
    private int memberNumber;

    
    public Apartment(){
    }

    public Apartment(String apartmentID, String building, int floor, double acreage, String status, String ownerName, int memberNumber) {
        this.apartmentID = apartmentID;
        this.building = building;
        this.floor = floor;
        this.acreage = acreage;
        this.status = status;
        this.ownerName = ownerName;
        this.memberNumber = memberNumber;
    }

    public String getApartmentID() {
        return this.apartmentID;
    }

    public void setApartmentID(String apartmentID) {
        this.apartmentID = apartmentID;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getAcreage() {
        return this.acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getMemberNumber() {
        return this.memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    
    
    

    @Override
    public String toString() {
        return "Mã Căn Hộ: " + this.apartmentID +", Số tòa: "+this.building+", Tầng: "+this.floor+
               ", Diện tích: " + this.acreage + "m2,"+", Trạng thái: " + this.status + ", Chủ hộ: " + this.ownerName +  ",Số thành viên: " + this.memberNumber;
    }
}