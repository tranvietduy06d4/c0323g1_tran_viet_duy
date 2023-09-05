package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name like :searchName and type_id= :idCategory", nativeQuery = true)
    Page<Product> findProductByNameContainingAndCategoryId(Pageable pageable, @Param(value = "searchName") String searchName, @Param(value = "idCategory") int idCategory);

    @Query(value = "select * from product where name like :searchName ", nativeQuery = true)
    Page<Product> findProductByNameContaining(Pageable pageable, @Param(value = "searchName") String searchName);

    @Query(value = "select * from product where id= :productId", nativeQuery = true)
    Product findProductById(@Param(value = "productId") int productId);


    @Modifying
    @Transactional
    @Query(value = "update product set name= :name, import_date= :import_date, quantity= :quantity, type_id= :type_id where id= :id", nativeQuery = true)
    void saveProduct(@Param(value = "id") int id, @Param(value = "name") String name,
                     @Param(value = "import_date") Date importDate, @Param(value = "quantity") int quantity,
                     @Param(value = "type_id") int categoryId);

    @Modifying
    @Transactional
    @Query(value = "delete from product where id= :id", nativeQuery = true)
    void remove(@Param(value = "id") int id) ;
}
