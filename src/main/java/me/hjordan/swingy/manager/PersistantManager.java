package me.hjordan.swingy.manager;

public abstract class PersistantManager<T>{

    public PersistantManager() {}

    public abstract void save(T object);
    public abstract void delete(T object);
    public abstract void update(T object);
    public abstract T find(T object);
}
