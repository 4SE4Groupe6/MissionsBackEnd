package tn.esprit.missionsbackend.Entity;


import org.springframework.security.core.GrantedAuthority;

public enum theRole implements GrantedAuthority {

        ADMIN, EMPLOYEE, CompanyDIRECTOR;

        @Override
        public String getAuthority() {
            return "ROLE_" + name();
        }

}
