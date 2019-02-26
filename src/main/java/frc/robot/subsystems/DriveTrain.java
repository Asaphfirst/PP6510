/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;




public class DriveTrain extends Subsystem {
 
 // private static final double VoltsPerDegreePerSecond=0.0128;
  

  WPI_TalonSRX left_master = new WPI_TalonSRX(6);
  WPI_VictorSPX left_1 = new WPI_VictorSPX(1);
  WPI_VictorSPX left_2 = new WPI_VictorSPX(3);

  WPI_TalonSRX right_master = new WPI_TalonSRX(2);
  WPI_VictorSPX right_1 = new WPI_VictorSPX(2);
  WPI_VictorSPX right_2 = new WPI_VictorSPX(5);

 DifferentialDrive drive = new DifferentialDrive(left_master,right_master);

public DriveTrain(){

   left_1.follow(left_master);
   left_2.follow(left_master);

   right_1.follow(right_master);
   right_2.follow(right_master);

   left_master.setNeutralMode(NeutralMode.Brake);
   left_1.setNeutralMode(NeutralMode.Brake);
   left_2.setNeutralMode(NeutralMode.Brake);
   right_master.setNeutralMode(NeutralMode.Brake);
   right_1.setNeutralMode(NeutralMode.Brake);
   right_2.setNeutralMode(NeutralMode.Brake);

   left_master.setInverted(false);
   left_1.setInverted(InvertType.FollowMaster);
   left_2.setInverted(InvertType.FollowMaster);
   right_master.setInverted(false);
   right_1.setInverted(InvertType.FollowMaster);
   right_2.setInverted(InvertType.FollowMaster);
   

  double ramp = 0.2;

  left_master.configOpenloopRamp(ramp);
  left_1.configOpenloopRamp(ramp);
  left_2.configOpenloopRamp(ramp);
  
  right_master.configOpenloopRamp(ramp);
  right_1.configOpenloopRamp(ramp);
  right_2.configOpenloopRamp(ramp);

}
 public void drive(double speed, double rotation){
  drive.arcadeDrive(speed, rotation);
  //drive.arcadeDrive(speed, rotation, true);
  //drive.curvatureDrive(speed, rotation, true);
 }  

 public void drive(XboxController stick){
   drive(Deadband(RobotMap.speedlimit * stick.getRawAxis(1)), - RobotMap.speedlimitTurn * Deadband(stick.getRawAxis(4)));
 }


 public void stop(){

   drive.arcadeDrive(0,0);
 }

 double Deadband(double value){
   /* Upper deadband */
		if (value >= +0.05) 
    return value;
  
  /* Lower deadband */
  if (value <= -0.05)
    return value;
  
  /* Outside deadband */
  return 0;
 }

 public void resetEncoders(){
   left_master.setSelectedSensorPosition(0);
 }
/* public double getDistance(){
   return encoder.getDistance();
 }*/
 public void currentLimit(){ // for current limiting not finished so im just gonna comment it
  /* left_master.configPeakCurrentLimit(35,10);
   left_master.configPeakCurrentDuration(200,10);
   left_master.configContinuousCurrentLimit(30,10);
   left_master. enableCurrentLimit(true);
   right_master.configMotionAcceleration(2000,RobotMap.TimeoutMs);
   right_master.configMotionCruiseVelocity(2000, RobotMap.TimeoutMs);

   right_master.configPeakOutputForward(+1.0,RobotMap.TimeoutMs);
   right_master.configPeakOutputReverse(-1.0, RobotMap.TimeoutMs);
    left_master.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,RobotMap.Pid_Primary,RobotMap.TimeoutMs);
    //right_master.configRemoteFeedbackFilter(0,RemoteSensorSource.left_master, RobotMap.Remote0);
*/
   }

   public void driveTrainInit(){


    left_master.set(ControlMode.PercentOutput, 0);
    right_master.set(ControlMode.PercentOutput, 0);

    left_master.configFactoryDefault();
    left_1.configFactoryDefault();
    left_2.configFactoryDefault();
    right_master.configFactoryDefault();
    right_1.configFactoryDefault();
    right_2.configFactoryDefault();

    left_master.setNeutralMode(NeutralMode.Coast);
    left_1.setNeutralMode(NeutralMode.Coast);
    left_2.setNeutralMode(NeutralMode.Coast);
    right_master.setNeutralMode(NeutralMode.Coast);
    right_1.setNeutralMode(NeutralMode.Coast);
    right_2.setNeutralMode(NeutralMode.Coast);

    left_master.setInverted(true);
    left_1.setInverted(InvertType.FollowMaster);
    left_2.setInverted(InvertType.FollowMaster);
    right_master.setInverted(false);
    right_1.setInverted(InvertType.FollowMaster);
    right_2.setInverted(InvertType.FollowMaster);
     
   }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoysticks());
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}