package Model;


import javax.persistence.*;
import java.sql.Timestamp;

public class User {


    private int id;
    @Column
    private Timestamp datum;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String pass;
    @Column(length = 25)
    private String rolle;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

}
