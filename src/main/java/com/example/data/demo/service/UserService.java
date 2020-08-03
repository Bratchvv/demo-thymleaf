package com.example.data.demo.service;

import com.example.data.demo.dto.UserDto;
import com.example.data.demo.model.User;
import com.example.data.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveNewUser(UserDto user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setAddress(user.getAddress());
        newUser.setCreationDate(LocalDate.now());
        return userRepository.save(newUser);
    }

    public User updateUser(Integer id, UserDto updateUser) {
        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException("Не найден пользователь в БД"));
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setAddress(updateUser.getAddress());
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}


