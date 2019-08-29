package com.meta.project.entities.weathers;

import com.meta.project.entities.Type;
import com.meta.project.entities.Weather;

public class Freezing extends Weather {
    public Freezing(Type bonusOnType) {
        super(bonusOnType);

        this.displayName = "Freezing";
    }
}
