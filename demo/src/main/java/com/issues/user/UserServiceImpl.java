package com.issues.user;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private static Map<Long, User> userRepo = new HashMap<>();
    static {
        User user = new User();
        user.setId(1l);
        user.setName("Koko");
        userRepo.put(user.getId(), user);

        User almond = new User();
        almond.setId(2l);
        almond.setName("Almond");
        userRepo.put(almond.getId(), almond);
    }
    @Override
    public void createUser(User user) {
        userRepo.put(user.getId(), user);
    }
    @Override
    public void updateUser(Long id, User user) {
        userRepo.remove(id);
        user.setId(id);
        userRepo.put(id, user);
    }
    @Override
    public void deleteUser(Long id) {
        userRepo.remove(id);

    }
    @Override
    public Collection<User> getUsers() {
        return userRepo.values();
    }
}