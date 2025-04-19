/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.controller;

import com.mycompany.quanlythuphidichvucanho.action.ManagerOwnerApartment;
import com.mycompany.quanlythuphidichvucanho.entity.ApartmentOwner;
import com.mycompany.quanlythuphidichvucanho.view.LoginView;
import com.mycompany.quanlythuphidichvucanho.view.MainView;
import com.mycompany.quanlythuphidichvucanho.view.ManagerView;
import com.mycompany.quanlythuphidichvucanho.view.ApartmentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author PC
 */
public class MainController 
{
    private LoginView loginView;
    private ManagerView managerView;
    private ApartmentView apartmentView;
    private MainView mainView;
    
    public MainController(MainView view)
    {
        this.mainView = view;
        view.addOwnerManagementListener(new OwnerManagementListener());
        view.addFeeManagementListener(new FeeManagementListener());
        
        view.addChooseSpecialPersonListener(new ChooseSpecialPersonListener());
        view.addChooseResidentsListener(new ChooseResidentListener());
    }
    public void showMainView() 
    {
        mainView.setVisible(true);
    }
    
    class ChooseApartmentListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            apartmentView = new ApartmentView();
            ApartmentController apartmentController = new ApartmentController(apartmentView);
            apartmentController.showManagerView();
            mainView.setVisible(false);
        }
    }
}
