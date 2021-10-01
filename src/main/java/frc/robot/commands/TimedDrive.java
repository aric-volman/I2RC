package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class TimedDrive extends CommandBase{
    
    private final DriveTrain _driveTrain;
    private final double _leftSpeed;
    private final double _rightSpeed;
    private final double _time;
    private final Timer _timer;

    public TimedDrive (DriveTrain dt) {
        
        _driveTrain = dt; 
        _leftSpeed = 1;
        _rightSpeed = 1;
        _time = 5;
        _timer = new Timer();
        addRequirements(_driveTrain);
    }

    @Override
    public void initialize() {
        _timer.start();
        _timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double _newTime = _timer.get();
      if (_time >= _newTime){
          _driveTrain.tankDrive(-1.0 * _leftSpeed,
                            -1.0 * _rightSpeed);
            _newTime = _timer.get();
        } else {
            _driveTrain.tankDrive(0, 0); // STOP THE MOTOR!!!
        }

    }

}
