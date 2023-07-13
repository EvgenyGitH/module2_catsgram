package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/users")

public class UserController {
    HashMap <String, User> users = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public Collection<User> findAll () {
        log.debug("Текущее количество User: {}", users.size());
        return users.values();
    }

    @PostMapping
    public User create (@RequestBody User user){
        try {
            if(user.getEmail().equals(null) || user.getEmail().isEmpty()){
                throw new InvalidEmailException("В переданных данных отсутствует адрес электронной почты");
            }else{
                if (users.isEmpty()){
                    users.put(user.getEmail(),user);

                }else {
                    for(String userId : users.keySet()){
                        if(userId.equals(user.getEmail())){
                            throw new UserAlreadyExistException("Пользователь с указанным адресом электронной почты уже был добавлен ранее");
                        }else {
                            users.put(user.getEmail(),user);
                        }
                    }
                }
            }
        }catch (UserAlreadyExistException exception){
            System.out.println(exception.getMessage());
        }
        catch (InvalidEmailException exception){
            System.out.println(exception.getMessage());
        }
        log.debug("Текущее количество User: {}", user);
        return user;
    }

    @PutMapping
    public User createUpdate (@RequestBody User user){
        try {
            if(user.getEmail().equals(null) || user.getEmail().isEmpty()){
                throw new InvalidEmailException("В переданных данных отсутствует адрес электронной почты");
            }else{
              /*  if (users.isEmpty()){
                    users.put(user.getEmail(),user);
                }else {
                   /* for(String userId : users.keySet()){
                        if(userId.equals(user.getEmail())){
                            throw new UserAlreadyExistException("Пользователь с указанным адресом электронной почты уже был добавлен ранее");
                        }else {
                            users.put(user.getEmail(),user);
                        }
                    }*/

                    users.put(user.getEmail(),user);
                }




       /* }catch (UserAlreadyExistException exception){
            System.out.println(exception.getMessage());*/
        }
        catch (InvalidEmailException exception){
            System.out.println(exception.getMessage());
        }
        log.debug("Текущее количество User: {}", user);
        return user;
    }


}





// Вариант practicum:
/*
package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();

    @GetMapping
    public Collection<User> findAll() {
        return users.values();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        if(user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        if(users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User put(@RequestBody User user) {
        if(user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);

        return user;
    }
}
 */