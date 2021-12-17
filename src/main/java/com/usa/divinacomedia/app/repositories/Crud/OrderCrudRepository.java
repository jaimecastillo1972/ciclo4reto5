package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Date;
import java.util.List;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    /**
     *
     * @param zone
     * @return
     */
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);

    /**
     *
     * @param id
     * @return
     */
    @Query("{'salesMan.id':?0}")
    List<Order> findBySalesManId(final Integer id);

    /**
     *
     * @param status
     * @return
     */
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    /**
     *
     * @param registerDay
     * @return
     */
    @Query("{'registerDay':?0}")
    List<Order> findByDate(Date registerDay);
}
