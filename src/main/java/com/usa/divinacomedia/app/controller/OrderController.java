package com.usa.divinacomedia.app.controller;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService service;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return service.getOrder(id);
    }

    /**
     *
     * @param order
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }

    /**
     *
     * @param zona
     * @return
     */
    @GetMapping("zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona){
        return service.findByZone(zona);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("salesman/{id}")
    public List<Order> findBySalesManId(@PathVariable("id") Integer id){
        return service.findBySalesManId(id);
    }

    /**
     *
     * @param state
     * @param id
     * @return
     */
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return service.ordersSalesManByState(state, id);
    }

    /**
     *
     * @param dateStr
     * @param id
     * @return
     */
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return service.ordersSalesManByDate(dateStr,id);
    }
}
