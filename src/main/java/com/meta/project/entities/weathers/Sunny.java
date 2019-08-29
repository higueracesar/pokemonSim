package com.meta.project.entities.weathers;

import com.meta.project.entities.Type;
import com.meta.project.entities.Weather;

public class Sunny extends Weather {
    public Sunny(Type bonusOnType) {
        super(bonusOnType);

        this.displayName = "Sunny";
    }
}
