package com.example.datingagency.data;

import com.example.datingagency.services.ClientService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dating_table")
public class DatingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "first_person", nullable = false)
    private String firstPerson;

    @Column(name = "second_person_id", nullable = false)
    private Integer secondPersonId;

    @Lob
    @Column(name = "second_person", nullable = false)
    private String secondPerson;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "first_person_id", nullable = false)
    private Integer firstPersonId;


    public DatingTable(int firstPersonId, Optional<Client> byId, int secondPersonId, Optional<Client> byId1, LocalDateTime date) {
        this.firstPersonId = firstPersonId;
        this.firstPerson = byId.map(client -> client.getName() + " " + client.getSurname()).orElse("");
        this.secondPersonId = secondPersonId;
        this.secondPerson = byId1.map(client -> client.getName() + " " + client.getSurname()).orElse("");
        this.time = date;
    }
}