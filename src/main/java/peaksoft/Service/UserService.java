package peaksoft.Service;

import peaksoft.model.User;

import java.util.List;

public interface UserService {
    String generateUsername(String firstName, String lastName);
    String generatePassword();
    boolean usernameExists(String username);
    List<User> getAll();

    void save(User user);
}
