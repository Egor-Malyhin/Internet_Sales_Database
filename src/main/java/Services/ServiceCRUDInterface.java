package Services;

import Repository.RepositoryCRUDInterface;

import java.util.List;

public interface ServiceCRUDInterface<T> {
    public List<T> findAll();
    public T findById(int id);
    public void save(T object);
    public void update(T object);
    public void delete(T object);
}
abstract class Service<T> implements ServiceCRUDInterface<T>{

    protected final RepositoryCRUDInterface<T> repository;

    Service(RepositoryCRUDInterface<T> repository){
        this.repository = repository;
    }

    public List<T> findAll(){
        return repository.findAll();
    }
    public T findById(int id){
        return repository.findById(id);
    }
    public void save(T object){
        repository.save(object);
    }
    public void update(T object){
        repository.update(object);
    }
    public void delete(T object){
        repository.delete(object);
    }
}
