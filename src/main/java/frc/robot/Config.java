// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** 
 * Use to define Port and ID assignments for robot configuration. 
 * Enums are provided for CAN bus devices, and DIO ports.
 */
public class Config {
    /**
     * Enum for CAN bus devices ONLY, in the format: {@code NAME(bus_id)}
     * <p>Use {@code Config.CAN.<NAME>.getID()} method to return the bus ID value.
     * <p>Maximum effective range for all CAN IDs is 0-62 (6 bits).
     * 
     * @param NAME      String, ALL CAPS (it's a constant!)
     * @param bus_id    int 
     */
    public enum CAN {
        ROBORIO(0),
        PDH(1),
        PCM(2),
        CANDLE(3),
        // Reserved for Swerve, but loaded via JSON files in /deploy.
        PIGEON2(20), // Should be 15, couldn't change for some reason
        SWERVE_FR_DRIVE(17),
        SWERVE_FR_TURN(18),
        SWERVE_FR_ENCODER(19),
        SWERVE_FL_DRIVE(10),
        SWERVE_FL_TURN(11),
        SWERVE_FL_ENCODER(12),
        SWERVE_BL_DRIVE(25), // had to change this from 20 to 25 because chaning Pigeon CAN ID wasn't working
        SWERVE_BL_TURN(21),
        SWERVE_BL_ENCODER(22),
        SWERVE_BR_DRIVE(27),
        SWERVE_BR_TURN(28),
        SWERVE_BR_ENCODER(29),
        // Other items
        INTAKE_MOTOR(30),
        SHOOTER_MOTOR(40),
        INDEXER_MOTOR(50),
        FEEDER_MOTOR(51),
        CLIMBER_MOTOR(60),
        ; // Close ENUM list after last item

        /* Do not change enum below this line */
        public final int bus_id;

        private CAN(int bus_id) {
            this.bus_id = bus_id;
        }

        /** 
         * Returns the value representing the CAN Bus ID for the named device. 
         * <p>Ex. {@code Config.CAN.ELEVATOR_MOTOR.getID()} 
         * @return int
         */
        public int getID() {
            return bus_id;
        }

    }

     /**
     * Enum for DIO devices ONLY, in the format: {@code NAME(port_number)}
     * @param NAME (String, ALL CAPS)
     * @param port_number (int)
     */
    public enum DIO {
        LIMIT_SWITCH_ON_CLIMBER(0),
        LIMIT_SWITCH_ON_FRAME(1),
        ; // Close ENUM list after last item

        /* Do not change enum below this line */
        public final int port; 

        private DIO(int port) {
            this.port = port;
        }

        /** 
         * Returns the value representing the DIO Port number for the named device. 
         * <p>Ex. {@code Config.DIO.ELEVATOR_LIMIT_SWITCH.getPort()} 
         * @return int
         */
        public int getPort() {
            return port;
        }

    }

     /**
     * Enum for PWM devices ONLY, in the format: {@code NAME(port_number)}
     * @param NAME (String, ALL CAPS)
     * @param port_number (int)
     */
    public enum PWM {
        SHOOTER_HOOD_ACTUATOR(2),
        ; // Close ENUM list after last item

        /* Do not change enum below this line */
        public final int port; 

        private PWM(int port) {
            this.port = port;
        }

        /** 
         * Returns the value representing the PWM Port number for the named device. 
         * <p>Ex. {@code Config.PWM.ACTUATOR.getPort()} 
         * @return int
         */
        public int getPort() {
            return port;
        }

    }

}
