/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * Add your docs here.
 */
public class Climberrear extends Subsystem {
  
  DoubleSolenoid climber1 = new DoubleSolenoid(4,5);

public Climberrear(){
climber1.set(DoubleSolenoid.Value.kReverse);

}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public void climb(){
  climber1.set(DoubleSolenoid.Value.kForward);
} 
public void reverse(){
  climber1.set(DoubleSolenoid.Value.kReverse);
}
@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
