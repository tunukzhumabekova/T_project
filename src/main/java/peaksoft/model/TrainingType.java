package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "trainingTypes")
public class TrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tt_gen" )
    @SequenceGenerator(name = "tt_gen",sequenceName = "tt_seq",allocationSize = 1)
    private long id;
    private String name;
}
