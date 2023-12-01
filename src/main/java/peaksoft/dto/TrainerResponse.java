package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.TrainingType;

@Getter
@Setter
public class TrainerResponse {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String userName;
    private String password;
    private String trainingType;

    public TrainerResponse(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public TrainerResponse() {
    }
}
