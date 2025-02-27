// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import com.ctre.phoenix6.SignalLogger;
// import edu.wpi.first.epilogue.logging.*;
// import org.littletonrobotics.urcl.URCL;
// import edu.wpi.first.epilogue.EpilogueConfiguration;
// import edu.wpi.first.epilogue.Logged;
// import edu.wpi.first.epilogue.logging.EpilogueBackend;
// import edu.wpi.first.wpilibj.DataLogManager;
// import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
// @Logged
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  // Declare Subsystems (For dependencies)
  public static Drivetrain Drivetrain = new Drivetrain();
  public static Climb Climb = new Climb();
  public static Arm Arm = new Arm();
  public static Intake Intake = new Intake();
  public static Wrist Wrist = new Wrist();
  public static Elevator Elevator = new Elevator();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Going to put the logging stuff here
    // DataLogManager.start();
    // URCL.start();
    // DriverStation.startDataLog(DataLogManager.getLog());
    // SignalLogger.setPath("/U/logs");
    // SignalLogger.start();

    // Reset Positions (To make sure everything is set)
    Drivetrain.resetNavX();
    Drivetrain.resetEncoders();

    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Drivetrain values
    SmartDashboard.putNumber("Drivetrain Angle", Drivetrain.getAngle());
    // Encoder values (in terms of rotations/angles)
    SmartDashboard.putNumber("Drivetrain Encoder Pos", Drivetrain.getAverageEncoderValues());
    SmartDashboard.putNumber("Right Drivetrain enc pos", Drivetrain.getRightEncValues());
    SmartDashboard.putNumber("Left Drivetrain enc pos", Drivetrain.getLeftEncValues());
    // Drivetrain distances (in meters)
    SmartDashboard.putNumber("Right Distance (Meters)", Drivetrain.getRightDistMeters());
    SmartDashboard.putNumber("Left Distance (Meters)", Drivetrain.getLeftDistMeters());
    // Get Robot's acceleration

    // Get angles of subsystems
    SmartDashboard.putNumber("Arm Angle", Arm.getArmAngle());
    SmartDashboard.putNumber("Wrist Angle", Wrist.getWristAngle());
    SmartDashboard.putNumber("Elevator Position (Deg)", Elevator.getEncoderValues());
    SmartDashboard.putNumber("Climb Angle", Climb.getClimbEncoderValues());
    // Get the status of the Arm Limit Switch
    SmartDashboard.putBoolean("Arm Limit Switch Status", Arm.getLimitSwitchStatus());

    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}