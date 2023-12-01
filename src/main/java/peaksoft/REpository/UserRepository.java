package peaksoft.REpository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
