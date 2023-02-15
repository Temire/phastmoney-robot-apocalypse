package ng.temire.phastmoney.robot.apocalypse.errohandling;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }
}
