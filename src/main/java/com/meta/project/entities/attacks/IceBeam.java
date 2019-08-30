package com.meta.project.entities.attacks;

import com.meta.project.entities.Attack;
import com.meta.project.factories.TypeFactory;

public class IceBeam extends Attack {

    public IceBeam() {
        this.displayName = "Ice Beam";
        this.value = "IceBeam";

        this.type = TypeFactory.createTypeStatic("Ice");
        this.baseStrength = 60d;
    }
}
