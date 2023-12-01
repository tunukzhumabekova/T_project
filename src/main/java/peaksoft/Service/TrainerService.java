package peaksoft.Service;
import peaksoft.dto.*;
import peaksoft.model.Trainer;

public interface TrainerService{
    TrainerResponse3 save(TrainerRequest trainerRequest);
    SimpleResponse changeLogin(TrainerRequest trainerRequest, String newPassword);
    SimpleResponse login(TrainerRequest trainerRequest);
    TrainerProfile getProfile(TrainerRequest trainerRequest);
    SimpleResponse delete(TrainerRequest trainerRequest);
    updatedTrainerResponse update(long id, TrainerRequest trainerRequest);
    SimpleResponse activateDeActivate(long id, TrainerRequest trainerRequest);
}
