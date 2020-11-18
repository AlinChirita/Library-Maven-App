package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id);

    List<T> getAll();

    boolean create(T t);

    boolean update(T old, T newObj);

    boolean delete(T t);
}

