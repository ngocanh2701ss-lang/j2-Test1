package model;


/**
 *
 * @author Ánh Baby
 */
public class SinhVien {
  private String maSV;
  private String hoTen;
  private boolean gioiTinh;     
  private double diemTB;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, boolean gioiTinh, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diemTB=" + diemTB + '}';
    }
  

}
