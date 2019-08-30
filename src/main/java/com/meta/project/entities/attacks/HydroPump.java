package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class HydroPump extends Attack {

    public HydroPump() {
        this.displayName = "Hydro Pump";
        this.value = "HydroPump";

        this.type = TypeFactory.createTypeStatic("Water");
        this.baseStrength = 45d;
    }
}
