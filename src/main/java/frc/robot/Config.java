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
        PDH(1),
        ROBORIO(2),
        SWERVE_FR_DRIVE(10),
        SWERVE_FR_TURN(11),
        SWERVE_FL_DRIVE(12),
        SWERVE_FL_TURN(13),
        SWERVE_BL_DRIVE(14),
        SWERVE_BL_TURN(15),
        SWERVE_BR_DRIVE(16),
        SWERVE_BR_TURN(17),
        SWERVE_FR_ENCODER(21),
        SWERVE_FL_ENCODER(22),
        SWERVE_BL_ENCODER(23),
        SWERVE_BR_ENCODER(24),
        PIGEON2(20), 
        SHOOTER_MOTOR(201),
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
