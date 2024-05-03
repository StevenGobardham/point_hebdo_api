package fr.adgsoftware.point_hebdo_api.formatter;

import fr.adgsoftware.point_hebdo_api.dto.ProjetDetailsDto;
import fr.adgsoftware.point_hebdo_api.entity.ProjetDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetDetailsFormatter implements IFormatter<ProjetDetails, ProjetDetailsDto>{

    @Override
    public ProjetDetailsDto entityToDto(ProjetDetails entity) {
        if(entity == null){
            return null;
        }
        ProjetDetailsDto ProjetDetailsDto = new ProjetDetailsDto();
        ProjetDetailsDto.setId(entity.getId());
        ProjetDetailsDto.setCreationTime(entity.getCreationTime());
        ProjetDetailsDto.setModificationTime(entity.getModificationTime());
        ProjetDetailsDto.setClient(entity.getClient());
        ProjetDetailsDto.setProjet(entity.getProjet());
        ProjetDetailsDto.setSituation(entity.getSituation());

        return ProjetDetailsDto;
    }


    @Override
    public ProjetDetails dtoToEntity(ProjetDetailsDto dto) {
        ProjetDetails ProjetDetails = new ProjetDetails();
        ProjetDetails.setId(dto.getId());
        ProjetDetails.setClient(dto.getClient());
        ProjetDetails.setProjet(dto.getProjet());
        ProjetDetails.setSituation(dto.getSituation());
        return ProjetDetails;
    }

    public List<ProjetDetails> dtoToEntity(List<ProjetDetailsDto> dtos) {
        List<ProjetDetails> projetDetailsList = new ArrayList<>();
        for(ProjetDetailsDto dto : dtos){
            projetDetailsList.add(dtoToEntity(dto));
        }
        return projetDetailsList;
    }
}
