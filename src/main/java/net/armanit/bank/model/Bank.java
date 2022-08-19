package net.armanit.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
public class Bank extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "code")
    private String bankCode;

    @Column(name = "name")
    @NotBlank(message = "Bank name can't be empty")
    @Size(min = 3, message = "Bank name must be at least 3 character long")
    private String bankName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
    @Valid
    private Address bankAddress;

    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY,
                cascade = CascadeType.PERSIST, targetEntity = Branch.class)
    private Set<Branch> branches;
}
