// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** 
 * Use to define all CONSTANTS for robot configuration. 
 * Enums are provided for CAN bus devices, and DIO ports.
 */
public class Config {
    /**
     * Enum for CAN bus devices ONLY, in the format: {@code NAME(bus_id)}
     * <p>Use {@code Config.CAN.<NAME>.getID()} method to return the bus ID value.
     * 
     * @param NAME      String, ALL CAPS (it's a constant!)
     * @param bus_id    int 
     */
    public enum CAN {
        ROBORIO(1),
        PDH(2),
        SHOOTER_MOTOR(21),
        PIGEON2(100), 
        SWERVE_FR_DRIVE(110),
        SWERVE_FL_DRIVE(111),
        SWERVE_BL_DRIVE(112),
        SWERVE_BR_DRIVE(113),
        SWERVE_FR_TURN(120),
        SWERVE_FL_TURN(121),
        SWERVE_BL_TURN(122),
        SWERVE_BR_TURN(123),
        SWERVE_FR_ENCODER(130),
        SWERVE_FL_ENCODER(131),
        SWERVE_BL_ENCODER(132),
        SWERVE_BR_ENCODER(133),
        ;

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
        ELEVATOR_LIMIT_SWITCH(0),
        CORAL_SENSOR_F(2),
        CORAL_SENSOR_B(1); 

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

}
