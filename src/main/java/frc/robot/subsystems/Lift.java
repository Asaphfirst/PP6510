/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.RobotMap;
import frc.robot.constantlift.LiftConstants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {

  WPI_TalonSRX left_Master = new WPI_TalonSRX(7);
  WPI_VictorSPX right_Follower = new WPI_VictorSPX(4);
  public DigitalInput limit_switch = new DigitalInput(9);
  public DigitalInput top_limit_switch = new DigitalInput(8);
  
  double liftStart= 550;
  double distperpulse = 123.935830479/4096;
  double test_distance = 52342;

public Lift(){ 
right_Follower.follow(left_Master);

left_Master.setNeutralMode(NeutralMode.Brake);
right_Follower.setNeutralMode(NeutralMode.Brake);
left_Master.configOpenloopRamp(0.2);
right_Follower.configOpenloopRamp(0.2);

left_Master.setSensorPhase(true);
LiftRobotInit();
left_Master.setInverted(false);
right_Follower.setInverted(true);

//resetEncoder();
setEncoderToStartConfig();
}

public void moveToPosition(int distance){
  left_Master.set(ControlMode.Position, distance);
}

public void resetEncoder()
{
  left_Master.setSelectedSensorPosition(0, 0, 30);
}

public void setEncoderToStartConfig(){
left_Master.setSelectedSensorPosition(RobotMap.start_configuration, 0, 30);
}



public void up(double speed){
  if(isLimitActive()){
    //left_Master.setSelectedSensorPosition(0, 0, 80);
  }
  left_Master.set(speed);
}

public void setHighPosition(){
  left_Master.setSelectedSensorPosition(52342, 0, 30);
}

public void down(double speed){
  if(isLimitActive()){
    left_Master.setSelectedSensorPosition(0, 0, 80);
  }
  left_Master.set(ControlMode.Position, 300);
}
public void stop(){
  
  if(isLimitActive()){
    //left_Master.setSelectedSensorPosition(0, 0, 80);
  }
  left_Master.set(0);
}
  public double log(){
    return getLiftHeight();
  }
  public double getLiftHeight(){
    return left_Master.getSelectedSensorPosition(); //* 125.663706144/4096;
  }
  public void LiftTeleopInit(){
    left_Master.setSelectedSensorPosition(18300,0,80);
  }
  public boolean isLimitActive(){
    return !limit_switch.get();
  }
  public boolean isTopLimitActive(){
    return top_limit_switch.get();
  }
  public void liftStart(){
    //left_Master.set(ControlMode.Position, 0);
  }
  public void liftB(){ //liftBottom
    left_Master.set(ControlMode.Position, distperpulse*0);
  }
  public void liftT(){ // liftTop
    left_Master.set(ControlMode.Position, distperpulse*1500); 
  }
  public void test(){
    left_Master.set(ControlMode.Position, test_distance);
  }
  public void gohome(){
    left_Master.set(ControlMode.Position, 0);
  }
  
    public void LiftRobotInit(){
    left_Master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, LiftConstants.kPIDLoopIdx,
    LiftConstants.kTimeoutMs);
  
    left_Master.setSensorPhase(LiftConstants.kSensorPhase);
    left_Master.setInverted(LiftConstants.kMotorInvert);
  
    left_Master.configNominalOutputForward(0, LiftConstants.kTimeoutMs);
    left_Master.configNominalOutputReverse(0, LiftConstants.kTimeoutMs);
    left_Master.configPeakOutputForward(1, LiftConstants.kTimeoutMs);
    left_Master.configPeakOutputReverse(-1, LiftConstants.kTimeoutMs);
    
    left_Master.configAllowableClosedloopError(0, LiftConstants.kPIDLoopIdx, LiftConstants.kTimeoutMs);
    left_Master.config_kF(LiftConstants.kPIDLoopIdx, LiftConstants.kGains.kF, LiftConstants.kTimeoutMs);
    left_Master.config_kP(LiftConstants.kPIDLoopIdx, LiftConstants.kGains.kP, LiftConstants.kTimeoutMs);
    left_Master.config_kI(LiftConstants.kPIDLoopIdx, LiftConstants.kGains.kI, LiftConstants.kTimeoutMs);
    left_Master.config_kD(LiftConstants.kPIDLoopIdx, LiftConstants.kGains.kD, LiftConstants.kTimeoutMs);
  
    
    int absolutePosition = left_Master.getSensorCollection().getPulseWidthPosition();
    absolutePosition &= 0xFFF;
      if (LiftConstants.kSensorPhase) { absolutePosition *= -1; }
      if (LiftConstants.kMotorInvert) { absolutePosition *= -1; }
      left_Master.setSelectedSensorPosition(absolutePosition, LiftConstants.kPIDLoopIdx, LiftConstants.kTimeoutMs);
  }
  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }
  public double geterror(){
    return left_Master.getClosedLoopError();
  }
  public double geterrorDist(){
    return 0.03025777111*geterror();
  }
}