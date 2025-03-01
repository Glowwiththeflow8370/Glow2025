// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Wrist;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class RotateWristToPosition extends Command {
  /** Creates a new RotateWristToPosition. */

  private Wrist wrist;
  private double angle;

  public RotateWristToPosition(Wrist wrist, double angle) {
    this.wrist = wrist;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.Wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // wrist.rotateWrist(-0.35);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    // if(wrist.getWristAngle() == angle){
    //   wrist.rotateWrist(0);
    //   System.out.println("Finished Rotating");
    //   return true;
    // }
    // return false;
    return false;
  }
}
