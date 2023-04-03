package me.hjordan.swingy.registry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRegistry<T> {

    protected List<T> registry;

    public AbstractRegistry() {
        this.registry = new ArrayList<>();

    }

    public abstract void init();

    public void add(T object) {
        if (object == null || this.registry.contains(object))
            throw new IllegalArgumentException("Object cannot be null or already in registry");

        this.registry.add(object);
    }
}
