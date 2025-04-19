/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@XmlRootElement(name = "ApartmentOwner")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentOwnerXML {
    private List<ApartmentOwner> apartmentOwners;

    public List<ApartmentOwner> getApartmentOwner() {
        return apartmentOwners;
    }

    public void setApartmentOwner(List<ApartmentOwner> apartmentOwner) {
        this.apartmentOwners = apartmentOwner;
    } 
}
