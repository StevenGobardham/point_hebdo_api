package fr.adgsoftware.point_hebdo_api.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.adgsoftware.point_hebdo_api.dto.AbstractDto;


public class UserDto extends AbstractDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean manager;
    private Boolean archive;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getManager() {return manager;}

    public void setManager(Boolean manager) {this.manager = manager;}

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
