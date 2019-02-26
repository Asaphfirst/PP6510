/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */


public class PneumaticThing extends Subsystem {

DoubleSolenoid  Pneumatic = new DoubleSolenoid(0, 1);
//DoubleSolenoid Pneumatic2 = new DoubleSolenoid(2, 3);


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public PneumaticThing(){
  Pneumatic.set(DoubleSolenoid.Value.kForward);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void extend(){
    Pneumatic.set(DoubleSolenoid.Value.kForward);

  }
  public void retract(){
    Pneumatic.set(DoubleSolenoid.Value.kReverse);
  }
}
// this was for the hatch panel but i guess it isnt anymore?