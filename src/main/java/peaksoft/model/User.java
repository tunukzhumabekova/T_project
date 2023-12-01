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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen" )
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq",allocationSize = 1)
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isActive;

}
