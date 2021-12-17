package com.usa.divinacomedia.app.controller;

import com.usa.divinacomedia.app.model.HairProduct;
import com.usa.divinacomedia.app.services.HairProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*")//habilita acceso desde cualquier ordenador
public class HairProductController {
    @Autowired
    private HairProductService service;

    /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<HairProduct> getAll(){
        return service.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<HairProduct> getProductById(@PathVariable("id") String id){
        return service.getProductById(id);
    }

    @GetMapping("description/{description}")
    public Optional<HairProduct> getProductByDescription(@PathVariable("decription") String description){
        return service.getProductById(description);
    }

    /**
     * Metodo POST
     * @param product
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){
        return service.save(product);
    }

    /**
     * Metodo PUT
     * @param product
     * @return
     */

    @PutMapping("/update") //PUT
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){
        service.update(product);
        return product;
    }

    /**
     *
     * @param reference
     * @return
     */

    @DeleteMapping("/{reference}") //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("reference") String reference){
        return service.delete(reference);
    }
}
