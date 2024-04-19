package fr.adgsoftware.point_hebdo_api.controller;

import fr.adgsoftware.point_hebdo_api.dto.login.LoginResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.login.LoginUserDto;
import fr.adgsoftware.point_hebdo_api.service.LoginService;
import org.springframework.web.bind.annotation.*;

import static fr.adgsoftware.point_hebdo_api.controller.ConstantUrl.LOGIN;

@RestController
@RequestMapping(LOGIN)
public class LoginController {

    private final LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public LoginResponseDto login(@RequestBody LoginUserDto userDto) {
        return loginService.login(userDto);
    }


}
