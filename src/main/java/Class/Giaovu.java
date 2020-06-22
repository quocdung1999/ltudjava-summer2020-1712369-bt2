package Class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *Class
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/19/2020 - 9:17 PM
 *@Description

 */
@Entity
@Table(name = "tkgv" , schema = "quanlysinhvien ")
public class Giaovu {
    @Id
    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @Column (name = "status")
    private boolean status;

    public Giaovu() {
    }

    public Giaovu(String username, String password, boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
