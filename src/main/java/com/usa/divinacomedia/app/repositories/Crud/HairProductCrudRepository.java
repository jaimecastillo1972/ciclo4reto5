package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HairProductCrudRepository extends MongoRepository<HairProduct, String> {

}
