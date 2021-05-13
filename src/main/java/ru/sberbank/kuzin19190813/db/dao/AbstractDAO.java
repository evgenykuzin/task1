package ru.sberbank.kuzin19190813.db.dao;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.sberbank.kuzin19190813.db.HibernateUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public abstract class AbstractDAO<C, I extends Serializable> implements DAO<C, I> {
    private final Class<C> entityClass;

    public AbstractDAO(Class<C> entityClass) {
        this.entityClass = entityClass;
    }

    public void saveAll(@NotNull final Collection<C> objects) {
        executeVoid(session -> objects.forEach(session::save));
    }

    public void save(C object) {
        saveAll(Collections.singleton(object));
    }

    public C get(I id) {
        return executeAndGet(session -> session
                .get(entityClass, id));
    }

    public List<C> getAll() {
        return executeAndGet(session -> {
            var cq = session
                    .getCriteriaBuilder()
                    .createQuery(entityClass);
            var all = cq
                    .select(cq.from(entityClass));
            return session.createQuery(all).getResultList();
        });
    }

    public void updateAll(Collection<C> objects) {
        executeVoid(session -> objects.forEach(session::update));
    }

    public void update(C object) {
        updateAll(Collections.singleton(object));
    }

    public void deleteAll(Collection<C> objects) {
        executeVoid(session -> objects.forEach(session::delete));
    }

    public void delete(C object) {
        deleteAll(Collections.singleton(object));
    }

    public void saveOrUpdate(C object) {
        executeVoid(session -> session.saveOrUpdate(object));
    }

    public List<C> search(String tableName, String by, String value) {
        return executeAndGet(session -> {
            var query = session
                    .createNativeQuery("select * from " + tableName + " where " + String.format("%s = '%s'", by, value), entityClass);
            return query.getResultList();
        });
    }

    protected void executeVoid(Command command) {
        this.executeVoid(HibernateUtil.getSessionFactory(), command);
    }

    protected <T> T executeAndGet(Getter<T> getter) {
        return this.executeAndGet(HibernateUtil.getSessionFactory(), getter);
    }
}