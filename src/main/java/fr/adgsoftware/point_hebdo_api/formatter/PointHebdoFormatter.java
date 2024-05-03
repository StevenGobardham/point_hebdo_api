package fr.adgsoftware.point_hebdo_api.formatter;


import fr.adgsoftware.point_hebdo_api.dto.PointHebdoDto;
import fr.adgsoftware.point_hebdo_api.entity.PointHebdo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PointHebdoFormatter implements IFormatter<PointHebdo, PointHebdoDto>{

    private ProjetDetailsFormatter projetDetailsFormatter;
    private UserFormatter userFormatter;

    public PointHebdoFormatter(ProjetDetailsFormatter projetDetailsFormatter, UserFormatter userFormatter) {
        this.projetDetailsFormatter = projetDetailsFormatter;
        this.userFormatter = userFormatter;
    }
    @Override
    public PointHebdoDto entityToDto(PointHebdo entity) {
        if(entity == null){
            return null;
        }
        PointHebdoDto pointHebdoDto = new PointHebdoDto();
        pointHebdoDto.setId(entity.getId());
        pointHebdoDto.setCreationTime(entity.getCreationTime());
        pointHebdoDto.setModificationTime(entity.getModificationTime());
        pointHebdoDto.setNote(entity.getNote());
        pointHebdoDto.setPriority(entity.getPriority());
        pointHebdoDto.setValidate(entity.isValidate());
        pointHebdoDto.setEventDate(entity.getEventDate());
        if(null!=entity.getPointDetails()){
            pointHebdoDto.setProjetDetails(this.projetDetailsFormatter.entityToDto(entity.getPointDetails()));
        }
        if(null!=entity.getUser()){
            pointHebdoDto.setUser(this.userFormatter.entityToDto(entity.getUser()));
        }

        return pointHebdoDto;
    }


    @Override
    public PointHebdo dtoToEntity(PointHebdoDto dto) {
        PointHebdo pointHebdo = new PointHebdo();
        pointHebdo.setId(dto.getId());
        pointHebdo.setNote(dto.getNote());
        pointHebdo.setPriority(dto.getPriority());
        pointHebdo.setValidate(dto.isValidate());
        pointHebdo.setEventDate(dto.getEventDate());
        /*if(dto.getProjetDetails() != null){
            pointHebdo.setPointDetails(this.projetDetailsFormatter.dtoToEntity(dto.getProjetDetails()));
        }*/
        if(dto.getUser() != null){
            pointHebdo.setUser(this.userFormatter.dtoToEntity(dto.getUser()));
        }
        return pointHebdo;
    }
}
