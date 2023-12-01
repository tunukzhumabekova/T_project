package peaksoft.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.REpository.TraineeRepository;
import peaksoft.REpository.TrainerRepository;
import peaksoft.REpository.TrainingRepository;
import peaksoft.Service.TrainingService;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.TrainerResponse2;
import peaksoft.dto.TrainingRequest;
import peaksoft.model.Trainee;
import peaksoft.model.Trainer;
import peaksoft.model.Training;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public SimpleResponse addTraining(TrainingRequest trainingRequest) {
        Trainee trainee = traineeRepository.getTraineeByUserName(trainingRequest.getTraineeUsername());
        Trainer trainer = trainerRepository.getTrainerByUserName(trainingRequest.getTrainerUsername());
        Training training = new Training();
        training.setTrainee(trainee);
        training.setTrainer(trainer);
        training.setTrainingName(trainingRequest.getTrainingName());
        training.setTrainingDate(trainingRequest.getTrainingDate());
        training.setDuration(trainingRequest.getDuration());
        training.setTrainingType(trainer.getTrainingType());
        trainee.getTrainers().add(trainer);
        trainer.getTrainees().add(trainee);
        trainingRepository.save(training);
        return new SimpleResponse(HttpStatus.OK,"Training successfully saved");
    }

    @Override
    public List<TrainerResponse2> notAssignedTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainerResponse2> notAssigned = new ArrayList<>();

        for (Trainer tr : trainers) {
            if (tr.getTrainees() == null || tr.getTrainees().isEmpty()) {
                TrainerResponse2 response = new TrainerResponse2(
                        tr.getUser().getUserName(),
                        tr.getUser().getFirstName(),
                        tr.getUser().getLastName(),
                        tr.getTrainingType()
                );
                notAssigned.add(response);
            }
        }
        return notAssigned;
    }
}
