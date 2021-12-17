package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HairProductCrudRepository extends MongoRepository<HairProduct, String> {

    @Query("{'description': ?0}")
    List<HairProduct> findByDescription(String description);

    @Query("{'price': ?0}")
    List<HairProduct> findByPrice(Double price);

}
