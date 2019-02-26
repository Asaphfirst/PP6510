/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Outtake extends Subsystem {
  WPI_TalonSRX left = new WPI_TalonSRX(4);
  WPI_TalonSRX right = new WPI_TalonSRX(5);

  //private SpeedControllerGroup motors = new SpeedControllerGroup(left,right);
  public static DigitalInput limitSwitch = new DigitalInput(0);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public Outtake(){
  //left.setInverted(true); 

}
public void outtake(double speed){
  left.set(-speed);
  right.set(speed);
}
public void intake(double speed){
  left.set(speed);
  right.set(-speed);
}
public void hold(){
  left.set(0.20);
  right.set(-0.20);
}
public void stop(double speed){
  left.set(0);
  right.set(0);
}
public boolean readSwitch(){
  return limitSwitch.get();
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
