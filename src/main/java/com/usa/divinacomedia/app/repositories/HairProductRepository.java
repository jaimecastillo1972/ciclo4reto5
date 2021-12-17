package com.usa.divinacomedia.app.repositories;

import com.usa.divinacomedia.app.model.HairProduct;
import com.usa.divinacomedia.app.repositories.Crud.HairProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HairProductRepository {
    /**
     * Inyectar dependencias
     */
    @Autowired
    private HairProductCrudRepository repository;

    /**
     *
     * @return
     */
    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }

    /**
     *
     * @param reference
     * @return
     */
    public Optional<HairProduct> getProductById(String reference){
        return repository.findById(reference);
    }

    /**
     *
     * @param product
     * @return
     */
    public HairProduct save(HairProduct product){
        return repository.save(product);
    }

    /**
     *
     * @param reference
     */
    public void delete(String reference){
        repository.deleteById(reference);
    }

}
