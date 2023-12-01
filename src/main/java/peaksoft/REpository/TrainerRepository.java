package peaksoft.REpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.model.Trainee;
import peaksoft.model.Trainer;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    @Query("select t from Trainer t join User u on t.user.id=u.id where t.user.userName =:userName")
    Trainer getTrainerByUserName(@Param("userName") String userName);

    @Query("SELECT t FROM Trainer t JOIN t.user u WHERE u.userName = :username")
    Trainee findTrainerByUsername(@Param("username") String username);

    @Query("SELECT t FROM Trainer t WHERE t.user.isActive = true")
    List<Trainer> findActiveTrainer();
}
