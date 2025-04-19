/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.action;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Van Thang
 */

public class ManagerOwnerApartment {
    private static final String FILE_NAME = "OwnerApartment.xml";
    private List<OwnerApartment> listOwner;

    public ManagerOwnerApartment() {
        this.listOwner = readFromFile();
        if (listOwner == null) {
            listOwner = new ArrayList<>();
        }
    }

    // Đọc danh sách từ file XML
    public List<OwnerApartment> readFromFile() {
        OwnerApartmentXML wrapper = (OwnerApartmentXML) FileUtils.readXMLFile(FILE_NAME, OwnerApartmentXML.class);
        if (wrapper != null) return wrapper.getOwners();
        return new ArrayList<>();
    }

    // Ghi danh sách vào file XML
    public void writeToFile() {
        OwnerApartmentXML wrapper = new OwnerApartmentXML();
        wrapper.setOwners(listOwner);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    // Thêm người chủ mới, tự động tăng ID
    public void addOwner(OwnerApartment owner) {
        int maxId = 0;
        for (OwnerApartment o : listOwner) {
            if (o.getId() > maxId) maxId = o.getId();
        }
        owner.setId(maxId + 1);
        listOwner.add(owner);
        writeToFile();
    }

    // Xóa người chủ theo ID
    public boolean deleteOwnerById(int id) {
        Iterator<OwnerApartment> iterator = listOwner.iterator();
        while (iterator.hasNext()) {
            OwnerApartment o = iterator.next();
            if (o.getId() == id) {
                iterator.remove();
                writeToFile();
                return true;
            }
        }
        return false;
    }

    // Tìm kiếm theo tên
    public List<OwnerApartment> searchByName(String keyword) {
        List<OwnerApartment> result = new ArrayList<>();
        for (OwnerApartment o : listOwner) {
            if (o.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(o);
            }
        }
        return result;
    }

    // Tìm kiếm theo địa chỉ
    public List<OwnerApartment> searchByAddress(String keyword) {
        List<OwnerApartment> result = new ArrayList<>();
        for (OwnerApartment o : listOwner) {
            if (o.getAddress().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(o);
            }
        }
        return result;
    }

    // Tìm kiếm theo số hộ khẩu
    public List<OwnerApartment> searchByFamilyId(String keyword) {
        List<OwnerApartment> result = new ArrayList<>();
        for (OwnerApartment o : listOwner) {
            if (o.getFamilyId().contains(keyword)) {
                result.add(o);
            }
        }
        return result;
    }

    // Kiểm tra trùng số CCCD
    public boolean isCCCDUnique(String cccd) {
        for (OwnerApartment o : listOwner) {
            if (o.getCccd().equals(cccd)) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra vai trò "Chủ hộ" có trùng số hộ khẩu không
    public boolean isUniqueHousehold(String familyId) {
        for (OwnerApartment o : listOwner) {
            if ("Chủ hộ".equals(o.getRole()) && familyId.equals(o.getFamilyId())) {
                return false;
            }
        }
        return true;
    }

    // Cập nhật thông tin theo ID
    public boolean updateOwner(OwnerApartment updatedOwner) {
        for (int i = 0; i < listOwner.size(); i++) {
            if (listOwner.get(i).getId() == updatedOwner.getId()) {
                listOwner.set(i, updatedOwner);
                writeToFile();
                return true;
            }
        }
        return false;
    }

    // Sắp xếp theo tên tăng dần
    public void sortByNameAsc() {
        listOwner.sort((o1, o2) -> {
            Collator collator = Collator.getInstance(new Locale("vi", "VN"));
            return collator.compare(o1.getName(), o2.getName());
        });
    }

    // Sắp xếp theo tên giảm dần
    public void sortByNameDesc() {
        listOwner.sort((o1, o2) -> {
            Collator collator = Collator.getInstance(new Locale("vi", "VN"));
            return collator.compare(o2.getName(), o1.getName());
        });
    }

    // Sắp xếp theo ID tăng dần
    public void sortByIdAsc() {
        listOwner.sort(Comparator.comparingInt(OwnerApartment::getId));
    }

    // Sắp xếp theo ID giảm dần
    public void sortByIdDesc() {
        listOwner.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
    }

    // Sắp xếp theo số hộ khẩu tăng dần
    public void sortByFamilyIdAsc() {
        listOwner.sort(Comparator.comparing(OwnerApartment::getFamilyId));
    }

    // Sắp xếp theo số hộ khẩu giảm dần
    public void sortByFamilyIdDesc() {
        listOwner.sort((o1, o2) -> o2.getFamilyId().compareTo(o1.getFamilyId()));
    }

    // Trả về danh sách hiện tại
    public List<OwnerApartment> getOwnerList() {
        return this.listOwner;
    }

    // Hiển thị thông báo
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}