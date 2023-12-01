package peaksoft.REpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.model.Training;

public interface TrainingRepository extends JpaRepository<Training,Long> {

    @Query("select t from Training t join Trainee tr on t.trainee.id=tr.id join User u on t.trainee.user.id=u.id where u.userName =:userName")
    Training getTraining(@Param("userName") String userName);
}
