package Class;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 *Class
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/16/2020 - 11:06 PM
 *@Description

 */
@Entity
@Table(name = "lop", schema ="quanlysinhvien")
public class Lop {
    @Id
    @Column(name= "maLop")
    private String maLop;
    @OneToMany (mappedBy = "lopHoc")
    private Set<Mon> dsMon;

    @OneToMany (mappedBy = "lop")
    private Set<Sinhvien> dsSinhvien;
    public Lop() {
        dsMon = new HashSet<Mon>();
        dsSinhvien = new HashSet<>();
    }

    public Lop(String maLop, Set<Mon> dsMon,Set<Sinhvien> dsSinhvien) {
        this.maLop = maLop;
        this.dsMon = dsMon;
        this.dsSinhvien = dsSinhvien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public Set<Mon> getDsMon() {
        return dsMon;
    }

    public void setDsMon(Set<Mon> dsMon) {
        this.dsMon = dsMon;
    }

    public Set<Sinhvien> getDsSinhvien() {
        return dsSinhvien;
    }

    public void setDsSinhvien(Set<Sinhvien> dsSinhvien) {
        this.dsSinhvien = dsSinhvien;
    }
}
