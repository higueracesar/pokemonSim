package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class NullAttack extends Attack {

    public NullAttack() {
        this.displayName = "No Attack";
        this.value = "NullAttack";

        this.baseStrength = 0d;
        this.type = TypeFactory.createTypeStatic("NullType");
    }
}
