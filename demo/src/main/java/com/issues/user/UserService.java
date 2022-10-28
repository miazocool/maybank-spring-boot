package com.issues.user;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public abstract void createUser(User product);
    public abstract void updateUser(Long id, User product);
    public abstract void deleteUser(Long id);
    public abstract List<User> getUsers();
}
