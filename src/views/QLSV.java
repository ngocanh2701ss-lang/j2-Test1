package views;

import java.util.ArrayList;
import java.util.Scanner;
import model.SinhVien;
import repository.SinhVienRepository;

/**
 *
 * @author Ánh Baby
 */
public class QLSV {

    //repo, sc: Nhớ khai báo Static mjes. Vì static chỉ dùng với static
    static SinhVienRepository repo = new SinhVienRepository();
    static Scanner sc = new Scanner(System.in);

    //các phương thức nhớ static nhé
    public static void inDanhSachSV() {

        //gọi getAll của repo để lấy dữ liệu
        ArrayList<SinhVien> list = repo.getAll();
        //duyệt list => inSv
        System.out.println("DSSV là: ");
        for (SinhVien hihi : list) {
            System.out.println(hihi);

        }
    }

    public static void timTheoMa() {
        System.out.println("Mời nhập mã sinh viên cần tìm ");
        String ma = sc.nextLine();
        //gọi phương thức tìm bên repo
        SinhVien sv = repo.findByMasv(ma);

        if (sv != null) {
            System.out.println("Đã tìm thấy sv: " + sv);
        } else {
            System.out.println("Không tìm thấy SV có mã: " + ma);
        }

    }

    public static void themSV() {
        System.out.println("Mời nhập tên sinh viên cần thêm: ");
        System.out.print("Mời nhập MaSV: ");
        String maSV = sc.nextLine();
        System.out.println("Mời nhập họ tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Mời bạn nhập giới tính Nam/Nữ: ");
        String gt = sc.nextLine();
        boolean gioiTinh = gt.equalsIgnoreCase("Nam") ? true : false;
        System.out.println("Mời bạn nhập điểm trung bình: ");
        double diemTB = Double.parseDouble(sc.nextLine());

        SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, diemTB);

        int row = repo.addSinhVien(sv);

        if (row > 0) {
            System.out.println("Thêm thành công sv: " + sv);
            inDanhSachSV();
        } else {
            System.out.println("Không thêm được dòng nào: ");
        }
    }

    public static void xoaSV() {
        System.out.print("Mời nhập MaSV cần xóa: ");
        String maSV = sc.nextLine();
//        System.out.println("Mời nhập họ tên: ");
//        String hoTen = sc.nextLine();
//        System.out.println("Mời bạn nhập giới tính Nam/Nữ: ");
//        String gt = sc.nextLine();
//        boolean gioiTinh = gt.equalsIgnoreCase("Nam") ? true : false;
//        System.out.println("Mời bạn nhập điểm trung bình: ");
//        double diemTB = Double.parseDouble(sc.nextLine());

//        SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, diemTB);
        int row = repo.deleteSinhVien(maSV);

        if (row > 0) {
            System.out.println("xóa thành công sv: " + maSV);
            inDanhSachSV();
        } else {
            System.out.println("Không xóa được dòng nào: ");
        }
        //cách code nhanh nhớ mấy cái chính và thay đổi một số là duiowj nhé

    }

    public static void xoaSV_Pro() {
        System.out.print("Mời nhập MaSV cần xóa: ");
        String maSV = sc.nextLine();

        SinhVien svTim = repo.findByMasv(maSV);
        if (svTim != null) {
            System.out.println("Đã tìm thấy sv: " + svTim);
            int row = repo.deleteSinhVien(maSV);

            if (row > 0) {
                System.out.println("xóa thành công sv: " + maSV);
                inDanhSachSV();
            } else {
                System.out.println("Không xóa được dòng nào: ");

            }
        } else {
            System.out.println("Không tìm thấy SV có mã: " + maSV);
        }
        //cách code nhanh nhớ mấy cái chính và thay đổi một số là duiowj nhé

    }

    public static void suaSV() {
        System.out.println("Mời nhập tên sinh viên cần sửa: ");
        System.out.print("Mời nhập MaSV: ");
        String maSV = sc.nextLine();
        System.out.println("Mời nhập họ tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Mời bạn nhập giới tính Nam/Nữ: ");
        String gt = sc.nextLine();
        boolean gioiTinh = gt.equalsIgnoreCase("Nam") ? true : false;
        System.out.println("Mời bạn nhập điểm trung bình: ");
        double diemTB = Double.parseDouble(sc.nextLine());

        SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, diemTB);

        int row = repo.updateSinhVien(sv);

        if (row > 0) {
            System.out.println("sửa thành công sv: " + sv);
            inDanhSachSV();
        } else {
            System.out.println("Không sửa được dòng nào: ");
        }
        //cách code nhanh nhớ mấy cái chính và thay đổi một số là duiowj nhé

    }

    public static void suaSV_Pro() {
        System.out.println("Mời nhập tên sinh viên cần sửa: ");
        System.out.print("Mời nhập MaSV: ");
        String maSV = sc.nextLine();

        SinhVien svTim = repo.findByMasv(maSV);
        if (svTim != null) {
            System.out.println("Đã tìm thấy sv: " + svTim);
            System.out.println("Mời nhập thông tin mới: ");
            System.out.println("Nời nhập họ tên: ");
            String hoTen = sc.nextLine();

//        System.out.println("Mời nhập họ tên: ");
//        String hoTen = sc.nextLine();
            System.out.println("Mời bạn nhập giới tính Nam/Nữ: ");
            String gt = sc.nextLine();
            boolean gioiTinh = gt.equalsIgnoreCase("Nam") ? true : false;
            System.out.println("Mời bạn nhập điểm trung bình: ");
            double diemTB = Double.parseDouble(sc.nextLine());

            SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, diemTB);

            int row = repo.updateSinhVien(sv);

            if (row > 0) {
                System.out.println("sửa thành công sv: " + sv);
                inDanhSachSV();
            } else {
                System.out.println("Không sửa được dòng nào: ");
            }
        } else {
            System.out.println("Không tìm thấy SV có mã: " + maSV);
        }
        //cách code nhanh nhớ mấy cái chính và thay đổi một số là duiowj nhé

    }

    public static void main(String[] args) {
        int chon;
        while (true) {
            System.out.println("------------------------- ");
            System.out.println("|1. load toàn bộ danh sách SV: ");
            System.out.println("|2. Thêm SV");
            System.out.println("|3. Sửa SV");
            System.out.println("|4. Xóa SV");
            System.out.println("|5. Tìm theo mã sv");
            System.out.println("|6. Sửa SV pro");
            System.out.println("|7. Xoa SV pro");
            System.out.println("|0. Thoát");
            System.out.println("---------------------------");
            System.out.println("Mời bạn chọn 1 mục:");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("|1. gọi danh sách sv");
                    inDanhSachSV();
                    //lát phục vụ sau
                    break;
                case 2:
                    System.out.println("|2. Thêm SV  ");
                    themSV();
                    break;
                case 3:
                    System.out.println("|3. Sửa SV  ");
                    suaSV();
                    break;
                case 4:
                    System.out.println("|4. Xóa SV  ");
                    xoaSV();
                    break;
                case 5:
                    System.out.println("|5. Tìm theo mã sv ");
                    timTheoMa();
                    break;
                case 6:
                    System.out.println("|6. Sua SV pro");
                    suaSV_Pro();
                    break;
                case 7:
                    System.out.println("|7. Xoa SV pro");
                    xoaSV_Pro();
                    break;

                case 0:
                    System.out.println("|0. Thoát");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Mục bạn chọn không có, vui lòng chọn lại!");
                    break;
            }
        }

    }

}
