// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ConversionConstants;

// @Logged
public class Arm extends SubsystemBase{
  /** Creates TheTickler. */

  private SparkMax ArmMotor, ArmMotorFollower;
  private SparkMaxConfig ArmConfig, ArmFollowerConfig;
  private DutyCycleEncoder ArmEncoder;
  private DigitalInput ArmLimitSwitch;

  // This is the Coral intake
  public Arm() {
    ArmMotor = new SparkMax(ArmConstants.ArmMotor, MotorType.kBrushless);
    ArmMotorFollower = new SparkMax(ArmConstants.ArmMotorFollower, MotorType.kBrushless);

    // Right Intake Motor Config
    ArmConfig = new SparkMaxConfig();
    ArmConfig.idleMode(IdleMode.kBrake);
    ArmConfig.encoder
    .positionConversionFactor(ConversionConstants.AngleConversionValue);

    ArmFollowerConfig = new SparkMaxConfig();
    ArmFollowerConfig.idleMode(IdleMode.kBrake);
    ArmFollowerConfig.follow(ArmMotor, true);

    ArmMotor.configure(ArmConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    ArmMotorFollower.configure(ArmFollowerConfig, ResetMode.kResetSafeParameters, 
    PersistMode.kPersistParameters);
    
    ArmEncoder = new DutyCycleEncoder(ArmConstants.ArmEncoderChannel);
    ArmLimitSwitch = new DigitalInput(ArmConstants.ArmLimitSwitchPort);

  }

  public void RunArm(double speed){

    ArmMotor.set(speed);
    
  }

  public double getArmAngle(){
    return ArmEncoder.get() * ConversionConstants.AngleConversionValue;
  }

  public boolean getLimitSwitchStatus(){
    return ArmLimitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
