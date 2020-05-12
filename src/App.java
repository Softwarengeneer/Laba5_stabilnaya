


import exception.IncorrectValue;
import exception.NoArgument;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import java.util.Iterator;
import javax.xml.bind.Unmarshaller;
import input.IOInterface;
import input.TerminalInput;
import java.util.Date;
import exception.NoCorrectValue;
import exception.NullValueException;
import basis.Dragon;
import javax.xml.bind.JAXBContext;
import collection.DragonCollection;
import java.util.Scanner;
import java.io.File;
import collection.CommandHandler;
import collection.CommandReader;

public class App
{
    private CommandReader reader;
    private CommandHandler handler;
    
    public void begin(final String file) throws NoCorrectValue, NullValueException, JAXBException, IOException, NoArgument, IncorrectValue {
        final Scanner in = new Scanner(new File(file));
        final StringBuffer data = new StringBuffer();
        while (in.hasNext()) {
            data.append(in.nextLine());
        }
        final JAXBContext context1 = JAXBContext.newInstance(new Class[] { DragonCollection.class });
        final Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        final DragonCollection dragonCollection = (DragonCollection) jaxbUnmarshaller.unmarshal(new File(file));
        for (final Dragon hb : dragonCollection.getDragons()) {
            if (hb.getName().trim().equals("")) {
                throw new NullValueException("name");
            }
            if (hb.getCoordinates().getX() == null) {
                throw new NullValueException("x");
            }
            if (hb.getCoordinates().getY() == null) {
                throw new NullValueException("y");
            }
            if (hb.getCoordinates().getY() > 649.0f) {
                throw new NoCorrectValue("ты тут попутал с игреком");
            }
            if (hb.getCoordinates().getX() < -671L) {
                throw new NoCorrectValue("ты тут попутал с иксом");
            }
            if (hb.getCreationDate() == null) {
                throw new NullValueException("date");
            }


            if (hb.getId() <= 0) {
                throw new NoCorrectValue("Id should be > 0");
            }
        }
        dragonCollection.setDate(new Date());
        this.handler = new CommandHandler(dragonCollection, file);
        final TerminalInput terminal = new TerminalInput();
        terminal.output("Вечер в хату, господин арестант, вводи help и я тебе покажу свои умения");
        while (!terminal.getNextInput().equals("exit")) {
            this.handler.doCommand(terminal);
        }
    }
}
