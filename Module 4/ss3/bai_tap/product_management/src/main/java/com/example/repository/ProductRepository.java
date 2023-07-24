package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> displayAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }


    @Override
    public Product getById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    @Modifying
    public void edit(Product product) {
        Product product1 = getById(product.getId());
        product1.setName(product.getName());
        entityManager.merge(product1);
    }

    @Transactional
    @Override
    public void remove(int id) {
        Product product2 = getById(id);
        entityManager.remove(product2);
    }
}
