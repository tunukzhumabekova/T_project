package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrainerResponse3 {
    private String userName;
    private String password;

    public TrainerResponse3(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
