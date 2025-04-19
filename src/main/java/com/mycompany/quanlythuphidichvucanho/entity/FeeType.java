/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

public enum FeeType {
    QUAN_LY("Phí quản lý"),
    THANG_MAY("Phí thang máy"),
    DIEN("Tiền điện"),
    NUOC("Tiền nước"),
    GAS("Tiền gas"),
    DIEU_HOA("Phí điều hòa"),
    VE_SINH("Phí vệ sinh"),
    BAO_DUONG("Phí bảo dưỡng"),
    TRONG_XE("Phí trông xe");

    private String moTa;

    LoaiPhi(String moTa) {
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }
}