/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import 

@XmlRootElement(name = "Apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentXML {

    private List<Apartment> apartment;

    public List<Apartment> getApartment() {
        return Apartment;
    }

    public void setApartment(List<Apartment> apartment) {
        this.apartment = apartment;
    }
}

