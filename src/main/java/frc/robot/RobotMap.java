/*
links:
https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java/MotionMagic_AuxStraightQuadrature/src/main/java/frc/robot/Robot.java
^ link to examples on git hub^
*/

package frc.robot;
public class RobotMap{


  public final static int TimeoutMs = 30;
  public final static int Pid_Primary =0;
  public final static int Remote0 = 0;
  
  public final static int Cargo_high = 52342;
  public final static int Cargo_middle = 34000;

  public final static int Hatch_Panel_middle = 27500;//25000;
  public final static int Hatch_Panel_high = 49000;//46800;
  public final static int home = 0;
  public final static int top = 52342;
  public final static int start_configuration = 17968;
  public final static int tranfer_position = 11000;
  public final static int SecondStageTop = 25000;
  public final static int low_Cargo_Rocket = 21256;

  
  public final static double Hatch_Panel_tranfer_Position = 170.66;//15/(360/4096)
  public final static double Hatch_panel_pick_up_position = 753.333333;
  public final static double Cargo_Intake_Position = 910.2222222;
  public final static double Safe_Intake_Position = 113;

  public  static double speedlimit = 1;
  public  static double speedlimitTurn = 0.8;

  
}