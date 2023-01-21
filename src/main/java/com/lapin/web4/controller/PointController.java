package com.lapin.web4.controller;

import com.lapin.web4.DTO.PointDTO;
import com.lapin.web4.repository.PointRepository;
import com.lapin.web4.utility.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PointController {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private Converter converter;

    @PostMapping("/add-point")
    public void addPoint(@RequestBody PointDTO pointDTO) {
        pointRepository.save(converter.PointDTOToPoint(pointDTO));
    }
    @GetMapping("/get-points")
    public List<PointDTO> getPoints() {
        return pointRepository.findAll().stream().map(point -> converter.PointToPointDTO(point)).toList();
    }

}
