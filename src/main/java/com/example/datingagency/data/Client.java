package com.example.datingagency.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dating_agency")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_number", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "surname", nullable = false, length = 40)
    private String surname;

    @Lob
    @Column(name = "about_yourself")
    private String aboutYourself;

    @Lob
    @Column(name = "partner_requirements")
    private String partnerRequirements;

    @Lob
    @Column(name = "sex", nullable = false)
    private String sex;

    public Client(String name, String surname, String aboutYourself, String partnerRequirements, String sex) {
        this.name = name;
        this.surname = surname;
        this.aboutYourself = aboutYourself;
        this.partnerRequirements = partnerRequirements;
        this.sex = sex;
    }
}