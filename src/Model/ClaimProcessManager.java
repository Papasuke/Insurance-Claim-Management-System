package Model;

import java.util.ArrayList;

public interface ClaimProcessManager<T> {
    void add(T item);
    void update(T item);
    void delete(String id);
    T getOne(String id);
    ArrayList<T> getAll();
}
