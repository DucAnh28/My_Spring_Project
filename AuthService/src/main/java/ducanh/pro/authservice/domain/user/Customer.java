package ducanh.pro.authservice.domain.user;

import ducanh.pro.commonconfig.domain.BaseEntity;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customer")
public class Customer extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}
