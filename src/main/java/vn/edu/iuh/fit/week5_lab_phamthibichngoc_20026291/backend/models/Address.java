package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.enums.CountryCode;


@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    @Column(name = "street", length = 150)
    private String street;
    @Column(name = "city",length = 50)
    private String city;
    @Column(name = "country", length = 30)
    private CountryCode country;
    @Column(name = "zipcode", length = 7)
    private String zipcode;



    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

}