package peaksoft.dto;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingRequest {
    @Column(nullable = false)
    private String traineeUsername;
    @Column(nullable = false)
    private String trainerUsername;
    @Column(nullable = false)
    private String trainingName;
    @Column(nullable = false)
    private LocalDate trainingDate;
    @Column(nullable = false)
    private int duration;

}
