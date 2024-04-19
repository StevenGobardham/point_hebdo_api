package fr.adgsoftware.point_hebdo_api.service;

import fr.adgsoftware.point_hebdo_api.dao.UserRepository;
import fr.adgsoftware.point_hebdo_api.dto.util.ConnectedUserDto;
import fr.adgsoftware.point_hebdo_api.entity.User;
import fr.adgsoftware.point_hebdo_api.formatter.UserFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ConnectedUserService {

    private static final Logger logger = LogManager.getLogger(ConnectedUserService.class);

    private final UserRepository userRepository;
    private final UserFormatter userFormatter;

    public ConnectedUserService(UserRepository userRepository, UserFormatter userFormatter) {
        this.userRepository = userRepository;
        this.userFormatter = userFormatter;
    }

    public ConnectedUserDto getCurrentUser() {
        User user = this.getCurrentUserEntity();
        return this.userFormatter.entityToConnectedUserDto(user);
    }


    private User getCurrentUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        String username=authentication.getName();
        return this.userRepository.findByUsername(username);
    }
}
