// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /** Creates a new Spark. */
  
  SparkMax elevatorMotor;
  SparkMax elevatorMotorFollower;

  SparkMaxConfig elevatorMotorConfig = new SparkMaxConfig();
  SparkMaxConfig elevatorMotorFollowerConfig = new SparkMaxConfig();
  
  public Elevator() {
    elevatorMotor = new SparkMax(0, MotorType.kBrushless);
    elevatorMotorFollower = new SparkMax(1, MotorType.kBrushless);  
    
    elevatorMotorConfig.idleMode(IdleMode.kBrake);
    elevatorMotorFollowerConfig.follow(elevatorMotor);
  }
  public void moveMotor(double x) {
    elevatorMotor.set(x);
    
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


