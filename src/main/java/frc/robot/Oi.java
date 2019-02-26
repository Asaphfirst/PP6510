/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.commandGroups.GoToStartConfig;
import frc.robot.commands.commandGroups.HandOff;
import frc.robot.commands.commandGroups.HandOffEnd;
import frc.robot.commands.commandGroups.IntakeBallMega;
import frc.robot.commands.commandGroups.IntakeBallMegaEnd;
import frc.robot.commands.commandGroups.LimitSwitchStoppperoo;
import frc.robot.commands.commandGroups.StopBallMega;
import frc.robot.commands.commandGroups.TranferMega;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.Intake_HatchPanel;
import frc.robot.commands.LiftGoHighHatchPanel;
import frc.robot.commands.LiftGoHome;
import frc.robot.commands.LiftGoMiddleHatchPanel;
import frc.robot.commands.LiftStop;
import frc.robot.commands.OuttakeCargo;
import frc.robot.commands.OuttakeIntake;
import frc.robot.commands.OuttakeStop;
import frc.robot.commands.OuttakeHold;
import frc.robot.commands.ShiftToHighGear;
import frc.robot.commands.ShiftToLowGear;
import frc.robot.commands.FrontClimberUp;
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.IntakePosition;
import frc.robot.commands.StopFrontClimber;
import frc.robot.commands.Tranfer_HatchPanel;
import frc.robot.commands.FrontClimberDown;
import frc.robot.commands.PneumaticIn;
import frc.robot.commands.PneumaticOut;
import frc.robot.commands.BackClimberDeploy;
import frc.robot.commands.BackClimberRetract;
import frc.robot.commands.LiftGoTop;
import frc.robot.commands.LiftGoMiddleCargo;
import frc.robot.commands.LiftGoStartConfig;
import frc.robot.commands.LiftGoTranferPosition;
import frc.robot.commands.FrontClimberStartConfig;
import frc.robot.commands.commandGroups.GoToStartConfigEnd;
import frc.robot.commands.IntakeReverse;
import frc.robot.commands.commandGroups.IntakeHatchPanelMega;
import frc.robot.commands.commandGroups.LowCargoMega;










public class Oi {
  public static final XboxController j_driver = new XboxController(0);
  //public static final XboxController j_operator = new XboxController(2);
  public static final XboxController usb_console = new XboxController(1);

  public Oi() {
    final JoystickButton driver_a = new JoystickButton(j_driver, 1);
    final JoystickButton driver_b = new JoystickButton(j_driver, 2);
    final JoystickButton driver_x = new JoystickButton(j_driver, 3);
    final JoystickButton driver_y = new JoystickButton(j_driver, 4);    // <-- DRIVER
    final JoystickButton driver_r1= new JoystickButton(j_driver,5);
    final JoystickButton driver_l1= new JoystickButton(j_driver,6);
    final JoystickButton driver_start= new JoystickButton(j_driver,8);
    final JoystickButton driver_back= new JoystickButton(j_driver,9);

    final JoystickButton button_1 = new JoystickButton(usb_console, 1);
    final JoystickButton button_2 = new JoystickButton(usb_console, 2);
    final JoystickButton button_3 = new JoystickButton(usb_console, 3);
    final JoystickButton button_4 = new JoystickButton(usb_console, 4);    // <-- DRIVER
    final JoystickButton button_5= new JoystickButton(usb_console,5);
    final JoystickButton button_6= new JoystickButton(usb_console,6);
    final JoystickButton button_7= new JoystickButton(usb_console,7);
    final JoystickButton button_8 = new JoystickButton(usb_console,8);
    final JoystickButton button_9 = new JoystickButton(usb_console,9);
    final JoystickButton button_10 = new JoystickButton(usb_console,10);
    final JoystickButton button_11 = new JoystickButton(usb_console, 11);    // <-- DRIVER
    final JoystickButton button_12= new JoystickButton(usb_console,12);

    button_7.whenPressed(new OuttakeCargo());
    button_7.whenReleased(new OuttakeStop());

    //button_6.whenPressed(new FrontClimberUp());
    //button_6.whenReleased(new StopFrontClimber());

    //button_5.whenPressed(new FrontClimberDown());
    //button_5.whenReleased(new StopFrontClimber());

    button_1.whenPressed(new PneumaticOut());
    button_1.whenReleased(new PneumaticIn());

    driver_l1.whenPressed(new ShiftToLowGear());
    driver_r1.whenPressed(new ShiftToHighGear());

    driver_a.whenPressed(new BackClimberDeploy());
    driver_y.whenPressed(new BackClimberRetract());

    button_2.whenPressed(new IntakeHatchPanelMega());
    button_2.whenReleased(new TranferMega());
    
    driver_b.whenPressed(new IntakeReverse());
    driver_b.whenReleased(new IntakeStop());
    //button_2.whenPressed(new IntakeBallMega());// IntakePosition());
    //button_2.whenReleased(new StopBallMega());//StopFrontClimber());

    /* LIFT */

    //button_3.whenPressed(new LiftGoHome());
    button_3.whenPressed(new IntakeBallMega());
    button_3.whenReleased(new IntakeBallMegaEnd());

    button_6.whenPressed(new LiftGoTop());
    button_5.whenPressed(new LiftGoMiddleCargo());
    button_8.whenPressed(new LiftGoMiddleHatchPanel());
    button_9.whenPressed(new LiftGoHighHatchPanel());

    driver_start.whenPressed(new GoToStartConfig());
    driver_start.whenReleased(new GoToStartConfigEnd());

   // driver_back.whenPressed(new FrontClimberStartConfig());
    //driver_back.whenReleased(new StopFrontClimber());

    button_11.whenPressed(new HandOff());
    button_11.whenReleased(new HandOffEnd()); //LiftGoMiddleHatchPanel());

    button_10.whenPressed(new FrontClimberDown());
    button_10.whenReleased(new FrontClimberStartConfig());

    button_4.whenPressed(new LowCargoMega());
    button_4.whenReleased(new IntakeStop());
    






  

    /*
    final JoystickButton operator_a = new JoystickButton(j_operator, 1);//intake
    final JoystickButton operator_b = new JoystickButton(j_operator, 2);//outtake
    final JoystickButton operator_x = new JoystickButton(j_operator, 3);
    final JoystickButton operator_y = new JoystickButton(j_operator,4);   // <-- OPERATOR
    final JoystickButton operator_r1= new JoystickButton(j_operator,5);//pneumatic climber
    final JoystickButton operator_l1= new JoystickButton(j_operator,6);//pneumatic climber
    final JoystickButton operator_back = new JoystickButton(j_operator,7);
    final JoystickButton operator_start= new JoystickButton(j_operator,8);
    final JoystickButton operator_10= new JoystickButton(j_operator,10);
     */


     // button_9.whenPressed(new LiftUp());
    //button_9.whenReleased(new LiftStop());

   //button_8.whenPressed(new LiftDown());
    //button_8.whenReleased(new LiftStop());


    //button_12.whenPressed(new LiftB());
    //button_12.whenReleased(new LiftStop());

    //button_8.whenPressed(new LiftA());
    //button_8.whenReleased(new LiftStop());
   // button_11.whenPressed(new LiftStart());
   // button_11.whenReleased(new LiftStop());

    //button_10.whenPressed(new LiftT());
   // button_10.whenReleased(new LiftStop());

  }
  public XboxController gXboxController() {
    return j_driver;
  }
}