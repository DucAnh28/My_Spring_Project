package ducanh.pro.authservice.domain;

import ducanh.pro.authservice.domain.role.AppRole;
import ducanh.pro.authservice.domain.user.AppUser;
import ducanh.pro.commonconfig.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetail implements UserDetails {
    AppUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonLocked() {
        Set<AppRole> roleEnums = user.getRoles();
        return roleEnums.stream().anyMatch(appRole -> appRole.getRole().equals(RoleEnum.ADMIN));
    }
}
