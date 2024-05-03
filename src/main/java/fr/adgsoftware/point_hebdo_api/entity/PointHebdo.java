package fr.adgsoftware.point_hebdo_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="point_hebdo")
public class PointHebdo extends AbstractEntity {

    private String note;
    private String priority;
    private boolean validate;
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "pointHebdo", cascade = CascadeType.ALL)
    private List<ProjetDetails> projetDetails;

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



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProjetDetails> getPointDetails() {
        return projetDetails;
    }

    public void setPointDetails(List<ProjetDetails> pointDetails) {
        this.projetDetails = pointDetails;
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
