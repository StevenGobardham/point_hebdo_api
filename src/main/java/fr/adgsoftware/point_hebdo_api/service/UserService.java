package fr.adgsoftware.point_hebdo_api.service;

import fr.adgsoftware.point_hebdo_api.dao.UserRepository;
import fr.adgsoftware.point_hebdo_api.dto.standardResponse.BooleanResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;
import fr.adgsoftware.point_hebdo_api.entity.User;
import fr.adgsoftware.point_hebdo_api.formatter.UserFormatter;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericService<User, UserDto>{

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private SecurityService securityService;

    private UserRepository userRepository;
    private UserFormatter userFormatter;

    public UserService(UserRepository userRepository, SecurityService securityService,
                       UserFormatter userFormatter) {
        super(userRepository, userFormatter);
        this.userRepository = userRepository;
        this.userFormatter = userFormatter;
        this.securityService = securityService;

    }

    public BooleanResponseDto registerNewUser(UserDto userDto){
        BooleanResponseDto responseDto = new BooleanResponseDto();
        try {
            userDto.setPassword(securityService.encodePassword(userDto.getPassword()));
            this.create(userDto);
            responseDto.setMessage("L'utilisateur a bien été créé.");
            responseDto.setStatus(true);
        }
        catch (Exception e){
            responseDto.setStatus(false);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    @Transactional
    public UserDto archive(Long id){
       User user = this.selectById(id);
       user.setArchive(true);
       user = userRepository.save(user);
       return  userFormatter.entityToDto(user);
    }

    public List<UserDto> getAllActiveDto() {
        List<User> activeUsers = userRepository.findByArchiveFalse();
        return userFormatter.entityToDto(activeUsers);
    }

    @Transactional
    public UserDto update(UserDto userDto) {
        if(null==userDto.getId()){
            throw new IllegalArgumentException("User not found");
        }
        User user = this.selectById(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        if(null!=userDto.getPassword()){
            String password = userDto.getPassword();
            user.setPassword(this.securityService.encodePassword(password));
        }
        user = userRepository.save(user);
        return userFormatter.entityToDto(user);
    }

}
