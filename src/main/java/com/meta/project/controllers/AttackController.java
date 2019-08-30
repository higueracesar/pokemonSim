package com.meta.project.controllers;

import com.meta.project.Fight;
import com.meta.project.dtos.AttackDTO;
import com.meta.project.entities.Attack;
import com.meta.project.exceptions.InvalidTeamException;
import com.meta.project.factories.AttackFactory;
import com.meta.project.services.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("attack")
public class AttackController {
    private FightService fightService;
    private AttackFactory attackFactory;

    @Autowired
    public AttackController(AttackFactory attackFactory,
                            FightService fightService
                            ) {
        this.attackFactory = attackFactory;
        this.fightService = fightService;
    }

    @GetMapping
    public ArrayList<Attack> attackList() {
        return attackFactory.oneOfEachNonNullAttacks();
    }

    @PostMapping("{team}/{pokemonId}")
    public Fight attack(@PathVariable("team") String team,
                        @PathVariable("pokemonId") Integer pokemonId,
                        @RequestBody AttackDTO attackDTO) throws InvalidTeamException {
        return fightService.performAttack(team, pokemonId, attackDTO);
    }
}
