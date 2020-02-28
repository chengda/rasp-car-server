package org.dingle.controller;

import org.dingle.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/move")
public class MoveController {
    @Autowired
    private MoveService moveService;

    @PostMapping(path = "/forward")
    public void moveForward() {
        moveService.moveForward();
    }

    @PostMapping(path = "/back")
    public void moveBack() {
        moveService.moveBack();
    }

    @PostMapping(path = "/left")
    public void turnLeft() {
        moveService.turnLeft();
    }

    @PostMapping(path = "/right")
    public void turnRight() {
        moveService.turnRight();
    }

    @PostMapping(path = "/stop")
    public void stop() {
        moveService.stop();
    }
}
