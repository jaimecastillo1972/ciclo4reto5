package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    /**
     * Encontrar por nombre
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);

    /**
     * Encontrar por nombre o email
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     * Encontrar por email
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);


    /**
     * Encontrar por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);

    /**
     *
     * @param id
     * @param email
     * @param name
     * @return
     */
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);

}
