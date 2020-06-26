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
        dsSinhvien = new HashSet<Sinhvien>();
    }

    public Lop(String maLop) {
        this.maLop = maLop;
    }

    public Lop(String maLop, Set<Mon> dsMon, Set<Sinhvien> dsSinhvien) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsMon == null) ? 0 : dsMon.hashCode());
		result = prime * result + ((dsSinhvien == null) ? 0 : dsSinhvien.hashCode());
		result = prime * result + ((maLop == null) ? 0 : maLop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lop other = (Lop) obj;
		if (dsMon == null) {
			if (other.dsMon != null)
				return false;
		} else if (!dsMon.equals(other.dsMon))
			return false;
		if (dsSinhvien == null) {
			if (other.dsSinhvien != null)
				return false;
		} else if (!dsSinhvien.equals(other.dsSinhvien))
			return false;
		if (maLop == null) {
			if (other.maLop != null)
				return false;
		} else if (!maLop.equals(other.maLop))
			return false;
		return true;
	}
    
}
