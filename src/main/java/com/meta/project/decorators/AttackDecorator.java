package com.meta.project.decorators;

import com.meta.project.entities.Attack;

public abstract class AttackDecorator extends Attack {

    @Override
    public abstract Double computeDamage();
}
