package com.issues.user;

import com.issues.user.form.UserCreationParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private UserRepository repository;
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public User createUser(User parameters) {
        User user = new User(parameters.getName(), parameters.getGithubId());
        repository.save(user);
        return user;
    }
    @Override
    public User updateUser(Long id, User user) {
        User updatingUser = repository.findById(id).orElse(null);
        updatingUser.setName(user.getName());
        updatingUser.setGithubId(user.getGithubId());
        repository.save(updatingUser);
        return updatingUser;
    }
    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);

    }
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }
    public Page<User> findUsersWithPagination(int offset, int pageSize){
        Page<User> user = repository.findAll(PageRequest.of(offset, pageSize));
        return  user;
    }
}