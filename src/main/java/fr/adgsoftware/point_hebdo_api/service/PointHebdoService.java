package fr.adgsoftware.point_hebdo_api.service;

import fr.adgsoftware.point_hebdo_api.dao.PointHebdoRepository;
import fr.adgsoftware.point_hebdo_api.dto.PointHebdoDto;
import fr.adgsoftware.point_hebdo_api.entity.PointHebdo;
import fr.adgsoftware.point_hebdo_api.entity.ProjetDetails;
import fr.adgsoftware.point_hebdo_api.formatter.PointHebdoFormatter;
import fr.adgsoftware.point_hebdo_api.formatter.ProjetDetailsFormatter;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointHebdoService extends GenericService<PointHebdo, PointHebdoDto> {

    private static final Logger logger = LogManager.getLogger(PointHebdoService.class);
    private final ProjetDetailsFormatter projetDetailsFormatter;

    private PointHebdoRepository pointHebdoRepository;
    private PointHebdoFormatter pointHebdoFormatter;

    public PointHebdoService(PointHebdoRepository pointHebdoRepository, PointHebdoFormatter pointHebdoFormatter, ProjetDetailsFormatter projetDetailsFormatter) {
        super(pointHebdoRepository, pointHebdoFormatter);
        this.pointHebdoRepository = pointHebdoRepository;
        this.pointHebdoFormatter = pointHebdoFormatter;
        this.projetDetailsFormatter = projetDetailsFormatter;
    }

    @Transactional
    public PointHebdoDto create(PointHebdoDto pointHebdoDto) {
        PointHebdo pointHebdo = pointHebdoFormatter.dtoToEntity(pointHebdoDto);
        pointHebdo.setValidate (false);
        pointHebdoRepository.save(pointHebdo);
        List<ProjetDetails> projetDetailsList = projetDetailsFormatter.dtoToEntity(pointHebdoDto.getProjetDetails());
        pointHebdo.setPointDetails(projetDetailsList);
        for(ProjetDetails projetDetails : projetDetailsList) {
            projetDetails.setPointHebdo(pointHebdo);
        }
        pointHebdo = pointHebdoRepository.save(pointHebdo);
        return pointHebdoFormatter.entityToDto(pointHebdo);
    }



    public List<PointHebdo> findByUsername(String username) {
        return pointHebdoRepository.findByUserUsername(username);
    }


}
