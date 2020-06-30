package Class;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn (name = "maLop")
    private Lop lop;
    @OneToMany (mappedBy = "sv")
    private Set<Thamgia> thamgia;
    @Column(name = "password")
    private String password;


    @Column(name = "hoTen")
    private String hoTen;
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @Column(name = "cmnd")
    private String cmnd;
    public Sinhvien()
    {
        thamgia = new HashSet<Thamgia>();
    }

    public Sinhvien(String maSV,Lop lop , String password, String hoTen,
                    String gioiTinh, String cmnd) {
        this.maSV = maSV;
        this.lop = lop;
        this.password = password;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        thamgia = new HashSet<Thamgia>();
    }

    public Sinhvien(String maSV, Lop lop, Set<Thamgia> thamgia, String password,
                     String hoTen, String gioiTinh, String cmnd) {
        this.maSV = maSV;
        this.lop = lop;
        this.thamgia = thamgia;
        this.password = password;
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
    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Set<Thamgia> getThamgia() {
        return thamgia;
    }

    public void setThamgia(Set<Thamgia> thamgia) {
        this.thamgia = thamgia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
