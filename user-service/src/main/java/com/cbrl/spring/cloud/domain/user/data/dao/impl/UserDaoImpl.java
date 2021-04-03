package com.cbrl.spring.cloud.domain.user.data.dao.impl;


import com.cbrl.spring.cloud.domain.user.data.dao.UserDao;
import com.cbrl.spring.cloud.domain.user.data.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> findById(Long id) {
        TypedQuery<User> query = em.createQuery(" from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst();
    }
}
