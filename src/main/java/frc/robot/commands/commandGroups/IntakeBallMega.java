/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.IntakePosition;
import frc.robot.commands.OuttakeIntake;
import frc.robot.commands.LiftGoHome;



public class IntakeBallMega extends CommandGroup {
  /**
   * MEGA INTAKE
   */
  public IntakeBallMega() {
  
    addParallel(new IntakeCargo());
    addParallel(new OuttakeIntake());
    addParallel(new IntakePosition());
    addParallel(new LiftGoHome());
    //addSequential(new LiftUp(2));
    //addSequential(new A)

    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
