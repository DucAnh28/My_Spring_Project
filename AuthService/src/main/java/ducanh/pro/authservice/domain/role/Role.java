//package ducanh.pro.authservice;
//
//import ducanh.pro.musicservice.domain.common.BaseEntity;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity(name = "role")
//@Table(name = "tbl_role")
//public class Role extends BaseEntity implements GrantedAuthority{
//
//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    private RoleStatus roleStatus;
//
//    @Override
//    public String getAuthority() {
//        return roleStatus.name();
//    }
//}
