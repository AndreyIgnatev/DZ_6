package ru.gb.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional
@RequiredArgsConstructor
public class EntityManagerProductDao {

    private final EntityManager entityManager;

    public List<Product> findAll() {
        return entityManager.createQuery("select m from Product m").getResultList();
    }

    public Product findById(Integer id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.findById", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    public void save(Product product) {
            if (product.getId() == null) {
                entityManager.persist(product);
            } else {
                entityManager.merge(product);
            }
        }
}
