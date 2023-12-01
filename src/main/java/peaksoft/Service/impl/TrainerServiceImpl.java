package peaksoft.Service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.REpository.TrainerRepository;
import peaksoft.REpository.TrainingRepository;
import peaksoft.REpository.TrainingTypeRepository;
import peaksoft.Service.TrainerService;
import peaksoft.Service.UserService;
import peaksoft.dto.*;
import peaksoft.model.Trainer;
import peaksoft.model.TrainingType;
import peaksoft.model.User;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainingTypeRepository trainingTypeRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public TrainerResponse3 save(TrainerRequest trainerRequest) {
        User user = new User();
        user.setFirstName(trainerRequest.getFirstName());
        user.setLastName(trainerRequest.getLastName());
        user.setUserName(userService.generateUsername(trainerRequest.getFirstName(), trainerRequest.getLastName()));
        user.setPassword(userService.generatePassword());
        user.setActive(false);
        userService.save(user);
        Trainer trainer = new Trainer();
        TrainingType trainingType = new TrainingType();
        trainingType.setName(trainerRequest.getTrainingType());
        trainingTypeRepository.save(trainingType);
        trainer.setTrainingType(trainingType);
        trainer.setUser(user);
        trainerRepository.save(trainer);
        return new TrainerResponse3(trainer.getUser().getUserName(), trainer.getUser().getPassword());
    }

    @Override
    public SimpleResponse changeLogin(TrainerRequest trainerRequest, String newPassword) {
        List<User> users = userService.getAll();
        User authenticatedUser = null;

        for (User user : users) {
            if (trainerRequest.getUserName().equals(user.getUserName()) && trainerRequest.getPassword().equals(user.getPassword())) {
                authenticatedUser = user;
                break;
            }
        }

        if (authenticatedUser != null) {
            authenticatedUser.setPassword(newPassword);
            userService.save(authenticatedUser);
            return new SimpleResponse(HttpStatus.OK, "successfully updated");
        } else {
            return new SimpleResponse(HttpStatus.UNAUTHORIZED, "incorrect login or password");
        }
    }

    @Override
    public SimpleResponse login(TrainerRequest trainerRequest) {
        List<User> users = userService.getAll();
        boolean isAuthenticated = false;

        for (User user : users) {
            if (trainerRequest.getUserName().equals(user.getUserName()) && trainerRequest.getPassword().equals(user.getPassword())) {
                isAuthenticated = true;
                break;
            }
        }

        if (isAuthenticated) {
            return new SimpleResponse(HttpStatus.OK, "successfully");
        } else {
            return new SimpleResponse(HttpStatus.UNAUTHORIZED, "incorrct login or password");
        }
    }

    @Override
    public TrainerProfile getProfile(TrainerRequest trainerRequest) {
        List<Trainer> trainers = trainerRepository.findAll();
        Trainer trueValue = null;
        for (Trainer trainer : trainers) {
            if (trainerRequest.getUserName().equals(trainer.getUser().getUserName())) {
                trueValue = trainer;
                break;
            }
        }
        if (trueValue != null) {
            return new TrainerProfile(trueValue.getUser().getFirstName(), trueValue.getUser().getLastName(), trueValue.getUser().isActive(), trueValue.getTrainingType(), trueValue.getTrainees());
        }else {
            return new TrainerProfile();
        }
    }

    @Override
    public SimpleResponse delete(TrainerRequest trainerRequest) {
        Trainer trainer = trainerRepository.getTrainerByUserName(trainerRequest.getUserName());
//        trainingRepository.
        trainerRepository.delete(trainer);
        return new SimpleResponse(HttpStatus.OK,"Trainer successfully deleted");
    }

    @Override
    public updatedTrainerResponse update(long id, TrainerRequest trainerRequest) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        User user = trainer.getUser();
        user.setUserName(trainerRequest.getUserName());
        user.setFirstName(trainerRequest.getFirstName());
        user.setLastName(trainerRequest.getLastName());
        user.setActive(user.isActive());
        trainerRepository.save(trainer);

        return new updatedTrainerResponse(
                        trainer.getUser().getUserName(),
                        trainer.getUser().getFirstName(),
                        trainer.getUser().getLastName(),
                        trainer.getUser().isActive(),
                trainer.getTrainingType(),
                trainer.getTrainees());
    }

    @Override
    public SimpleResponse activateDeActivate(long id, TrainerRequest trainerRequest) {
        Trainer trainee = trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with id: " + id));

        trainee.getUser().setActive(trainerRequest.getIsActive());
        trainerRepository.save(trainee);
        return new SimpleResponse(HttpStatus.OK, "200 ok");
    }
}