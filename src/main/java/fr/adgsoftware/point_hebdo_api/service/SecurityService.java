package fr.adgsoftware.point_hebdo_api.service;

import fr.adgsoftware.point_hebdo_api.dao.UserRepository;
import fr.adgsoftware.point_hebdo_api.dto.standardResponse.BooleanResponseDto;
import fr.adgsoftware.point_hebdo_api.entity.User;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private static final Logger logger = LogManager.getLogger(SecurityService.class);

    private final UserRepository userRepository;


    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public BooleanResponseDto checkPassword(String password, User user) {
        BooleanResponseDto result = new BooleanResponseDto();
        boolean passwordMatch= doPasswordsMatch(password, user.getPassword());
        if(!passwordMatch){
            result.setStatus(false);
            result.setMessage("Les identifiants de connexion sont incorrects.");
        }else{

            result.setStatus(true);
            result.setMessage("Les identifiants de connexion sont corrects.");
        }
        this.userRepository.save(user);
        return result;
    }

    public String encodePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    private boolean doPasswordsMatch(String password1, String password2){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password1, password2);
    }
    public BooleanResponseDto comparePassword(String password1 , String password2, String errorMessage){
        BooleanResponseDto result = new BooleanResponseDto();
        result.setStatus(doPasswordsMatch(password1, password2));
        if(!result.isStatus()){
            if(null==errorMessage){
                result.setMessage("Les mots de passe ne correspondent pas.");
            }
            else{
                result.setMessage(errorMessage);
            }
        }
        else{
            result.setMessage("Les mots de passe correspondent.");
        }

        return result;
    }

}
