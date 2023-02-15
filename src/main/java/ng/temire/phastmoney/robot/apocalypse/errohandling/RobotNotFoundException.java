package ng.temire.phastmoney.robot.apocalypse.errohandling;

/**
 * @author Temire Emmanuel
 * @created 13/02/2023 - 10:22
 */
public class RobotNotFoundException  extends RuntimeException{
    public RobotNotFoundException(String message) {
        super(message);
    }
}
