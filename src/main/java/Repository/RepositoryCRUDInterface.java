package Repository;

import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public interface RepositoryCRUDInterface<T>{
    public List<T> findAll();
    public T findById(int id);
    public List<T> findByCell(String column, String keyword);
    public void save(T object);
    public void update(T object);
    public void delete(T object);

}
abstract class Repository<T> implements RepositoryCRUDInterface<T> {

    private final Class<T> entity;

    Repository(Class<T> entity) {
        this.entity = entity;
    }
    @Override
    public T findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(entity, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<T> findAll(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            String hqlString = "From "  + entity.getSimpleName();
            return session.createQuery(hqlString).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<T> findByCell(String column, String keyword){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            String hqlString = "From "  + entity.getSimpleName() + "WHERE lower(" + column + ")" + "LIKE :" + keyword;
            Query query = session.createQuery(hqlString, entity);
            query.setParameter("keyword", "%" + keyword.toLowerCase()+ "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void save(T object) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(object);
            tx1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(T object) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(object);
            tx1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(T object) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(object);
            tx1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
