package tn.esprit.missionsbackend.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
    ADMIN,
    EMPLOYEE,
    DIRECTOR;

    @Override
    public String getAuthority() {
        return "Role_" + name();
    }
}
