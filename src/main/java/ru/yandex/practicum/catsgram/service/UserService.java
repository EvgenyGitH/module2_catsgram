package ru.yandex.practicum.catsgram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.controller.UserController;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService {
    HashMap<String, User> users = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public Collection<User> findAll() {
        log.debug("Текущее количество User: {}", users.size());
        return users.values();
    }


    public User create(User user) throws InvalidEmailException, UserAlreadyExistException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }
        users.put(user.getEmail(), user);
        log.debug("Текущее количество User: {}", user);
        return user;
    }

    public User updateUser (User user) throws InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);
        log.debug("Текущее количество User: {}", user);
        return user;
    }

/*    public User findUserByEmail(String email) {
        User answer = null;
        for (String id : users.keySet()) {
            User user = users.get(id);
            if (user.getEmail().equals(email)) {
                answer = users.get(email);
            } else {
                answer = null;
            }
        }
        return answer;
    }*/

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }

}
