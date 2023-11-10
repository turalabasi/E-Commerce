package repository.impl;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.Order;
import model.config.RepositoryConfig;
import repository.OrderRepository;

import java.util.List;

public class IOrderRepository extends RepositoryConfig implements OrderRepository {
    public void createOrder(model.entity.Order order) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(order);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> orderTypedQuery = getEntityManager().createQuery("select  o from _order o ", Order.class);

        return orderTypedQuery.getResultList();
    }

}
