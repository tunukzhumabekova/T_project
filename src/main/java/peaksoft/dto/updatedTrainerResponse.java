package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Trainee;
import peaksoft.model.TrainingType;

import java.util.List;

@Getter
@Setter
public class updatedTrainerResponse {

    private String userName;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private TrainingType trainingType;
    private List<Trainee> trainees;

    public updatedTrainerResponse(String userName, String firstName, String lastName, Boolean isActive, TrainingType trainingType, List<Trainee> trainees) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.trainingType = trainingType;
        this.trainees = trainees;
    }
}
