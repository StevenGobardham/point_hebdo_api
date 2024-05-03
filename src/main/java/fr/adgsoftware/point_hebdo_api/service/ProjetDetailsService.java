package fr.adgsoftware.point_hebdo_api.service;


import fr.adgsoftware.point_hebdo_api.dao.ProjetDetailsRepository;
import fr.adgsoftware.point_hebdo_api.dto.ProjetDetailsDto;
import fr.adgsoftware.point_hebdo_api.entity.ProjetDetails;
import fr.adgsoftware.point_hebdo_api.formatter.ProjetDetailsFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjetDetailsService extends GenericService<ProjetDetails, ProjetDetailsDto> {

    private static final Logger logger = LogManager.getLogger(ProjetDetailsService.class);

    private ProjetDetailsRepository projetDetailsRepository;
    private ProjetDetailsFormatter projetDetailsFormatter;

    public ProjetDetailsService(ProjetDetailsRepository projetDetailsRepository, ProjetDetailsFormatter projetDetailsFormatter) {
        super(projetDetailsRepository, projetDetailsFormatter);
        this.projetDetailsRepository = projetDetailsRepository;
        this.projetDetailsFormatter = projetDetailsFormatter;
    }


}
