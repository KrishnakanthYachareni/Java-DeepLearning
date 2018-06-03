package ua.epam.spring.hometask.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Krishnakanth_Yachare
 */
@Component
public class UserDao {

    private static final Map<Long, User> users = new HashMap<>();

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public void remove(User user) {
        users.remove(user.getId(), user);
    }

    public User getById(Long id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }

    public Set<User> getAll() {
        return users.values().stream().collect(Collectors.toSet());
    }

}
