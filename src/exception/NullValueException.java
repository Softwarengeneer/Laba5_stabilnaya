// 
// Decompiled by Procyon v0.5.36
// 

package exception;

public class NullValueException extends Throwable
{
    public NullValueException(final String s) {
        super(s + " should be not null");
    }
}
