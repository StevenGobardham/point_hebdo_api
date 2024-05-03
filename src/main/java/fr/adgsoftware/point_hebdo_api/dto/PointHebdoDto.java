package fr.adgsoftware.point_hebdo_api.dto;

import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PointHebdoDto extends AbstractDto {
    private String note;
    private String priority;
    private boolean validate;
    private LocalDateTime eventDate;


    private UserDto user;


    private List<ProjetDetailsDto> projetDetails;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }




    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProjetDetailsDto> getProjetDetails() {
        return projetDetails;
    }

    public void setProjetDetails(List<ProjetDetailsDto> projetDetails) {
        this.projetDetails = projetDetails;
    }

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
}
