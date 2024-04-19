package fr.adgsoftware.point_hebdo_api.controller;

import fr.adgsoftware.point_hebdo_api.dto.TestDto;
import fr.adgsoftware.point_hebdo_api.service.TestService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static fr.adgsoftware.point_hebdo_api.controller.ConstantUrl.TEST;

//TODO A supprimer à la fin
@RestController
@RequestMapping(TEST)
public class TestController {


    private final TestService testService;
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping()
    public List<TestDto> selectAll() {
        return testService.getAllDto();
    }

    @GetMapping("/{id}")
    public TestDto selectById(@PathParam("id") Long id) {
        return testService.selectDtoById(1L);
    }

    @GetMapping("/content/{content}")
    public List<TestDto> findByContent(@PathParam("content") String content) {
        return testService.findByContent(content);
    }

}
