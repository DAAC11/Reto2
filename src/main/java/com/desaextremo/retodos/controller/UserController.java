package com.desaextremo.retodos.controller;

import com.desaextremo.retodos.entity.User;
import com.desaextremo.retodos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email){
        return service.existEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email,@PathVariable("password") String password){
        return service.autenticateUser(email,password);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return service.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return service.registrar(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User actualizar(@RequestBody User user){
        return service.actualizar(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
