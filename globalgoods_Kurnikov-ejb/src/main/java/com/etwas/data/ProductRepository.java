package com.etwas.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.etwas.model.Product;

@ApplicationScoped
public class ProductRepository {

    @Inject
    private EntityManager em;

    public Product findById(/*Long*/Integer id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = cb.createQuery(Product.class);
        Root<Product> product = criteria.from(Product.class);
        criteria.select(product).orderBy(cb.asc(product.get("productName")));
        return em.createQuery(criteria).getResultList();
    }
}
