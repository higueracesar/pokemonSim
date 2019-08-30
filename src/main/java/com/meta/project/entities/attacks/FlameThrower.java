package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class FlameThrower extends Attack {

    public FlameThrower() {
        this.displayName = "Flame Thrower";
        this.value = "FlameThrower";

        this.type = TypeFactory.createTypeStatic("Fire");
        this.baseStrength = 50d;
    }
}
