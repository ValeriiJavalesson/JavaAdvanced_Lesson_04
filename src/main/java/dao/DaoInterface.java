package dao;

import java.util.List;

public interface DaoInterface<T>{
    public void insert(T t);
    public T read(int id);
    public void update(T t);
    public void delete(int id);
    public List<T> readAll();
}
