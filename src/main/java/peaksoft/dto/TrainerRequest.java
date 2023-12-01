package peaksoft.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.TrainingType;
@Getter
@Setter
public class TrainerRequest {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String trainingType;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private Boolean isActive;
}
