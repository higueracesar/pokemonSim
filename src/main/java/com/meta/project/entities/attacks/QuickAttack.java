package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class QuickAttack extends Attack {

    public QuickAttack() {
        this.displayName = "Quick Attack";

        this.type = TypeFactory.createTypeStatic("Normal");
    }

    @Override
    public Double computeDamage() {
        return null;
    }
}
