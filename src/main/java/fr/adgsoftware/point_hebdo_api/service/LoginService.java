package fr.adgsoftware.point_hebdo_api.service;

import fr.adgsoftware.point_hebdo_api.configuration.JwtUtil;
import fr.adgsoftware.point_hebdo_api.dao.UserRepository;
import fr.adgsoftware.point_hebdo_api.dto.login.LoginResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.login.LoginUserDto;
import fr.adgsoftware.point_hebdo_api.dto.standardResponse.BooleanResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;
import fr.adgsoftware.point_hebdo_api.entity.User;
import fr.adgsoftware.point_hebdo_api.formatter.UserFormatter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends GenericService<User, UserDto>{

    private static final Logger logger = LogManager.getLogger(LoginService.class);
    private final UserRepository userRepository;
    private final UserFormatter userFormatter;
    private final JwtUtil jwtTokenUtil;
    private final SecurityService securityService;

    public LoginService(UserRepository userRepository,
                        UserFormatter userFormatter,
                        JwtUtil jwtTokenUtil,
                        SecurityService securityService
    ) {
        super(userRepository, userFormatter);
        this.userRepository = userRepository;
        this.userFormatter = userFormatter;
        this.jwtTokenUtil = jwtTokenUtil;
        this.securityService = securityService;
    }


    @Transactional
    public LoginResponseDto login(LoginUserDto userDto) throws EntityNotFoundException {
        LoginResponseDto response = new LoginResponseDto();
        User user = userRepository.findByUsername(userDto.getIdentifier());
        if(user == null){
            response.setSuccess(false);
            response.setMessage("Utilisateur non trouvé.");
            return response;
        }

        BooleanResponseDto checkPasswordResponse = securityService.checkPassword(userDto.getPassword(), user);
        if(checkPasswordResponse.isStatus()){
            response.setSuccess(true);
            response.setMessage("Connexion réussie.");
            final String token = jwtTokenUtil.generateToken(user.getUsername());
            response.setToken(token);
            response.setUser(userFormatter.entityToDto(user));
        }
        else{
            response.setSuccess(false);
            response.setMessage(checkPasswordResponse.getMessage());
        }
        return response;
    }


}
