package petTribble.dao;

import petTribble.model.Tribble;

import java.util.List;

public interface DaoUtil<T, I> {

    T getById(I id);
    void create(T t);
    List<T> getAll();
    void delete(I id);
    T update(T t);

}
