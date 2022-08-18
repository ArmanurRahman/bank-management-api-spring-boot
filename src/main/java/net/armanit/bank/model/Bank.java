package net.armanit.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Bank extends  BaseEntity{

    @Id
    @Column(name = "code")
    private String bankCode;

    @Column(name = "name")
    private String bankName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
    private Address bankAddress;
}
