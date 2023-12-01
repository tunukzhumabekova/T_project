package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.Service.TraineeService;
import peaksoft.Service.TrainingTypeService;
import peaksoft.dto.*;

@RestController
@RequestMapping("/trainees")
@RequiredArgsConstructor
public class TraineeController {

    private final TraineeService traineeService;

    @PostMapping("/create")
    public TraineeResponse save(@RequestBody TraineeRequest traineeRequest){
        return traineeService.save(traineeRequest);
    }

    @GetMapping("/login")
    public SimpleResponse login(@RequestBody TraineeRequest traineeRequest){
        return traineeService.login(traineeRequest);
    }

    @PutMapping("/changeLogin")
    public SimpleResponse changeLogin(@RequestBody TraineeRequest traineeRequest, @RequestParam String newPassword){
        return traineeService.changeLogin(traineeRequest, newPassword);
    }

    @GetMapping("/getProfile")
    public TraineeProfile getProfile(@RequestBody TraineeRequest traineeRequest){
        return traineeService.getProfile(traineeRequest);
    }

    @PutMapping("/{id}/updateTrainee")
    public updatedTraineeResponse update(@PathVariable long id, @RequestBody TraineeRequest traineeRequest){
        return traineeService.update(id,traineeRequest);
    }

    @DeleteMapping("/delete")
    private SimpleResponse delete(@RequestBody TraineeRequest traineeRequest){
        return traineeService.delete(traineeRequest);
    }

    @PatchMapping("/{id}/activeDeActive")
    public SimpleResponse activeDeActive(@PathVariable long id, @RequestBody TraineeRequest traineeRequest){
        return traineeService.activeDeActive(id,traineeRequest);
    }
}