/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuphidichvucanho.action;
import com.mycompany.quanlythuphidichvucanho.entity.Apartment;
import com.mycompany.quanlythuphidichvucanho.entity.ApartmentXML;
import com.mycompany.quanlythuphidichvucanho.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ManagerApartment {
    private static final String APARTMENT_FILE_NAME = "Apartment.xml";
    private List<Apartment> listApartment;

    // Constructor: khởi tạo danh sách căn hộ, nếu chưa có thì tạo mới
    public ManagerApartment() {
        this.listApartment = readListApartment();
        if (listApartment == null) {
            listApartment = new ArrayList<>();
        }
    }

    /**
     * Ghi danh sách căn hộ vào file XML.
     * @param apartments Danh sách căn hộ cần ghi.
     */
    public void writeListApartment(List<Apartment> apartments) {
        ApartmentXML apartmentXML = new ApartmentXML();
        apartmentXML.setApartment(apartments);
        FileUtils.writeXMLtoFile(APARTMENT_FILE_NAME, apartmentXML);
    }

    /**
     * Đọc danh sách căn hộ từ file XML.
     * @return Danh sách căn hộ nếu đọc thành công, nếu không trả về danh sách rỗng.
     */
    public List<Apartment> readListApartment() {
        ApartmentXML apartmentXML = (ApartmentXML) FileUtils.readXMLFile(
                APARTMENT_FILE_NAME, ApartmentXML.class);
        if (apartmentXML != null) {
            return apartmentXML.getApartment();
        }
        return new ArrayList<>();
    }

    /**
     * Thêm căn hộ mới vào danh sách. ID được tự động tăng dựa trên ID lớn nhất hiện tại.
     * @param apartment Căn hộ cần thêm.
     */
    public void addApartment(Apartment apartment) {
        int maxId = 0;
        for (Apartment a : listApartment) {
            if (a.getId() > maxId) maxId = a.getId();
        }
        apartment.setId(maxId + 1);
        listApartment.add(apartment);
        writeListApartment(listApartment);
    }

    /**
     * Xóa căn hộ theo ID.
     * @param id ID của căn hộ cần xóa.
     * @return true nếu xóa thành công, false nếu không tìm thấy.
     */
    public boolean deleteApartment(int id) {
        Apartment toDelete = null;
        for (Apartment a : listApartment) {
            if (a.getId() == id) {
                toDelete = a;
                break;
            }
        }
        if (toDelete != null) {
            listApartment.remove(toDelete);
            writeListApartment(listApartment);
            return true;
        }
        return false;
    }

    /**
     * Cập nhật thông tin căn hộ dựa trên ID.
     * @param apartment Đối tượng căn hộ đã được cập nhật.
     */
    public void editApartment(Apartment apartment) {
        for (int i = 0; i < listApartment.size(); i++) {
            if (listApartment.get(i).getId() == apartment.getId()) {
                listApartment.set(i, apartment);
                writeListApartment(listApartment);
                break;
            }
        }
    }

    /**
     * Tìm kiếm căn hộ theo tên chủ sở hữu (owner).
     * @param keyword Từ khóa cần tìm trong tên chủ sở hữu.
     * @return Danh sách các căn hộ khớp từ khóa.
     */
    public List<Apartment> searchByOwner(String keyword) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment a : listApartment) {
            if (a.getOwnerName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Sắp xếp danh sách căn hộ theo tên chủ sở hữu theo thứ tự tăng dần.
     */
    public void sortByOwnerName() {
        Collections.sort(listApartment, Comparator.comparing(Apartment::getOwnerName));
    }

    /**
     * Sắp xếp danh sách căn hộ theo ID tăng dần.
     */
    public void sortById() {
        Collections.sort(listApartment, Comparator.comparingInt(Apartment::getId));
    }

    /**
    * Sắp xếp danh sách căn hộ theo tên chủ sở hữu theo thứ tự giảm dần.
    */
    public void sortByOwnerNameDescending() {
        Collections.sort(listApartment, Comparator.comparing(Apartment::getOwnerName).reversed());
    }

    /**
    * Sắp xếp danh sách căn hộ theo ID giảm dần.
    */
    public void sortByIdDescending() {
        Collections.sort(listApartment, Comparator.comparingInt(Apartment::getId).reversed());
    }
    
    
    /**
     * Tính tổng phí dịch vụ của căn hộ theo ID.
     * @param id ID của căn hộ cần tính phí.
     * @return Tổng phí dịch vụ nếu tìm thấy căn hộ, 0 nếu không tìm thấy.
     */
    public double getTotalServiceFeeById(int id) {
        for (Apartment a : listApartment) {
            if (a.getId() == id) {
                return a.calculateTotalFee();
            }
        }
        return 0;
    }

    /**
     * Trả về danh sách tất cả các căn hộ hiện tại.
     * @return Danh sách căn hộ.
     */
    public List<Apartment> getListApartment() {
        return listApartment;
    }

    /**
     * Cập nhật lại toàn bộ danh sách căn hộ (thay thế).
     * @param listApartment Danh sách căn hộ mới.
     */
    public void setListApartment(List<Apartment> listApartment) {
        this.listApartment = listApartment;
    }
}