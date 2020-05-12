

import javax.xml.bind.JAXBException;
import exception.IncorrectValue;
import exception.NoArgument;
import exception.NoCorrectValue;
import java.io.IOException;
import exception.NullValueException;
import java.util.NoSuchElementException;
import java.nio.file.Paths;

public class Main
{
    public static void main(final String[] args) throws NullValueException, IOException, NoCorrectValue, NoArgument, IncorrectValue, JAXBException {
        try {
            final String file = Paths.get(args[0], new String[0]).toAbsolutePath().toString();
            final App app = new App();
            app.begin(file);
        }
        catch (NoSuchElementException e) {
            System.exit(0);
        }
    }
}
