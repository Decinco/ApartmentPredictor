package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.User;
import co.decin.apartment_predictor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User findUserById(String id) {
        Optional<User> found = userRepository.findById(id);
        return found.orElse(null);
    }
}
