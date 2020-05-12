

package input;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class FileInput implements IOInterface
{
    private Scanner in;
    private String fileLine;
    
    public FileInput(final String fileName) throws FileNotFoundException {
        final String file = fileName;
        this.in = new Scanner(new File(file));
    }
    
    @Override
    public String getNextInput() {
        if (this.in.hasNext()) {
            this.fileLine = this.in.nextLine().toLowerCase();
            System.out.println(this.fileLine);
            return this.fileLine;
        }
        return null;
    }
    
    @Override
    public String getCurrentInput() {
        return this.fileLine;
    }
    
    @Override
    public void output(final String message) {
    }
    
    @Override
    public Float getNextFloatInput() {
        return this.in.nextFloat();
    }
    
    @Override
    public Long getNextLongInput() {
        return this.in.nextLong();
    }
}
