package fr.adgsoftware.point_hebdo_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="projet_details")
public class ProjetDetails extends AbstractEntity{

    private String client;
    private String projet;
    private String situation;

    @ManyToOne(fetch = FetchType.LAZY)
    private PointHebdo pointHebdo;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public PointHebdo getPointHebdo() {
        return pointHebdo;
    }

    public void setPointHebdo(PointHebdo pointHebdo) {
        this.pointHebdo = pointHebdo;
    }
}
