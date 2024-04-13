package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepository;
    
    public User create(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    public User getUserById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public boolean updateUser(int id, User user)
    {
        if (getUserById(id) == null)
        {
            return false;
        }
        try
        {
            user.setUserId(id);
            userRepository.save(user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteUser(int id)
    {
        if (getUserById(id) == null)
        {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
