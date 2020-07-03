package Class;

import javax.persistence.*;
import java.math.BigDecimal;

/*
 *Class
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/18/2020 - 9:33 PM
 *@Description

 */
@Entity
@Table (name = "Thamgia", schema ="quanlysinhvien")
public class Thamgia {
    @EmbeddedId
    ThamgiaPK id;

    @ManyToOne
    @MapsId("maSV")
    @JoinColumn(name = "maSV")
    private Sinhvien sv;

    @ManyToOne
    @MapsId("IDMon")
    @JoinColumn(name = "IDMon")
    private Mon mon;

    @Column (name = "duyet")
    private boolean duyet;

    @Column (name = "khongHoc")
    private boolean khongHoc;

    @Column (name = "diemGK")
    private BigDecimal diemGK;

    @Column (name = "diemCK")
    private BigDecimal diemCK;

    @Column (name = "diemKhac")
    private BigDecimal diemKhac;

    @Column (name = "diemTong")
    private BigDecimal diemTong;

    public Thamgia() {
    	
    }

    public Thamgia( Sinhvien sv, Mon mon, boolean duyet, boolean khongHoc,
            BigDecimal diemGK, BigDecimal diemCK, BigDecimal diemKhac, BigDecimal diemTong) {
	 this.sv = sv;
	 this.mon = mon;
	 this.duyet = duyet;
	 this.khongHoc = khongHoc;
	 this.diemGK = diemGK;
	 this.diemCK = diemCK;
	 this.diemKhac = diemKhac;
	 this.diemTong = diemTong;
    }
    
    public Thamgia(ThamgiaPK id, Sinhvien sv, Mon mon, boolean duyet, boolean khongHoc,
                   BigDecimal diemGK, BigDecimal diemCK, BigDecimal diemKhac, BigDecimal diemTong) {
        this.id = id;
        this.sv = sv;
        this.mon = mon;
        this.duyet = duyet;
        this.khongHoc = khongHoc;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
        this.diemKhac = diemKhac;
        this.diemTong = diemTong;
    }

    public ThamgiaPK getId() {
        return id;
    }

    public void setId(ThamgiaPK id) {
        this.id = id;
    }

    public Sinhvien getSv() {
        return sv;
    }

    public void setSv(Sinhvien sv) {
        this.sv = sv;
    }

    public Mon getMon() {
        return mon;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    public boolean isDuyet() {
        return duyet;
    }

    public void setDuyet(boolean duyet) {
        this.duyet = duyet;
    }

    public boolean isKhongHoc() {
        return khongHoc;
    }

    public void setKhongHoc(boolean khongHoc) {
        this.khongHoc = khongHoc;
    }

    public BigDecimal getDiemGK() {
        return diemGK;
    }

    public void setDiemGK(BigDecimal diemGK) {
        this.diemGK = diemGK;
    }

    public BigDecimal getDiemCK() {
        return diemCK;
    }

    public void setDiemCK(BigDecimal diemCK) {
        this.diemCK = diemCK;
    }

    public BigDecimal getDiemKhac() {
        return diemKhac;
    }

    public void setDiemKhac(BigDecimal diemKhac) {
        this.diemKhac = diemKhac;
    }

    public BigDecimal getDiemTong() {
        return diemTong;
    }

    public void setDiemTong(BigDecimal diemTong) {
        this.diemTong = diemTong;
    }
}
