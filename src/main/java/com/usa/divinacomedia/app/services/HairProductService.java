package com.usa.divinacomedia.app.services;

import com.usa.divinacomedia.app.model.HairProduct;
import com.usa.divinacomedia.app.repositories.HairProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;

    /**
     *
     * @return
     */
    public List<HairProduct> getAll(){
        return repository.getAll();
    }


    /**
     *
     * @param reference
     * @return
     */
    public Optional<HairProduct> getProductById(String reference) {
        return repository.getProductById(reference);
    }

    /**
     *
     * @param product
     * @return
     */
    public HairProduct save(HairProduct product){
        if(product.getId()==null){
            return product;
        }else{
            Optional<HairProduct> existsProduct = repository.getProductById(product.getId());
            if(existsProduct.isPresent()){ //si coloca .isEmpty debo cambiar 2x1
                return product; //cambio2xcambio1
            }else {
                return repository.save(product);//cambio1xcambio2

            }
        }
    }

    /**
     *
     * @param product
     * @return
     */
    public HairProduct update(HairProduct product){
        Optional<HairProduct> existsProduct = repository.getProductById(product.getId());
        if(existsProduct.isPresent()){
            if (product.getId()!=null){
                existsProduct.get().setId(product.getId());
            }
            if (product.getBrand()!=null){
                existsProduct.get().setBrand(product.getBrand());
            }
            if (product.getCategory()!=null){
                existsProduct.get().setCategory(product.getCategory());
            }
            if (product.getName()!=null){
                existsProduct.get().setName(product.getName());
            }
            if (product.getDescription()!=null){
                existsProduct.get().setDescription(product.getDescription());
            }
            if (product.getPrice()!=0){
                existsProduct.get().setPrice(product.getPrice());
            }
            if (product.getQuantity()!=0){
                existsProduct.get().setQuantity(product.getQuantity());
            }
            if (product.getPhotography()!=null){
                existsProduct.get().setPhotography(product.getPhotography());
            }
            return repository.save(existsProduct.get());
        }else {
            return product;
        }
    }

    /**
     * @param reference
     * @return
     */
    public boolean delete(String reference) {
        Boolean aBoolean = getProductById(reference).map(product -> {
            repository.delete(product.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
