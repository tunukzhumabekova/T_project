package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Trainee;
import peaksoft.model.TrainingType;

import java.util.List;

@Getter
@Setter
public class TrainerProfile {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private TrainingType trainingType;
    private List<Trainee>trainees;

    public TrainerProfile(String firstName, String lastName, boolean isActive, TrainingType trainingType, List<Trainee> trainees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.trainingType = trainingType;
        this.trainees = trainees;
    }

    public TrainerProfile() {
    }
}
