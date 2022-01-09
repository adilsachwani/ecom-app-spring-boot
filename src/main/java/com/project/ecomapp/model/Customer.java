package com.project.ecomapp.model;

import com.project.ecomapp.constant.Gender;
import com.project.ecomapp.constant.RecordStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "contact")
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RecordStatus status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @PrePersist
    private void onPersist(){
        this.status = RecordStatus.ACTIVE;
    }

}