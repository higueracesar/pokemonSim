package com.meta.project.entities.types;

import com.meta.project.entities.Type;

public class NullType extends Type {
    public NullType() {
        this.displayName = "No Type";
    }

    @Override
    public Double computeAttackModifier(Type type) {
        return 1d;
    }
}
