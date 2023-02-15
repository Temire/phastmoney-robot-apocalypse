package ng.temire.phastmoney.robot.apocalypse.errohandling;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:27
 */
public class SurvivorNotFoundException extends RuntimeException{
    public SurvivorNotFoundException(String message) {
        super(message);
    }
}
