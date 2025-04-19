/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

import java.time.LocalDate;

/**
 *
 * @author Nguyen Van Thang
 */
public class ServiceFee {
     private String maPhi;
    private Apartment canHo;
    private FeeType loaiPhi;
    private double soTien;
    private LocalDate ngayThu;
    private String ghiChu;

    public PhiDichVu(String maPhi, Apartment canHo, FeeType loaiPhi, 
                    double soTien, LocalDate ngayThu, String ghiChu) {
        this.maPhi = maPhi;
        this.canHo = canHo;
        this.loaiPhi = loaiPhi;
        this.soTien = soTien;
        this.ngayThu = ngayThu;
        this.ghiChu = ghiChu;
    }

    public String getMaPhi() {
        return maPhi;
    }

    public void setMaPhi(String maPhi) {
        this.maPhi = maPhi;
    }

    public CanHo getCanHo() {
        return canHo;
    }

    public void setCanHo(Apartment canHo) {
        this.canHo = canHo;
    }

    public LoaiPhi getLoaiPhi() {
        return loaiPhi;
    }

    public void setLoaiPhi(FeeType loaiPhi) {
        this.loaiPhi = loaiPhi;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public LocalDate getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(LocalDate ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    @Override
    public String toString() {
        return String.format("Phiếu %s - %s - %s - %,.0f VND - %s", 
                maPhi, loaiPhi.getMoTa(), canHo.getOwnerName(), 
                soTien, ngayThu.toString());
    }
}
