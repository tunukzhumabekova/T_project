package peaksoft.dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TraineeRequest {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private Boolean isActive;
}
