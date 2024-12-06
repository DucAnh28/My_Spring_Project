package ducanh.pro.authservice.domain.role;

import ducanh.pro.commonconfig.domain.BaseEntity;
import ducanh.pro.commonconfig.model.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity(name = "role")
@Table(name = "au_role")
@AllArgsConstructor
@NoArgsConstructor
public class AppRole extends BaseEntity implements GrantedAuthority {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Override
    public String getAuthority() {
        return role.name();
    }
}
