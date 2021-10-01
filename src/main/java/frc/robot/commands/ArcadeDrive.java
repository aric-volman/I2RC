package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
    private final DriveTrain _driveTrain;
    private final Joystick _joystick;

    // ArcadeDrive constructor
    public ArcadeDrive(DriveTrain dt, Joystick joy) {
        // The method addRequirements declares subsystem dependencies if needed.
        _driveTrain = dt;
        _joystick = joy;
        addRequirements(_driveTrain);
    }

    // Initial command if needed
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = _joystick.getRawAxis(Constants.JoystickAxis.YAxis);
        double rotation = _joystick.getRawAxis(Constants.JoystickAxis.XAxis);
        _driveTrain.arcadeDrive(-0.75*speed, rotation);
    }
    

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Return true when the command should end???
    @Override
    public boolean isFinished() {
        return false;
    }
}
