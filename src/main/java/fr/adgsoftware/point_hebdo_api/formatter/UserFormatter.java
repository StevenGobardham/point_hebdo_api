package fr.adgsoftware.point_hebdo_api.formatter;

import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;
import fr.adgsoftware.point_hebdo_api.dto.util.ConnectedUserDto;
import fr.adgsoftware.point_hebdo_api.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserFormatter implements IFormatter<User, UserDto>{

    @Override
    public UserDto entityToDto(User entity) {
        if(entity == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setManager(entity.isManager());
        userDto.setArchive(entity.isArchive());
        return userDto;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        if(dto.getManager() != null){
            user.setManager(dto.getManager());
        }
        if(dto.getArchive() != null){
            user.setArchive(dto.getArchive());
        }

        return user;
    }

    public ConnectedUserDto entityToConnectedUserDto(User entity) {
        if(entity == null){
            return null;
        }
        ConnectedUserDto dto = new ConnectedUserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setManager(entity.isManager());
        return dto;
    }
}
