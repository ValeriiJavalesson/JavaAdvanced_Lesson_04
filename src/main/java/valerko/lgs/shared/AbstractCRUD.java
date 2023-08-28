package valerko.lgs.shared;

import java.util.List;
public interface AbstractCRUD<T> {
    public void create(T t);

    public T read(int id);

    public void update(T t);

    public void delete(int id);

    public List<T> readAll();
}