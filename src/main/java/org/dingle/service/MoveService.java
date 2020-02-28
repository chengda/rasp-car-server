package org.dingle.service;

import com.pi4j.io.gpio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
    private Logger logger = LoggerFactory.getLogger(MoveService.class);
    private GpioController gpio;
    private GpioPinDigitalOutput pin0, pin1, pin2, pin3;

    public MoveService() {
        try {
            gpio = GpioFactory.getInstance();
            pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
            pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
            pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
            pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
            pin0.setShutdownOptions(true, PinState.LOW);
            pin1.setShutdownOptions(true, PinState.LOW);
            pin2.setShutdownOptions(true, PinState.LOW);
            pin3.setShutdownOptions(true, PinState.LOW);
            logger.debug("###gpio provision###");
        } catch (Error e) {
            logger.error(e.getMessage());
        }
    }

    public synchronized void moveForward() {
        pin0.low();
        pin1.high();
        pin2.high();
        pin3.low();
        logger.debug("pin0~4:low high high low");
    }

    public synchronized void moveBack() {
        pin0.high();
        pin1.low();
        pin2.low();
        pin3.high();
        logger.debug("pin0~4:high low low high");
    }

    public synchronized void turnLeft() {
        pin0.low();
        pin1.high();
        pin2.low();
        pin3.high();
        logger.debug("pin0~4:low high low high");
    }

    public synchronized void turnRight() {
        pin0.high();
        pin1.low();
        pin2.high();
        pin3.low();
        logger.debug("pin0~4:high low high low");
    }

    public synchronized void stop() {
        pin0.low();
        pin1.low();
        pin2.low();
        pin3.low();
        logger.debug("pin0~4:low low low low");
    }
}
