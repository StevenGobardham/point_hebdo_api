package fr.adgsoftware.point_hebdo_api.controller;

import fr.adgsoftware.point_hebdo_api.dto.PointHebdoDto;
import fr.adgsoftware.point_hebdo_api.dto.standardResponse.BooleanResponseDto;
import fr.adgsoftware.point_hebdo_api.dto.user.UserDto;
import fr.adgsoftware.point_hebdo_api.service.PointHebdoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.adgsoftware.point_hebdo_api.controller.ConstantUrl.POINTHEBDO;

@RestController
@RequestMapping(POINTHEBDO)
public class PointHebdoController {

    private final PointHebdoService pointHebdoService;
    public PointHebdoController(PointHebdoService pointHebdoService) {this.pointHebdoService = pointHebdoService;}

    @GetMapping()
    public List<PointHebdoDto> selectAll () {
        return pointHebdoService.getAllDto();
    }

    @PostMapping
    public PointHebdoDto create(@RequestBody PointHebdoDto pointHebdoDto) {
        return pointHebdoService.create(pointHebdoDto);
    }

    @GetMapping("/{id}")
    public PointHebdoDto getById(@PathVariable("id") Long id) {
        return pointHebdoService.selectDtoById(id);
    }

}
