/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.controller;
import com.mycompany.quanlythuphidichvucanho.action.ManagerApartment;
import com.mycompany.quanlythuphidichvucanho.action.ManagerApartment;
import com.mycompany.quanlythuphidichvucanho.entity.Apartment;
import com.mycompany.quanlythuphidichvucanho.view.LoginView;
import com.mycompany.quanlythuphidichvucanho.view.MainView;
import com.mycompany.quanlythuphidichvucanho.view.ManagerView;
import com.mycompany.quanlythuphidichvucanho.view.ApartmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lenovo
 */
public class ApartmentController {
    private LoginView loginView;
    private ManagerView managerView;
    private ApartmentView apartmentView;
    private MainView mainView;
    private ManagerApartment managerApartment;

    public ApartmentController(ApartmentView view) {
        this.apartmentView = view;
        this.managerApartment = new ManagerApartment();
        view.addUndoListener(new UndoListener());
        view.addAddApartmentListener(new AddApartmentListener());
        view.addListApartmentSelectionListener(new ListApartmentSelectionListener());
        view.addEditApartmentListener(new EditApartmentListener());
        view.addClearListener(new ClearApartmentListener());
        view.addDeleteApartmentListener(new DeleteApartmentListener());
        view.addSortApartmentListener(new SortApartmentListener());
        view.addSearchListener(new SearchApartmentViewListener());
        view.addSearchDialogListener(new SearchApartmentListener());
        view.addCancelSearchApartmentListener(new CancelSearchApartmentListener());
        view.addCancelDialogListener(new CancelDialogSearchApartmentListener());
    }

    public void showManagerView() {
        List<Apartment> apartmentList = managerApartment.getListApartment();
        apartmentView.setVisible(true);
        apartmentView.showListApartment(apartmentList);
        apartmentView.showCountListApartment(apartmentList);
        apartmentView.showStatisticType(apartmentList);
        apartmentView.showStatisticID(apartmentList);
    }

    class UndoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView = new MainView();
            MainController mainController = new MainController(mainView);
            mainController.showMainView();
            apartmentView.setVisible(false);
        }
    }

    class AddApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Apartment apartment = apartmentView.getApartmentInfo();
            if (apartment != null) {
                try {
                    if (!managerApartment.isApartmentIDUnique(apartment)) {
                        throw new IllegalArgumentException("Lỗi: Mã căn hộ đã tồn tại!");
                    }

                    managerApartment.add(apartment);
                    apartmentView.showApartment(apartment);
                    apartmentView.showListApartment(managerApartment.getListApartment());
                    apartmentView.showCountListApartment(managerApartment.getListApartment());
                    apartmentView.showStatisticType(managerApartment.getListApartment());
                    apartmentView.showStatisticID(managerApartment.getListApartment());
                    apartmentView.showMessage("Thêm thành công!");
                } catch (IllegalArgumentException ex) {
                    apartmentView.showMessage(ex.getMessage());
                }
            }
        }
    }

    class EditApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Apartment apartment = apartmentView.getApartmentInfo();
            if (apartment != null) {
                try {
                    managerApartment.edit(apartment);
                } catch (ParseException ex) {
                    Logger.getLogger(ApartmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                apartmentView.showApartment(apartment);
                apartmentView.showListApartment(managerApartment.getListApartment());
                apartmentView.showCountListApartment(managerApartment.getListApartment());
                apartmentView.showStatisticType(managerApartment.getListApartment());
                apartmentView.showStatisticID(managerApartment.getListApartment());
                apartmentView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Apartment apartment = apartmentView.getApartmentInfo();
            if (apartment != null) {
                managerApartment.delete(apartment);
                apartmentView.clearApartmentInfo();
                apartmentView.showListApartment(managerApartment.getListApartment());
                apartmentView.showCountListApartment(managerApartment.getListApartment());
                apartmentView.showStatisticType(managerApartment.getListApartment());
                apartmentView.showStatisticID(managerApartment.getListApartment());
                apartmentView.showMessage("Xóa thành công!");
            }
        }
    }

    class ListApartmentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            List<Apartment> apartmentList = managerApartment.getListApartment();
            try {
                apartmentView.fillApartmentFromSelectedRow(apartmentList);
            } catch (ParseException ex) {
                Logger.getLogger(ApartmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class ClearApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentView.clearApartmentInfo();
        }
    }

    class SortApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int check = apartmentView.getChooseSelectSort();
            if (check == 1) {
                managerApartment.sortApartmentByID();
                apartmentView.showListApartment(managerApartment.getListApartment());
            } else if (check == 2) {
                managerApartment.sortApartmentByName();
                apartmentView.showListApartment(managerApartment.getListApartment());
            } else if (check == 3) {
                managerApartment.sortApartmentByOwner();
                apartmentView.showListApartment(managerApartment.getListApartment());
            } else {
                apartmentView.showMessage("Bạn chưa chọn tiêu chí sắp xếp");
            }
        }
    }

    class SearchApartmentViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentView.searchApartmentInfo();
        }
    }

    class CancelDialogSearchApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentView.cancelDialogSearchApartmentInfo();
        }
    }

    class CancelSearchApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            apartmentView.showListApartment(managerApartment.getListApartment());
            apartmentView.cancelSearchApartment();
        }
    }

    class SearchApartmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Apartment> temp = new ArrayList<>();
            int check = apartmentView.getChooseSelectSearch();
            String search = apartmentView.validateSearch();
            if (check == 1) {
                temp = managerApartment.searchApartmentByID(search);
            } else if (check == 2) {
                temp = managerApartment.searchApartmentByName(search);
            } else if (check == 3) {
                temp = managerApartment.searchApartmentByYear(search);
            } else if (check == 4) {
                temp = managerApartment.searchApartmentByAddress(search);
            }
            if (!temp.isEmpty()) apartmentView.showListApartment(temp);
            else apartmentView.showMessage("Không tìm thấy kết quả!");
        }
    }
}
