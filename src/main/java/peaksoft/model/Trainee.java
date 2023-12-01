package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "trainees")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tr_gen" )
    @SequenceGenerator(name = "tr_gen",sequenceName = "tr_seq",allocationSize = 1)
    private long id;
    private LocalDate dateOfBirth;
    private String address;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private User user;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Trainer> trainers;

}
