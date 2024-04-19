package fr.adgsoftware.point_hebdo_api.service.util;

import fr.adgsoftware.point_hebdo_api.dao.util.SettingRepository;
import fr.adgsoftware.point_hebdo_api.entity.util.Setting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    private static final Logger logger = LogManager.getLogger(SettingService.class);
    private final SettingRepository settingRepository;

    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    public Setting getSettingByShortName(String shortName) {
        return settingRepository.findByShortName(shortName);
    }

    public String getSettingValueByShortName(String shortName) {
        Setting setting = settingRepository.findByShortName(shortName);
        if(setting != null) {
            return setting.getValue();
        }
        return null;
    }
    public Integer getTentativesBeforeBlocking() {
        String result =  getSettingValueByShortName("tentatives_before_blocking");
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            logger.error("Error while parsing tentatives_before_blocking setting", e);
        }
        return null;
    }

}
