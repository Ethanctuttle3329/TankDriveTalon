package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TankDriveCommand extends Command{
    private final Drivetrain drivetrain;
    private final double left, right;
    public TankDriveCommand(double left, double right, Drivetrain drivetrain){
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        drivetrain.drive(left, right);
    }

    @Override
    public void end(boolean interrupted){
        drivetrain.stop();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}