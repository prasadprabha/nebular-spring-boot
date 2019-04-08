package com.springboot.nebular.repository.data;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements CustomRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void refresh(T t) {
        this.entityManager.refresh(t);
    }
}
