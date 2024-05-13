package fr.adgsoftware.point_hebdo_api.dto;

import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;

import java.time.LocalDateTime;

public class PointHebdoLightDto extends AbstractDto {
    private boolean validate;
    private LocalDateTime eventDate;

    private UserDto user;


    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}
