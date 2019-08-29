package com.meta.project.controllers;

import com.meta.project.entities.Attack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AttackController {


    @GetMapping(path = "attacks")
    public ArrayList<Attack> attackList() {
        return new ArrayList<>();
    }
}
