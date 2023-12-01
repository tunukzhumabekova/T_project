package peaksoft.Service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.REpository.TraineeRepository;
import peaksoft.REpository.TrainingRepository;
import peaksoft.Service.TraineeService;
import peaksoft.Service.TrainingService;
import peaksoft.Service.UserService;
import peaksoft.dto.*;
import peaksoft.model.Trainee;
import peaksoft.model.Training;
import peaksoft.model.User;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public TraineeResponse save(TraineeRequest traineeRequest) {
        User user = new User();
        user.setFirstName(traineeRequest.getFirstName());
        user.setLastName(traineeRequest.getLastName());
        user.setUserName(userService.generateUsername(traineeRequest.getFirstName(),traineeRequest.getLastName()));
        user.setPassword(userService.generatePassword());
        userService.save(user);
        Trainee trainee = new Trainee();
        trainee.setDateOfBirth(traineeRequest.getDateOfBirth());
        trainee.setAddress(traineeRequest.getAddress());
        trainee.setUser(user);
        traineeRepository.save(trainee);
        return new TraineeResponse(user.getUserName(),user.getPassword());
    }

    @Override
    public SimpleResponse changeLogin(TraineeRequest traineeRequest, String newPassword) {
        List<User> users = userService.getAll();
        User authenticatedUser = null;

        for (User user : users) {
            if (traineeRequest.getUserName().equals(user.getUserName()) && traineeRequest.getPassword().equals(user.getPassword())) {
                authenticatedUser = user;
                break;
            }
        }

        if (authenticatedUser != null) {
            authenticatedUser.setPassword(newPassword);
            userService.save(authenticatedUser);
            return new SimpleResponse(HttpStatus.OK, "Успешно изменен пароль");
        } else {
            return new SimpleResponse(HttpStatus.UNAUTHORIZED, "Неверный логин или пароль");
        }
    }

    @Override
    public SimpleResponse delete(TraineeRequest traineeRequest) {
        Trainee trainee = traineeRepository.getTraineeByUserName(traineeRequest.getUserName());
        Training training = trainingRepository.getTraining(traineeRequest.getUserName());
        trainingRepository.delete(training);
        traineeRepository.delete(trainee);

        return new SimpleResponse(HttpStatus.OK,"Trainee successfully deleted");
    }

    @Override
    public SimpleResponse login(TraineeRequest traineeRequest) {
        List<User>users = userService.getAll();

        boolean isTrue = false;
        for (User user:users) {
            if (traineeRequest.getUserName().equals(user.getUserName()) && traineeRequest.getPassword().equals(user.getPassword())) {
                isTrue = true;
                break;
            }
        }
            if (isTrue) {
                return new SimpleResponse(HttpStatus.OK, "Правильный логин и пароль");
            }else{
                return new SimpleResponse(HttpStatus.UNAUTHORIZED, "Неверный логин или пароль");
            }
    }

    @Override
    public TraineeProfile getProfile(TraineeRequest traineeRequest) {
        List<Trainee> trainees = traineeRepository.findAll();
        Trainee trueValue = null;
        for (Trainee trainee : trainees) {
            if (traineeRequest.getUserName().equals(trainee.getUser().getUserName())) {
                trueValue = trainee;
                break;
            }
        }
        if (trueValue != null) {
            return new TraineeProfile(trueValue.getUser().getFirstName(), trueValue.getUser().getLastName(), trueValue.getDateOfBirth(), trueValue.getAddress(), trueValue.getUser().isActive(), trueValue.getTrainers());
        }else {
            return new TraineeProfile();
        }
    }

    @Override
    public updatedTraineeResponse update(long id, TraineeRequest traineeRequest) {
        Trainee trainee = traineeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with id: " + id));

        trainee.setDateOfBirth(traineeRequest.getDateOfBirth());
        trainee.setAddress(traineeRequest.getAddress());


        User user = trainee.getUser();
        user.setFirstName(traineeRequest.getFirstName());
        user.setLastName(traineeRequest.getLastName());
        user.setActive(true);

        traineeRepository.save(trainee);


        return new updatedTraineeResponse(
                trainee.getUser().getUserName(),
                trainee.getUser().getFirstName(),
                trainee.getUser().getLastName(),
                trainee.getUser().isActive(),
                trainee.getAddress(),
                trainee.getDateOfBirth(),
                trainee.getTrainers());
    }
    @Override
    public SimpleResponse activeDeActive(long id, TraineeRequest traineeRequest) {
        Trainee trainee = traineeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with id: " + id));
        trainee.getUser().setActive(traineeRequest.getIsActive());
        traineeRepository.save(trainee);
        return new SimpleResponse(HttpStatus.OK, "200 ok");
    }
}
