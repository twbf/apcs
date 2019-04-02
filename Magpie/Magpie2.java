/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
//package de.vogella.regex.string;
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

    private String statement = " ";

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String state)
	{
        statement = state;
        statement = statement.toLowerCase();
		String response = "";
		if (check("no")){
			response = "Why so negative?";
		}
		else if (check("mother")
				|| check("sister")
				|| check("brother")
				|| check("father")){
			response = "Tell me more about your family.";
		} else if (check("dog")){
			response = "Tell me more about your pets.";
		} else if (check("Mr. Scrurr")){
			response = "he sounds like a great teacher";
		}  else if (statement.trim().length() == 0){
			response = "SAY SOMETHING";
		} else if (check("shirt")){
			response = "Tell me more about your clothing";
		} else if (check("sad")){
			response = "Don't be";
		} else if (check("happy")){
			response = "Nice!";
		} else if(statement.length()>7){
            if (statement.indexOf("i want") >= 0){
                response = "Would you really be happy if you had " + statement.substring(7);
            } else if (statement.indexOf("i like") >= 0){
                response = "What do you like about " + statement.substring(7);
            }
        }
		else
		{
			response = getRandomResponse();
		}
        if (response.equals("")){
            response = "Really?";
        }

		return response;
	}


    private boolean check(String word){
        return statement.matches(".*"+word+"(\\W|$).*");
    }

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
        String[] responces  = { "Interesting, tell me more", "Hmmm.", "Do you really think so?", "You don't say.", "Wow, I don't know", "Tell me."};
		double r = Math.random();
		int whichResponse = (int)(r * responces.length);
		return responces[whichResponse];
	}
}
