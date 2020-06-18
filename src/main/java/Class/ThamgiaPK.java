package Class;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/*
 *Class
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/18/2020 - 9:29 PM
 *@Description

 */
@Embeddable
public class ThamgiaPK implements Serializable {
    @Column (name = "maSV")
    private String maSV;
    @Column (name = "IDMon")
    private int IDMon;

    public ThamgiaPK() {
    }

    public ThamgiaPK(String maSV, int IDMon) {
        this.maSV = maSV;
        this.IDMon = IDMon;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getIDMon() {
        return IDMon;
    }

    public void setIDMon(int IDMon) {
        this.IDMon = IDMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThamgiaPK thamgiaPK = (ThamgiaPK) o;
        return getIDMon() == thamgiaPK.getIDMon() &&
                getMaSV().equals(thamgiaPK.getMaSV());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaSV(), getIDMon());
    }
}
