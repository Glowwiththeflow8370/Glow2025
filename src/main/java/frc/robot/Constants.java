// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class DrivetrainConstants{
    // Encoder Channels
    public static final int rightEncoderChanA = 0;
    public static final int rightEncoderChanB = 1;
    public static final int leftEncoderChanA = 2;
    public static final int leftEncoderChanB = 3;
    // Motor IDs
    public static final int rightFrontPort = 0;
    public static final int rightBackPort = 1;
    public static final int leftFrontPort = 2;
    public static final int leftBackPort = 3;
    // Misc
    public static final int multiplier = 1;
    public static final double Deadband = 0.25;
  }
}
