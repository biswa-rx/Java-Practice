import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name = "alien_table")  //custom name of table
public class Alien {

    @Id
    private int aid;

//    @Column(name = "alien_name")  //custom name of column
    private String aname;

    // Ignore column in database
//    @Transient
    private String tech;
    @ManyToMany
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }


}