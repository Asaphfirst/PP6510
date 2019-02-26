/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 * Add your docs here.
 */
public class Intake extends Subsystem {

  WPI_TalonSRX left = new WPI_TalonSRX(11);
  //WPI_VictorSPX right = new WPI_VictorSPX(3);

   //SpeedControllerGroup motors = new SpeedControllerGroup(left,right);

  // Put methods for controlliXng this subsystem
  // here. Call these from Commands.
  public void intake(double speed){
    left.set(-speed);
  }
  public void stop(double speed){
    left.set(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
