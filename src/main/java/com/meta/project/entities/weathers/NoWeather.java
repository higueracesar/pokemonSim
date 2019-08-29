package com.meta.project.entities.weathers;

import com.meta.project.entities.Type;
import com.meta.project.entities.Weather;

public class NoWeather extends Weather {

    public NoWeather(Type bonusType) {
        super(bonusType);

        this.displayName = "No Weather";
    }
}
