
package collection;

import input.IOInterface;

public class CommandReader
{
    public String[] returnCommand(final IOInterface inputCommand) {
        return inputCommand.getCurrentInput().toLowerCase().trim().split(" ", 2);
    }
}
