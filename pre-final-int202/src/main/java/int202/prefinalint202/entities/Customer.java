package int202.prefinalint202.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "CUSTOMER.FIND_ALL",
                query = "select c from Customer c"),
        @NamedQuery(name = "CUSTOMER.FIND_USERNAME",
                query = "select c from Customer c where concat(trim(c.contactFirstName), ' ', trim(c.contactLastName)) = :userName")
})

public class Customer {
    @Id
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String salesRepEmployeeNumber;
    private String creditLimit;
    private String password;
}
