package com.issues.user;

import com.issues.user.form.UserCreationParameters;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
//    private static Map<Long, User> userRepo = new HashMap<>();
//    static {
//        User user = new User();
//        user.setId(1l);
//        user.setName("Koko");
//        userRepo.put(user.getId(), user);
//
//        User almond = new User();
//        almond.setId(2l);
//        almond.setName("Almond");
//        userRepo.put(almond.getId(), almond);
//    }
    private final UserRepository repository;
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public void createUser(User parameters) {
//
//        User user = new User(parameters.getName(), parameters.getGithubId());
//        repository.save(user);
    }
    @Override
    public void updateUser(Long id, User user) {
//        repository.remove(id);
//        user.setId(id);
//        repository.put(id, user);
    }
    @Override
    public void deleteUser(Long id) {
//        repository.remove(id);

    }
    @Override
    public List<User> getUsers() {
//        return repository.findAll();
        return null;
    }
}