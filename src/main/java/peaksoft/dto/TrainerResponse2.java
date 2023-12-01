package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.TrainingType;

@Setter
@Getter
public class TrainerResponse2 {
    private String userName;
    private String firstName;
    private String lastName;
    private TrainingType trainingType;

    public TrainerResponse2(String userName, String firstName, String lastName, TrainingType trainingType) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainingType = trainingType;
    }
}
