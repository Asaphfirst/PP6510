/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.OuttakeStop;

public class LimitSwitchStoppperoo extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LimitSwitchStoppperoo() {
    addParallel(new IntakeStop());
    addParallel(new OuttakeStop());
    //addSequential(new LiftUp());
    //addSequential(new ArmUp());
    //addSequential(new LiftDown());
  }
}
