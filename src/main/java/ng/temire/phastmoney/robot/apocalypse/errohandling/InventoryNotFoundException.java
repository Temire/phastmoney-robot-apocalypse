package ng.temire.phastmoney.robot.apocalypse.errohandling;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 12:27
 */
public class InventoryNotFoundException extends RuntimeException{
    public InventoryNotFoundException(String message) {
        super(message);
    }
}
