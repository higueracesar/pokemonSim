package com.meta.project.entities.weathers;

import com.meta.project.entities.Type;
import com.meta.project.entities.Weather;

public class Rainy extends Weather {
    public Rainy(Type bonusOnType) {
        super(bonusOnType);

        this.displayName = "Rainy";
    }
}
