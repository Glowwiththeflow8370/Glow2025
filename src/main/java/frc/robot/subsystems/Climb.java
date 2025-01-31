// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  SparkMax ClimbMotor, ClimbMotorFollower;

  SparkMaxConfig ClimbMotorConfigs, ClimbMotorFollowerConfigs;

  /** Creates a new Climb. */
  public Climb() {
    ClimbMotor = new SparkMax(5, MotorType.kBrushless);
    ClimbMotorFollower = new SparkMax(6, MotorType.kBrushless);
    
    ClimbMotorConfigs = new SparkMaxConfig();
    ClimbMotorConfigs.idleMode(IdleMode.kBrake);

    ClimbMotorFollowerConfigs = new SparkMaxConfig();
    ClimbMotorFollowerConfigs.follow(ClimbMotor);
    ClimbMotorFollowerConfigs.idleMode(IdleMode.kBrake);

    ClimbMotorFollower.configure(ClimbMotorFollowerConfigs, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    ClimbMotor.configure(ClimbMotorConfigs, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void runClimb(double value)
  {
    ClimbMotor.set(value);
    // Create theoretical code for a more advanced climbing mechanism
    // Possibly using encoders.
  }
  public void stopClimb(){
    ClimbMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
