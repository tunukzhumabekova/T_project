package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.TrainingType;

import java.util.List;

@Setter
@Getter
public class TrainingTypeResponse {

   List<TrainingType>trainingTypes;

    public TrainingTypeResponse(List<TrainingType> trainingTypes) {
        this.trainingTypes = trainingTypes;
    }
}
