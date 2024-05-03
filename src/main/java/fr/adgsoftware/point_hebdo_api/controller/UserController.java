package fr.adgsoftware.point_hebdo_api.controller;

import fr.adgsoftware.point_hebdo_api.dto.standardResponse.BooleanResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;
import fr.adgsoftware.point_hebdo_api.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.adgsoftware.point_hebdo_api.controller.ConstantUrl.USER;

@RestController
@RequestMapping(USER)
public class UserController {


    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/active")
    public List<UserDto> selectAllActive () {
        return userService.getAllActiveDto();
    }

    @GetMapping()
    public List<UserDto> selectAll () {
        return userService.getAllDto();
    }

    @PostMapping()
    public BooleanResponseDto createUser(@RequestBody UserDto userDto) {
        return userService.registerNewUser(userDto);
    }
    @PutMapping("/archive/{id}")
    public UserDto archiveUser(@PathVariable("id") Long id) {
        return userService.archive(id);
    }
    @PutMapping()
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

}
