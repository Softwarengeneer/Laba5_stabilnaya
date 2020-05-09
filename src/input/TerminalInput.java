// 
// Decompiled by Procyon v0.5.36
// 

package input;

import java.util.Scanner;

public class TerminalInput implements IOInterface
{
    private String currentInput;
    
    @Override
    public String getNextInput() {
        final Scanner sc = new Scanner(System.in);
        return this.currentInput = sc.nextLine().trim();
    }
    
    @Override
    public String getCurrentInput() {
        return this.currentInput;
    }
    
    @Override
    public void output(final String message) {
        System.out.println(message);
    }
    
    @Override
    public Float getNextFloatInput() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }
    
    @Override
    public Long getNextLongInput() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }
}
