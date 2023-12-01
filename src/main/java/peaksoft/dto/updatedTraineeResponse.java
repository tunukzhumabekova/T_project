package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Trainer;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class updatedTraineeResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private boolean active;
    private String address;
    private LocalDate dateOfBirth;
    private List<Trainer> trainers;

    public updatedTraineeResponse(String userName,String firstName, String lastName, boolean active, String address, LocalDate dateOfBirth, List<Trainer> trainers) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.trainers = trainers;
    }
}
