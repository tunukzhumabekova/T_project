package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "train_gen" )
    @SequenceGenerator(name = "train_gen",sequenceName = "train_seq",allocationSize = 1)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Trainee trainee;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Trainer trainer;
    private String trainingName;
    @ManyToOne(fetch = FetchType.EAGER)
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private int duration;

}
