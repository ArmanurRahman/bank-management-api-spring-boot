package net.armanit.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private int addressId;

    @NotBlank(message = "Address1 can't be empty.")
    private String address1;

    private String address2;

    @NotBlank(message = "State can't be empty.")
    private String state;

    @NotBlank(message = "City can't be empty.")
    private String city;

    @NotBlank(message = "zipCode can't be empty.")
    @Pattern(regexp = "(^$|[0-9]{5})", message = "Invalid zipcode")
    private String zipCode;
}
