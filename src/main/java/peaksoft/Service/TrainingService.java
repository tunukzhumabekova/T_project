package peaksoft.Service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.TrainerRequest;
import peaksoft.dto.TrainerResponse2;
import peaksoft.dto.TrainingRequest;

import java.util.List;

public interface TrainingService {

    SimpleResponse addTraining(TrainingRequest trainingRequest);

    List<TrainerResponse2> notAssignedTrainers();

}
