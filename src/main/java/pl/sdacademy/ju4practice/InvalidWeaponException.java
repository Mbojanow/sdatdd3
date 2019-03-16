package pl.sdacademy.ju4practice;

public class InvalidWeaponException extends RuntimeException {

    public InvalidWeaponException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
