package peaksoft.Service;


import peaksoft.dto.*;
import peaksoft.model.Trainee;

import java.util.List;

public interface TraineeService {

    TraineeResponse save(TraineeRequest traineeRequest);
    SimpleResponse changeLogin(TraineeRequest traineeRequest, String newPassword);
    SimpleResponse delete(TraineeRequest traineeRequest);
    SimpleResponse login(TraineeRequest traineeRequest);
    TraineeProfile getProfile(TraineeRequest traineeRequest);
    updatedTraineeResponse update(long id, TraineeRequest traineeRequest);
    SimpleResponse activeDeActive(long id, TraineeRequest traineeRequest);
}
