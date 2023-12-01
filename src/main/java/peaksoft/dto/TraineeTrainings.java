package peaksoft.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Trainer;
import peaksoft.model.TrainingType;

import java.time.LocalDate;
@Setter
@Getter
public class TraineeTrainings {
    private Trainer trainer;
    private String trainingName;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private int duration;

    public TraineeTrainings(Trainer trainer, String trainingName, TrainingType trainingType, LocalDate trainingDate, int duration) {
        this.trainer = trainer;
        this.trainingName = trainingName;
        this.trainingType = trainingType;
        this.trainingDate = trainingDate;
        this.duration = duration;
    }
}
