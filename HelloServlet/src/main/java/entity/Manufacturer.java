package entity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Manufacturer")
@NamedQueries({
        @NamedQuery(name="Manufacturer.findAll",query="from Manufacturer")
})

public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manId;
    @Column(nullable = false,unique = true,length = 150)
    private String manName;
    @Column(nullable = false,unique = true,length = 150)
    private String manContactName;
    @Column(nullable = false,unique = true,length = 50)
    private String manContactEmail;
    @Column(nullable = false,unique = true,length = 10)
    private String manContactPhone;
    @Column(nullable = false,unique = true)
    private String manWebsite;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManContactName() {
        return manContactName;
    }

    public void setManContactName(String manContactName) {
        this.manContactName = manContactName;
    }

    public String getManContactEmail() {
        return manContactEmail;
    }

    public void setManContactEmail(String manContactEmail) {
        this.manContactEmail = manContactEmail;
    }

    public String getManContactPhone() {
        return manContactPhone;
    }

    public void setManContactPhone(String manContactPhone) {
        this.manContactPhone = manContactPhone;
    }

    public String getManWebsite() {
        return manWebsite;
    }

    public void setManWebsite(String manWebsite) {
        this.manWebsite = manWebsite;
    }

    public Manufacturer(int manId, String manName, String manContactName, String manContactEmail, String manContactPhone, String manWebsite) {
        this.manId = manId;
        this.manName = manName;
        this.manContactName = manContactName;
        this.manContactEmail = manContactEmail;
        this.manContactPhone = manContactPhone;
        this.manWebsite = manWebsite;
    }

    public Manufacturer(int manId, String manName, String manContactName, String manContactEmail, String manContactPhone, String manWebsite, List<Product> products) {
        this.manId = manId;
        this.manName = manName;
        this.manContactName = manContactName;
        this.manContactEmail = manContactEmail;
        this.manContactPhone = manContactPhone;
        this.manWebsite = manWebsite;
        this.products = products;
    }

    public Manufacturer(String manName, String manContactName, String manContactEmail, String manContactPhone, String manWebsite) {
        this.manName = manName;
        this.manContactName = manContactName;
        this.manContactEmail = manContactEmail;
        this.manContactPhone = manContactPhone;
        this.manWebsite = manWebsite;
    }

    public Manufacturer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return manId == that.manId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manId);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manId=" + manId +
                ", manName='" + manName + '\'' +
                ", manContactName='" + manContactName + '\'' +
                ", manContactEmail='" + manContactEmail + '\'' +
                ", manContactPhone='" + manContactPhone + '\'' +
                ", manWebsite='" + manWebsite + '\'' +
                '}';
    }
}
