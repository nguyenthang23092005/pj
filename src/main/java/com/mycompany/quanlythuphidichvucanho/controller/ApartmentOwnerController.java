/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.controller;
import com.mycompany.quanlythuphidichvucanho.action.ManagerApartmentOwner;
import com.mycompany.quanlythuphidichvucanho.entity.ApartmentOwner;
import com.mycompany.quanlythuphidichvucanho.view.LoginView;
import com.mycompany.quanlythuphidichvucanho.view.MainView;
import com.mycompany.quanlythuphidichvucanho.view.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ApartmentOwnerController {
    private ManagerApartmentOwner managerApartmentOwner;
    private ManagerView apartmentOwnerView;
    private MainView mainView;

    public ApartmentOwnerController(ManagerView view) {
        this.apartmentOwnerView = view;
        this.managerApartmentOwner = new ManagerApartmentOwner();

        view.addAddApartmentOwnerListener(new AddApartmentOwnerListener());
        view.addEditApartmentOwnerListener(new EditApartmentOwnerListener());
        view.addClearListener(new ClearApartmentOwnerListener());
        view.addDeleteApartmentOwnerListener(new DeleteApartmentOwnerListener());
        view.addListApartmentOwnerSelectionListener(new ListApartmentOwnerSelectionListener());
        view.addSearchListener(new SearchApartmentOwnerListener());
        view.addSortByNameListener(new SortApartmentOwnerNameListener());
        view.addSortByIDListener(new SortApartmentOwnerIDListener());
        view.addCancelSearchListener(new CancelSearchApartmentOwnerListener());
        view.addUndoListener(new UndoListener());
    }

    public void showManagerView() {
        List<ApartmentOwner> list = managerApartmentOwner.getListApartmentOwners();
        apartmentOwnerView.setVisible(true);
        apartmentOwnerView.showListApartmentOwners(list);
        apartmentOwnerView.showCountListApartmentOwners(list);
    }

    class AddApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApartmentOwner owner = apartmentOwnerView.getApartmentOwnerInfo();
            if (owner != null) {
                managerApartmentOwner.add(owner);
                apartmentOwnerView.showApartmentOwner(owner);
                apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showCountListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showMessage("Thêm thành công!");
            }
        }
    }

    class EditApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApartmentOwner owner = apartmentOwnerView.getApartmentOwnerInfo();
            if (owner != null) {
                managerApartmentOwner.edit(owner);
                apartmentOwnerView.showApartmentOwner(owner);
                apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showCountListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApartmentOwner owner = apartmentOwnerView.getApartmentOwnerInfo();
            if (owner != null) {
                managerApartmentOwner.delete(owner);
                apartmentOwnerView.clearApartmentOwnerInfo();
                apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showCountListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
                apartmentOwnerView.showMessage("Xóa thành công!");
            }
        }
    }

    class ListApartmentOwnerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            try {
                apartmentOwnerView.fillApartmentOwnerFromSelectedRow();
            } catch (Exception ex) {
                Logger.getLogger(ApartmentOwnerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class SearchApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String search = apartmentOwnerView.getSearchQuery();
            List<ApartmentOwner> result = managerApartmentOwner.search(search);
            if (!result.isEmpty()) {
                apartmentOwnerView.showListApartmentOwners(result);
            } else {
                apartmentOwnerView.showMessage("Không tìm thấy kết quả!");
            }
        }
    }

    class SortApartmentOwnerNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerApartmentOwner.sortByName();
            apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
        }
    }

    class SortApartmentOwnerIDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerApartmentOwner.sortByID();
            apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
        }
    }

    class CancelSearchApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentOwnerView.showListApartmentOwners(managerApartmentOwner.getListApartmentOwners());
        }
    }

    class UndoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView = new MainView();
            MainController controller = new MainController(mainView);
            controller.showMainView();
            apartmentOwnerView.setVisible(false);
        }
    }

    class ClearApartmentOwnerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentOwnerView.clearApartmentOwnerInfo();
        }
    }
}