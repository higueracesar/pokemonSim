package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class Normal extends Type {
    public Normal() {
        this.displayName = "Normal";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        return 1d;
    }
}
