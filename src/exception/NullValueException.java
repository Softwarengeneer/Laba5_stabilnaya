

package exception;

public class NullValueException extends Throwable
{
    public NullValueException(final String s) {
        super(s + " should be not null");
    }
}
