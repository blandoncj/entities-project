package dao;

import java.util.List;
import orm.EntityManager;

public abstract class GeneralDAO<T> {
    private final EntityManager<T> entityManager;

    public GeneralDAO(Class<T> entityType, String csvFilePath) {
        this.entityManager = new EntityManager<>(entityType, csvFilePath);
    }

    public List<T> getAll() {
        return entityManager.getAll();
    }
}