package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.Service.TrainingTypeService;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.TrainingTypeResponse;
import peaksoft.model.TrainingType;

@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class TrainingTypeController {

    private final TrainingTypeService trainingTypeService;

    @PostMapping("/createType")
    public SimpleResponse save(@RequestBody TrainingType trainingType){
        return trainingTypeService.save(trainingType);
    }

    @GetMapping
    public TrainingTypeResponse getAll(){
        return trainingTypeService.getAll();
    }
}
