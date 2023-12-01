package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_gen" )
    @SequenceGenerator(name = "trainer_gen",sequenceName = "trainer_seq",allocationSize = 1)
    private long id;
    @ManyToOne
    private TrainingType trainingType;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private User user;
    @ManyToMany(mappedBy = "trainers", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<Trainee> trainees;

}
