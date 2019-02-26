/*
links:
https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java/MotionMagic_AuxStraightQuadrature/src/main/java/frc/robot/Robot.java
^ link to examples on git hub^
*/

package frc.robot;
//edu.wpi - functions and jazz
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
//edu.wpi other stuff
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
// frc.robot - subsystems
import frc.robot.subsystems.Outtake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PneumaticThing;
import frc.robot.subsystems.Shifter;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Climberrear;
import frc.robot.subsystems.Climberfront;
import frc.robot.commands.commandGroups.LimitSwitchStoppperoo;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
     
  public static DriveTrain drivetrain;
  public static Climberrear climberrear;
  public static Climberfront climberfront;
 public static PneumaticThing pneumaticthing;
  public static Outtake outtake;
  public static Intake intake;
  public static Lift lift;
  public static Shifter shifter;
  public static Oi oi;

  @Override
  public void robotInit() {
  

    //UsbCamera camera = 
CameraServer.getInstance().startAutomaticCapture();

    climberrear = new Climberrear();
    climberfront = new Climberfront();
    outtake = new Outtake();
    intake = new Intake();
    drivetrain = new DriveTrain();
    pneumaticthing = new PneumaticThing();
    lift = new Lift();
    shifter = new Shifter();
    oi = new Oi();

    Robot.climberfront.climberTeleopInit();
    Robot.lift.setEncoderToStartConfig();


    }
      @Override
  public void autonomousInit() {

  }

  @Override
  public void disabledInit() {

  }
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    log();
    
  }

  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    log();
  }
  
  public void log(){
    SmartDashboard.putNumber("Arm Encoder", Robot.climberfront.log());
    SmartDashboard.putNumber("Lift Encoder", Robot.lift.log());
    SmartDashboard.putBoolean("limit Switch", Robot.lift.isLimitActive());
    SmartDashboard.putBoolean("top limit Switch", Robot.lift.isTopLimitActive());
    //SmartDashboard.putNumber("lift speed" , Oi.j_operator.getRawAxis(1));
    SmartDashboard.putNumber("error", Robot.lift.geterror());
    SmartDashboard.putNumber("error in distance", Robot.lift.geterrorDist() );

    SmartDashboard.putNumber("speed", RobotMap.speedlimit);
    SmartDashboard.putNumber("speedturn", RobotMap.speedlimitTurn);
  }
  

  @Override
  public void testPeriodic() {
  }
}