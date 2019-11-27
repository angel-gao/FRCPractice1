/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //instantiate new motor controller objects
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);

  //instantiate a new DifferentialDrive object
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  //create constructor function
  public DriveSubsystem () {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  //add manualDrive() method
  public void manualDrive(double move, double turn) {
      drive.arcadeDrive(move, turn);
  }




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
