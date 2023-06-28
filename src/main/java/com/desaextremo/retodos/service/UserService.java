package com.desaextremo.retodos.service;

import com.desaextremo.retodos.entity.User;
import com.desaextremo.retodos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;

    public List<User> getAll(){
        return repositorio.findAll();
    }

    public User getUser(Integer id){
        Optional<User> optional = repositorio.findById(id);

        if (optional.isPresent()) return optional.get();
        else return new User();
    }

    public boolean existEmail(String email){
        Optional<User> optional = repositorio.findByEmail(email);

        if (optional.isPresent())  return true;
        else return false;
    }

    public User autenticateUser(String email, String password){
        Optional<User> optional = repositorio.findByEmailAndPassword(email,password);

        if (optional.isPresent()) {
            User user = optional.get();
            return user;
        } else{
            User user =  new User();
            //user.setEmail(email);
            //user.setPassword(password);
            //user.setName("NO DEFINIDO");
            return user;
        }
    }

    public User registrar(User user){
        User userError;

        //en la informacion recibida hay un id
        if (user.getId()!=null){
            //si el id ya existe
            Optional<User> optional = repositorio.findById(user.getId());

            if (optional.isPresent()){
                userError = new User();
                userError.setName("ID " + user.getId() + " YA EXISTE");
                return userError;
            }else{
                //validar si el correo electronico recibido ya esta asociado a otro usuario en la bd
                if (existEmail(user.getEmail())){
                    userError = new User();
                    userError.setName("CORREO " + user.getEmail() + " YA EXISTE");
                    return userError;
                }else{
                    return repositorio.save(user);
                }
            }
        }else{
            userError = new User();
            userError.setName("FALTA EL ID");
            return userError;
        }
    }

    public User actualizar(User user){
        User userError;
        User userDb;

        //tiene un id
        if (user.getId()!=null){
            //valido si existe un usuario en bd asociado al id recibido
            Optional<User> optional =  repositorio.findById(user.getId());

            if (optional.isPresent()){
                userDb = optional.get();
                if ((user.getIdentification() != null) && (!user.getIdentification().equals(""))) {
                    if (!userDb.getIdentification().equals(user.getIdentification()))  userDb.setIdentification(user.getIdentification());
                }
                if ((user.getName() != null) && (!user.getName().equals(""))) {
                    if (!userDb.getName().equals(user.getName()))  userDb.setName(user.getName());
                }
                if ((user.getAddress() != null) && (!user.getAddress().equals(""))) {
                    if (!userDb.getAddress().equals(user.getAddress())) userDb.setAddress(user.getAddress());
                }
                if ((user.getCellPhone() != null) && (!user.getCellPhone().equals(""))) {
                    if (!userDb.getCellPhone().equals(user.getCellPhone()))userDb.setCellPhone(user.getCellPhone());
                }
                if ((user.getEmail() != null) && (!user.getEmail().equals(""))) {
                    if (!userDb.getEmail().equals(user.getEmail())) userDb.setEmail(user.getEmail());
                }
                if ((user.getPassword() != null) && (!user.getPassword().equals(""))) {
                    if (!userDb.getPassword().equals(user.getPassword())) userDb.setPassword(user.getPassword());
                }
                if ((user.getZone() != null) && (!user.getPassword().equals(""))) {
                    if (!userDb.getZone().equals(user.getZone())) userDb.setZone(user.getZone());
                }

                return repositorio.save(userDb);
            }else{
                userError = new User();
                userError.setName("No existe un usuario con el ID " + user.getId());
                return userError;
            }
        }else{
            userError = new User();
            userError.setName("No se envio un valor para el ID");
            return userError;
        }
    }

    public boolean delete(int id) {
        User userDelete;
        Optional<User> optional = repositorio.findById(id);

        if (optional.isPresent()){
            userDelete = optional.get();
            repositorio.delete(userDelete);
            return true;
        }else{
            return false;
        }
    }
}
