package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.Service.TrainingService;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.TrainerRequest;
import peaksoft.dto.TrainerResponse2;
import peaksoft.dto.TrainingRequest;

import java.util.List;

@RestController
@RequestMapping("/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @PostMapping("/saveTraining")
    public SimpleResponse addTraining(@RequestBody TrainingRequest trainingRequest){
        return trainingService.addTraining(trainingRequest);
    }

    @GetMapping("/notAssignedTrainers")
    public List<TrainerResponse2>getTrainers(){
        return trainingService.notAssignedTrainers();
    }
}
