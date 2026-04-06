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
    //về nhà nhớ code nhiều và luyện tập để ôn tập 

    //Thêm sinh viên CSDL => trả về số nguyên dòng thêm được
    public int addSinhVien(SinhVien sv) {

        int row = 0;
        try {
            sql = "insert into SINHVIEN(Masv, Hoten, GioiTinh, DiemTB)\n"
                    + "values(?, ?, ?, ?)";// đoạn này copy từ sql sang

            ps = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?

            ps.setObject(1, sv.getMaSV());
            ps.setObject(2, sv.getHoTen());
            ps.setObject(3, sv.isGioiTinh());// giới tính là boolean nên là dùng là is chứ không get
            ps.setObject(4, sv.getDiemTB());

            row = ps.executeUpdate();
            //thi hành câu sql 

        } catch (Exception e) {
            e.printStackTrace();// kiểu gì cũng ra lỗi in ra lỗi

        }

        return row;

    }

    //sửa SV vafp CSDL => trả về số nguyên dòng sửa được
    public int updateSinhVien(SinhVien sv) {
        int row = 0;
        try {
            sql = "update SINHVIEN\n"
                    + "set Hoten=?, GioiTinh=?, DiemTB=?\n"
                    + "where Masv=?";// đoạn này copy từ sql sang

            ps = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?

            ps.setObject(4, sv.getMaSV());
            ps.setObject(1, sv.getHoTen());
            ps.setObject(2, sv.isGioiTinh());// giới tính là boolean nên là dùng là is chứ không get
            ps.setObject(3, sv.getDiemTB());

            row = ps.executeUpdate();
            //thi hành câu sql 

        } catch (Exception e) {
            e.printStackTrace();// kiểu gì cũng ra lỗi in ra lỗi

        }

        return row;

    }
    //xóa SV vafp CSDL => trả về số nguyên dòng sửa được

    public int deleteSinhVien(String maSVXoa) {
        int row = 0;
        try {
            sql = "delete from SINHVIEN\n"
                    + "where Masv =?";// đoạn này copy từ sql sang

            ps = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?

            ps.setObject(1, maSVXoa);// cần chú ý các dấu ngoặc là dược 
//            ps.setObject(1, sv.getHoTen());
//            ps.setObject(2, sv.isGioiTinh());// giới tính là boolean nên là dùng là is chứ không get
//            ps.setObject(3, sv.getDiemTB());

            row = ps.executeUpdate();
            //thi hành câu sql 

        } catch (Exception e) {
            e.printStackTrace();// kiểu gì cũng ra lỗi in ra lỗi

        }

        return row;

    }

  

}
