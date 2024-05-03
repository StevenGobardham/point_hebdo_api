package fr.adgsoftware.point_hebdo_api.dto;

import fr.adgsoftware.point_hebdo_api.entity.PointHebdo;

public class ProjetDetailsDto extends AbstractDto {
    private String client;
    private String projet;
    private String situation;

    private Long pointHebdoId;

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

    public Long getPointHebdoId() {
        return pointHebdoId;
    }

    public void setPointHebdoId(Long pointHebdoId) {
        this.pointHebdoId = pointHebdoId;
    }
}
