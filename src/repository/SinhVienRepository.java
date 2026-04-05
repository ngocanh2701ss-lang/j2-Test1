package repository;

import java.sql.*;
import java.util.ArrayList;
import model.SinhVien;
import util.DbConnection;

/**
 *
 * @author Ánh Baby
 */
public class SinhVienRepository {

    //Chứa các phương thức thap\o tác CSDL 
//    để chạy câu lênh sql, 
//    String sql;
//    Connection cn = DbConnection.getConnection();
//
//    PreparedStatement ps;
//
//    ResultSet rs;
    private Connection cn = null; // bienket noi vs sql
    private PreparedStatement ps = null;
    private String sql;
    private ResultSet rs;

    //viết nhanh gõ sinhvien
    public SinhVienRepository() {
        cn = DbConnection.getConnection();
    }

    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = new ArrayList<>();

        try {
            sql = "select Masv, Hoten, GioiTinh, DiemTB\n"
                    + "from SINHVIEN";

            //tạo Stateam
            ps = cn.prepareStatement(sql);
            //Thi hành câu sql select => dùng ResuletSet mjaajm ld
            rs = ps.executeQuery();
            //duyệt ts => lấy dữ liệu đổ vào list
            while (rs.next()) {
                //khai báo 4 biến
                String maSV = rs.getString(1);// lấy theo thứ cột
                String hoTen = rs.getString(2);
                boolean gioiTinh = rs.getBoolean(3);
                double diemTB = rs.getDouble(4);
                //sau khi lấy xong thì thêm vào list
                list.add(new SinhVien(maSV, hoTen, gioiTinh, diemTB));
            }

        } catch (Exception e) {
            e.printStackTrace();//in ra lỗi
        }
        return list;
    }

    //vào CSDL tìm theo maSV
    //vào CSDL tìm theo maSV, không tìm thấy trả về null
    public SinhVien findByMasv(String masvTim) {
        ArrayList<SinhVien> list = new ArrayList<>();

        try {
            sql = "select Masv, Hoten, GioiTinh, DiemTB\n"
                    + "from SINHVIEN\n"
                    + "where Masv =?";
            //xóa list

            //tạo Stateam
            ps = cn.prepareStatement(sql);
            //Gán giá trị
            ps.setObject(1, masvTim);

            //Thi hành câu sql select => dùng ResuletSet mjaajm ld
            rs = ps.executeQuery();
            //duyệt ts => lấy dữ liệu đổ vào list
            while (rs.next()) {
                //khai báo 4 biến
                String maSV = rs.getString(1);// lấy theo thứ cột
                String hoTen = rs.getString(2);
                boolean gioiTinh = rs.getBoolean(3);
                double diemTB = rs.getDouble(4);
                //sau khi lấy xong thì thêm vào list
                return new SinhVien(maSV, hoTen, gioiTinh, diemTB);
            }

        } catch (Exception e) {
            e.printStackTrace();//in ra lỗi
        }
        return null;
    }
}