package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    private final TalonFX leftCommander, rightCommander, leftFollower, rightFollower;
    public Drivetrain(){
        leftCommander = new TalonFX(0);
        leftFollower = new TalonFX(1);
        rightCommander = new TalonFX(2);
        rightFollower = new TalonFX(3);
        leftCommander.setNeutralMode(NeutralModeValue.Brake);
        leftFollower.setNeutralMode(NeutralModeValue.Brake);
        rightCommander.setNeutralMode(NeutralModeValue.Brake);
        rightFollower.setNeutralMode(NeutralModeValue.Brake);
        leftCommander.setInverted(false);
        leftFollower.setInverted(false);
        rightCommander.setInverted(true);
        rightFollower.setInverted(true);
        leftFollower.setControl(new Follower(leftCommander.getDeviceID(), false));
        rightFollower.setControl(new Follower(rightCommander.getDeviceID(), false));
    }

    public void drive(double left, double right){
        leftCommander.set(left * 20);
        rightCommander.set(right * 20);
    }

    public void stop(){
        leftCommander.set(0);
        rightCommander.set(0);
    }
}
