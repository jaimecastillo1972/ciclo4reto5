package com.usa.divinacomedia.app.repositories;


import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.repositories.Crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *
     * @return
     */
    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order save(Order order){
        return repository.save(order);
    }

    /**
     *
     * @param order
     */
    public void update(Order order) {
        repository.save(order);
    }

    /**
     *
     * @param order
     */
    public void delete(Order order){
        repository.delete(order);
    }

    /**
     *
     * @param zona
     * @return
     */
    public List<Order> findByZone(String zona) {
        return repository.findByZone(zona);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Order> findBySalesManId(Integer id){
        return repository.findBySalesManId(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        List<Order> order = mongoTemplate.find(query, Order.class);
        return order;
    }

    /**
     *
     * @param state
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);
        query.addCriteria(criterio);
        List<Order> order = mongoTemplate.find(query,Order.class);
        return order;
    }

    /**
     *
     * @param dateStr
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        List<Order> order = mongoTemplate.find(query,Order.class);
        return order;
    }
}
