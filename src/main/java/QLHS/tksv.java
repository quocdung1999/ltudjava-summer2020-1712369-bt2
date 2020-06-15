package QLHS;

import javax.persistence.*;

/*
 *QLHS
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/15/2020 - 11:42 AM
 *@Description

 */
@Entity
@Table (name = "tksv" , schema = "quanlysinhvien")
public class tksv {
    @Id
    @Column (name = "maSv")
    private String maSv;
    @Column (name = "password")
    private String password;
    @Column (name = "status")
    private boolean status;
    public tksv()
    {
        status = false;
    }
    public tksv(String maSv, String password, boolean status) {
        this.maSv = maSv;
        this.password = password;
        this.status = status;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
