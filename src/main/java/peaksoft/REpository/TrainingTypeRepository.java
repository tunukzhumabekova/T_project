package peaksoft.REpository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.TrainingType;

public interface TrainingTypeRepository extends JpaRepository<TrainingType,Long> {
}
