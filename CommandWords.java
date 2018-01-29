package week7.zuul13;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 * @author  Michael Klling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
	/**
	 * 명령어 들을 화면에 출력한다
	 */

    private static final String[] validCommands = {
    	"go", "quit", "help", "look", "eat", "back", "take", "drop", "items"
    };
    
	public String getCommandList(){
		String commands = "";
		for(String command : validCommands){
			commands = commands + command + " ";
		}
		return commands;
	}
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
      * @param aString
     * @return true, if a given string is a valid command,
     *         false, if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
}
