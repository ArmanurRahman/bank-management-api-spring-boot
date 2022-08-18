package net.armanit.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Bank extends  BaseEntity{

    @Id
    @Column(name = "code")
    @NotBlank(message = "Bank Code can't be empty")
    @Size(max = 5, message = "Bank code can't be more than 5 character.")
    private String bankCode;

    @Column(name = "name")
    @NotBlank(message = "Bank name can't be empty")
    @Size(min = 3, message = "Bank name must be at least 3 character long")
    private String bankName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
    private Address bankAddress;
}
