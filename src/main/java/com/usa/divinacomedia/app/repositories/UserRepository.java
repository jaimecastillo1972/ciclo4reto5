package com.usa.divinacomedia.app.repositories;


import com.usa.divinacomedia.app.model.User;
import com.usa.divinacomedia.app.repositories.Crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jaime Alonso Castillo Marin
 */
@Repository
public class UserRepository {
    /**
     * Inyectar dependencias
     */
    @Autowired
    private UserCrudRepository repository;

    /**
     * Obtener registro
     * @return
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    /**
     * Obtener registro por Id
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    /**
     * Obtener registro por nombre
     * @param name
     * @return
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }

    /**
     * Obtener registro por email
     * @param email
     * @return
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }


    /**
     * Obtener registro por nombre o email
     * @param name
     * @param email
     * @return
     */
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }

    /**
     * Obtener registro por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Guardar registro
     * @param user
     * @return
     */
    public User save(User user){
        return repository.save(user);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    /**
     *
     * @param id
     * @param email
     * @param name
     * @return
     */
    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name){
        return repository.findByIdOrEmailOrName(id,email,name);
    }

}
