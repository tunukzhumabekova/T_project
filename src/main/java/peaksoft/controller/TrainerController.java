package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.Service.TrainerService;
import peaksoft.dto.*;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping("/createTrainer")
    public TrainerResponse3 save(@RequestBody TrainerRequest trainerRequest){
        return trainerService.save(trainerRequest);
    }

    @GetMapping("/login")
    public SimpleResponse login(@RequestBody TrainerRequest trainerRequest){
        return trainerService.login(trainerRequest);
    }

    @PutMapping("/changeLogin")
    public SimpleResponse changeLogin(@RequestBody TrainerRequest trainerRequest, @RequestParam String newPassword){
        return trainerService.changeLogin(trainerRequest,newPassword);
    }

    @GetMapping("/getProfile")
    public TrainerProfile getProfile(@RequestBody TrainerRequest trainerRequest){
        return trainerService.getProfile(trainerRequest);
    }

    @PutMapping("/{id}/update")
    public updatedTrainerResponse update(@PathVariable long id, @RequestBody TrainerRequest trainerRequest){
        return trainerService.update(id,trainerRequest);
    }

    @DeleteMapping("/delete")
    public SimpleResponse delete(@RequestBody TrainerRequest trainerRequest){
        return trainerService.delete(trainerRequest);
    }

    @PatchMapping("/{id}/activeDeActive")
    public SimpleResponse activeDeActive(@PathVariable long id, @RequestBody TrainerRequest trainerRequest){
        return trainerService.activateDeActivate(id, trainerRequest);
    }
}
