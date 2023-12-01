package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TraineeResponse {
    private String userName;
    private String password;

    public TraineeResponse(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
