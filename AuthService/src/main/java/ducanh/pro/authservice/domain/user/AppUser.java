package ducanh.pro.authservice.domain.user;

import ducanh.pro.authservice.domain.role.AppRole;
import ducanh.pro.commonconfig.domain.BaseEntity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "au_user")
public class AppUser extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @ManyToMany
    private Set<AppRole> roles;
}
