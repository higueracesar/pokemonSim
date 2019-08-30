package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class VineWhip extends Attack {

    public VineWhip() {
        this.displayName = "Vine Whip";
        this.value = "VineWhip";

        this.baseStrength = 55d;
        this.type = TypeFactory.createTypeStatic("Plant");
    }
}
