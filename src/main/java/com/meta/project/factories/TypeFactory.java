package com.meta.project.factories;

import com.meta.project.entities.Type;
import com.meta.project.entities.types.*;
import com.meta.project.exceptions.InvalidPokemonTypeException;
import org.springframework.stereotype.Component;

@Component
public class TypeFactory {
    public static Type createTypeStatic(String type) {
        TypeFactory typeFactory =  new TypeFactory();

        return typeFactory.createType(type);
    }

    public Type createType(String type) {
        switch (type) {
            case "Fire":
                return new Fire();
            case "Water":
                return new Water();
            case "Rock":
                return new Rock();
            case "Dragon":
                return new Dragon();
            case "Plant":
                return new Plant();
            case "Ice":
                return new Ice();
            case "Normal":
                return new Normal();
            default:
                return new NullType();
        }
    }
}
