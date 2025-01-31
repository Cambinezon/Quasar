package com.lilyfena.NUBClient.api.FIs;

import net.minecraft.entity.Entity;

@FunctionalInterface
public interface EntityFilter<T> {

    T get(Entity entity);
}