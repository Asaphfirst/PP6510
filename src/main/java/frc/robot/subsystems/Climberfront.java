/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.constantsintake.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.InvertType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

/**
 * Add your docs here.
 */
public class Climberfront extends Subsystem {
  WPI_TalonSRX left_master = new WPI_TalonSRX(3);
  WPI_TalonSRX right_follower = new WPI_TalonSRX(1);
 
  //double hatch_panel_tranfer_position = ;
  //284.44444;
  double intakePosition = 910.2222222;
  double hatch_panel_pick_up_position =  853.333333;

public Climberfront(){

//Right followe left motor
right_follower.follow(left_master);

/*CTRE we recommends first calling the configFactoryDefault 
routine/VI to ensure motor controller is restored to a known state,
thus allowing you to only config the settings that you intend to change.*/
left_master.configFactoryDefault();
right_follower.configFactoryDefault();

// Calling 
ClimberRobotInit();

//left_master.setInverted(invertType);
//left_master.setInverted(false);
right_follower.setInverted(InvertType.InvertMotorOutput);

//using a ramp will avoid sudden changes, makes it start a movement smoothly 
left_master.configClosedloopRamp(0.4);
right_follower.configClosedloopRamp(0.4);

//left_master.setSensorPhase(true);
stop();
  
}
@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void move_up(double speed){
    left_master.set(-speed);
  }
  public void move_down(double speed){
    left_master.set(speed);
    //left_master.set(ControlMode.Position, 1706);
  }
  public void start_configuration_climber(){
    left_master.set(ControlMode.Position, 0);
  }
  public void safe_config_climber(){
    left_master.set(ControlMode.Position, RobotMap.Safe_Intake_Position);
  }
  public void hatch_panel_transfer_position(){
    left_master.set(ControlMode.Position, RobotMap.Hatch_Panel_tranfer_Position);
  }
  public void hatch_panel_pick_up_position(){
    left_master.set(ControlMode.Position, RobotMap.Hatch_panel_pick_up_position);
  }
  public void intake_position(){
    left_master.set(ControlMode.Position, RobotMap.Cargo_Intake_Position);
  }
  public void stop(){
    left_master.set(0);
  } 
  public float log(){
    return getClimberAngle();
  }
  public float getClimberAngle(){
    return left_master.getSelectedSensorPosition() * 360/4096;
  }
public void climberTeleopInit(){
  left_master.setSelectedSensorPosition(0,0,80);
}
public void ClimberRobotInit(){
  /* Config the sensor used for Primary PID and sensor direction */
  left_master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx,
  Constants.kTimeoutMs);
  
  /* Ensure sensor is positive when output is positive */
  left_master.setSensorPhase(Constants.kSensorPhase);
  
  /**
		 * Set based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. 
		 */ 
  left_master.setInverted(Constants.kMotorInvert);

  /* Config the peak and nominal outputs, 12V means full */
  left_master.configNominalOutputForward(0, Constants.kTimeoutMs);
  left_master.configNominalOutputReverse(0, Constants.kTimeoutMs);
  left_master.configPeakOutputForward(1, Constants.kTimeoutMs);
  left_master.configPeakOutputReverse(-1, Constants.kTimeoutMs);

  /**
		 * Config the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
    left_master.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
  
    /* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
    left_master.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		left_master.config_kP(Constants.kPIDLoopIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		left_master.config_kI(Constants.kPIDLoopIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		left_master.config_kD(Constants.kPIDLoopIdx, Constants.kGains.kD, Constants.kTimeoutMs);

    /**
		 * Grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
    int absolutePosition = left_master.getSensorCollection().getPulseWidthPosition();
    
    /* Mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (Constants.kSensorPhase) { absolutePosition *= -1; }
    if (Constants.kMotorInvert) { absolutePosition *= -1; }
    
    /* Set the quadrature (relative) sensor to match absolute */
    left_master.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    


}
  
}
