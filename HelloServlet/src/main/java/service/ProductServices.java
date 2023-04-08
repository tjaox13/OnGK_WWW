package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import repository.CRUDreponsitory;

import java.util.List;

import entity.Product;

public class ProductServices  {

    private CRUDreponsitory<Product,Long> cruDreponsitory;

    public ProductServices() {
       cruDreponsitory =new CRUDreponsitory<>("Product");
         }

    public Product save(Product product) {


        return cruDreponsitory.save(product);
    }
    public List<Product> findAll() {
        return cruDreponsitory.findAll();
    }

//    public Product findById(long Productid) {
//        return gRepository.findById(Productid);
//    }

    public Product findById(Product Product, long Productid) {
        return cruDreponsitory.findByEntity(Product, Productid);
    }

    public Product updateProduct(Product Product) {
        return cruDreponsitory.update(Product);
    }

    public Product deleteProduct(Product Product, long id) {
        return cruDreponsitory.delete(Product, id);
    }

}
