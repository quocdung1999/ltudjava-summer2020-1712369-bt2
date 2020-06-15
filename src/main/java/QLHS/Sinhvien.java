package QLHS;

import javax.persistence.*;

/*
 *QLHS
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/13/2020 - 10:28 PM
 *@Description

 */
@Entity
@Table(name = "sv", schema = "quanlysinhvien")
public class Sinhvien {
    @Id
    @Column(name = "maSV")
    private String maSV;
    @Column(name = "hoTen")
    private String hoTen;
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @Column(name = "cmnd")
    private String cmnd;
    public Sinhvien()
    {

    }
    public Sinhvien(String maSV, String hoTen, String gioiTinh, String cmnd) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}
