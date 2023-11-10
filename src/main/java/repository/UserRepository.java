package repository;

import model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    int createUser(User user);
    List<User> findAll();
    Optional<User> findById(long id);
    int update(User user);

}
