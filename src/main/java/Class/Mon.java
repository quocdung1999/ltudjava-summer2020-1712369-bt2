package Class;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 *Class
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/16/2020 - 11:28 PM
 *@Description

 */
@Entity
@Table(name = "mon" , schema = "quanlysinhvien" ,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"maMon", "maLopHoc"})})
public class Mon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "IDMon")
    private int IDMon;

    @Column (name = "maMon")
    private String maMon;

    @ManyToOne
    @JoinColumn (name = "maLopHoc")
    private Lop lopHoc;

    @OneToMany (mappedBy = "sv")
    private Set<Thamgia> thamgia;

    @Column (name = "tenMon")
    private String tenMon;

    @Column (name ="phong")
    private String phong;

    public Mon() {
        thamgia = new HashSet<Thamgia>();
    }

    public Mon( String maMon, Lop lopHoc,Set<Thamgia> thamgia, String tenMon, String phong) {
        this.maMon = maMon;
        this.lopHoc = lopHoc;
        this.thamgia = thamgia;
        this.tenMon = tenMon;
        this.phong = phong;
    }

    public int getIDMon() {
        return IDMon;
    }

    public void setIDMon(int IDMon) {
        this.IDMon = IDMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public Lop getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(Lop lopHoc) {
        this.lopHoc = lopHoc;
    }

    public Set<Thamgia> getThamgia() {
        return thamgia;
    }

    public void setThamgia(Set<Thamgia> thamgia) {
        this.thamgia = thamgia;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }
}
