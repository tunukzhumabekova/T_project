package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Trainer;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class TraineeProfile {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private boolean isActive;
    private List<Trainer>trainers;

    public TraineeProfile(String firstName, String lastName, LocalDate dateOfBirth, String address, boolean isActive, List<Trainer> trainers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.isActive = isActive;
        this.trainers = trainers;
    }

    public TraineeProfile() {
    }
}
