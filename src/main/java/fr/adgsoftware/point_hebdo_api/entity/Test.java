package fr.adgsoftware.point_hebdo_api.entity;

import jakarta.persistence.Entity;

//TODO A supprimer à la fin
@Entity
public class Test extends AbstractEntity{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
