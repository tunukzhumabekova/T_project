package peaksoft.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Data
@Getter
@Setter
public class SimpleResponse {

    private HttpStatus httpStatus;
    private String message;

    public SimpleResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
