package com.issues.user;

import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public abstract User createUser(User product);
    public abstract User updateUser(Long id, User product);
    public abstract void deleteUser(Long id);
    public abstract List<User> getUsers();
    public abstract Page<User> findUsersWithPagination(int offset, int pageSize);
}
