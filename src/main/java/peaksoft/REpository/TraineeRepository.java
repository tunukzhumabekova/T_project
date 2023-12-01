package peaksoft.REpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.model.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee,Long> {
      @Query("select t from Trainee t join User u on t.user.id=u.id where t.user.userName = :userName")
      Trainee getTraineeByUserName(@Param("userName") String userName);

      @Query("SELECT t FROM Trainee t JOIN t.user u WHERE u.userName = :username")
      Trainee findTraineeByUsername(@Param("username") String username);
}
