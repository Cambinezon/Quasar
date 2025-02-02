package com.qteam.Quasar.api.FIs;

import net.minecraft.entity.Entity;

@FunctionalInterface
public interface EntityFilter<T> {

    T get(Entity entity);
}