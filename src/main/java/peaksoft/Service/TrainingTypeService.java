package peaksoft.Service;

import org.springframework.beans.factory.annotation.Autowired;
import peaksoft.REpository.TrainingTypeRepository;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.TrainingTypeResponse;
import peaksoft.model.TrainingType;

public interface TrainingTypeService {
    SimpleResponse save(TrainingType trainingType);
    TrainingTypeResponse getAll();
}
