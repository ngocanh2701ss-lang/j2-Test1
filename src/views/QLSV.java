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

    public static void timTheoMa(){
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

    public static void main(String[] args) {
        int chon;
        while (true) {
            System.out.println("------------------------- ");
            System.out.println("|1. load toàn bộ danh sách SV: ");
            System.out.println("|2. ");
            System.out.println("|5. Tìm theo mã sv");
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
                    System.out.println("|2.  ");

                    break;
                case 5:
                    System.out.println("|5. Tìm theo mã sv ");
                    timTheoMa();
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
