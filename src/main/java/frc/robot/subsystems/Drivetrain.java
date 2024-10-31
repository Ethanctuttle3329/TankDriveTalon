package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    private final TalonFX leftFront, leftBack, rightFront, rightBack;
    
    public Drivetrain() {
        leftFront = new TalonFX(Constants.DrivetrainConstants.leftFrontID);
        leftBack = new TalonFX(Constants.DrivetrainConstants.leftBackID);
        rightFront = new TalonFX(Constants.DrivetrainConstants.rightFrontID);
        rightBack = new TalonFX(Constants.DrivetrainConstants.rightBackID);

        leftFront.setInverted(Constants.DrivetrainConstants.invert);
        leftBack.setInverted(Constants.DrivetrainConstants.invert);
        rightFront.setInverted(!Constants.DrivetrainConstants.invert);
        rightBack.setInverted(!Constants.DrivetrainConstants.invert);
        leftFront.setNeutralMode(NeutralModeValue.Brake);
        leftBack.setNeutralMode(NeutralModeValue.Brake);
        rightFront.setNeutralMode(NeutralModeValue.Brake);
        rightBack.setNeutralMode(NeutralModeValue.Brake);
        leftBack.setControl(new Follower(leftFront.getDeviceID(), false));
        rightBack.setControl(new Follower(rightFront.getDeviceID(), false));  
    }

    public void drive(double left, double right){
        leftFront.set(left);
        rightFront.set(right);
    }

    public void stop(){
        leftFront.set(0);
        rightFront.set(0);
    }
}
