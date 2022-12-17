package com.lefnds.parkingcontrol.models;

import com.lefnds.parkingcontrol.enums.RoleName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;
    @ManyToMany(mappedBy = "roles")
    private List<UserModel> users;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
