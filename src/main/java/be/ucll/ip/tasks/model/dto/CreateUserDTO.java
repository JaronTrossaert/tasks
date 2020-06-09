package be.ucll.ip.tasks.model.dto;

import be.ucll.ip.tasks.model.UserRole;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class CreateUserDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Enumerated
    private UserRole userRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
