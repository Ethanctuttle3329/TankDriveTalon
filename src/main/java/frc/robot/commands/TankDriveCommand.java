package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TankDriveCommand extends Command{
    private final Drivetrain drivetrain;
    private final DoubleSupplier left, right;
    public TankDriveCommand(DoubleSupplier left, DoubleSupplier right, Drivetrain drivetrain){
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
        drivetrain.drive(left.getAsDouble(), right.getAsDouble());
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