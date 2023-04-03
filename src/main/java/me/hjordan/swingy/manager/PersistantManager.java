package me.hjordan.swingy.manager;

import java.util.List;

public interface PersistantManager<T>{


    public void save(T object);
    public T find(String name);

    public List<T> findAll();
}
