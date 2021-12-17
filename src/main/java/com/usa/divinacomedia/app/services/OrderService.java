package com.usa.divinacomedia.app.services;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    /**
     * Inyeccion de codigo
     */
    @Autowired
    private OrderRepository repository;


    /**
     *
     * @return
     */
    public List<Order> getAll(){
        return repository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getOrder(Integer id){
        return repository.getOrder(id);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            Optional<Order> existsOrder = repository.getOrder(order.getId());
            if (existsOrder.isPresent()) { //si coloca .isEmpty debo cambiar 2x1
                return order; //cambio2xcambio1
            } else {
                return repository.save(order);//cambio1xcambio2

            }
        }
    }

    /**
     *
     * @param order
     * @return
     */
    public Order update(Order order){
        Optional<Order> existsOrder=repository.getOrder(order.getId());
        if (existsOrder.isPresent()){
            if (order.getId()!=null){
                existsOrder.get().setId(order.getId());
            }
            if (order.getRegisterDay()!=null){
                existsOrder.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus()!=null){
                existsOrder.get().setStatus(order.getStatus());
            }
            if (order.getSalesMan()!=null){
                existsOrder.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts()!=null){
                existsOrder.get().setProducts(order.getProducts());
            }
            if (order.getQuantities()!=null){
                existsOrder.get().setQuantities(order.getQuantities());
            }
            return repository.save(existsOrder.get());
    }else {
            return order;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id){
        Boolean aBoolean=repository.getOrder(id).map(order->{
            repository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     *
     * @param zona
     * @return
     */
    public List<Order> findByZone(String zona){
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
    public List<Order> ordersSalesManByID(Integer id){
        return repository.ordersSalesManByID(id);
    }

    /**
     *
     * @param state
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByState(String state, Integer id){
        return repository.ordersSalesManByState(state, id);
    }

    /**
     *
     * @param dateStr
     * @param id
     * @return
     */
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return repository.ordersSalesManByDate(dateStr,id);
    }


}
