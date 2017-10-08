import java.util.*;
public class hangman
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public final static void clearConsole()
	{
    	try
    	{
    	    final String os = System.getProperty("os.name");
        	if (os.contains("Windows"))
        	{
            	Runtime.getRuntime().exec("cls");
        	}
        	else
        	{
            	Runtime.getRuntime().exec("clear");
        	}
    	}
    	catch (final Exception e)
    	{
    	}
	}
	
	public static void instructions()
	{
		System.out.println(ANSI_YELLOW+"888");                                                           
		System.out.println("888");                                                           
		System.out.println("888");                                                           
		System.out.println("88888b.  8888b. 88888b.  .d88b. 88888b.d88b.  8888b. 88888b.  ");
		System.out.println("888 \"88b    \"88b888 \"88bd88P\"88b888 \"888 \"88b    \"88b888 \"88b"); 
		System.out.println("888  888.d888888888  888888  888888  888  888.d888888888  888"); 
		System.out.println("888  888888  888888  888Y88b 888888  888  888888  888888  888"); 
		System.out.println("888  888\"Y888888888  888 \"Y88888888  888  888\"Y888888888  888"); 
        System.out.println("		              888                              ");
        System.out.println("		         Y8b d88P                              ");
        System.out.println("		          \"Y88P\"                               "+ANSI_RESET);
		System.out.println("****************************************************************************");
		System.out.println(ANSI_YELLOW+"         Welcome to HANGMAN Game"+ANSI_RESET);
		System.out.println(ANSI_GREEN+"      The Classic Word Guessing Game"+ANSI_RESET);
		System.out.println(ANSI_WHITE+"-------------------------------------------------"+ANSI_RESET);
		System.out.println(ANSI_GREEN+"This version of HANGMAN can be used for guessing country names.");
		System.out.println("The basic rules for this Game are:");
		System.out.println("=> A country name has to be guessed.");
		System.out.println("=> You will be given total 10 chances to guess the country's name");
		System.out.println("=> If you guess correct name, you WIN else you LOSE");
		System.out.println("##################################################################");
		System.out.println("SO LET'S BEGIN PLAYING"+ANSI_RESET);
	}
	
	public static void start_game()
	{
		Scanner ob=new Scanner(System.in);
		System.out.println("Are You Ready (Y/N)");
		String choice=ob.next();
		if(choice.equalsIgnoreCase("Y"))
		{
			System.out.println("Game Starts in :");
			for(int i=5;i>=1;i--)
			{
				System.out.println(i+" seconds");
				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		else
		{
			System.out.println(ANSI_BLUE+"Thank You for Using HANGMAN."+ANSI_RESET);
			System.exit(0);
		}
	}	
	
	public static void game()
	{
		Scanner ob=new Scanner(System.in);
		String word_list[]={"","INDIA","BRAZIL","SPAIN","THAILAND","RUSSIA","JAPAN","GERMANY","ITALY","CHINA","INDONESIA","PORTUGAL","SWEDEN","SWITZERLAND","SINGAPORE","CANADA","MEXICO","ARGENTINA","SCOTLAND","GREENLAND","FINLAND"};
		String choice_cont="";
		do
		{
			start_game();
			int word_index=(int)(Math.random()*(word_list.length-1)+1);
			String word=word_list[word_index];
			int len=word.length();
			String dash[]=new String[len];
			for(int i=0;i<len;i++)
				dash[i]="_";
			System.out.println("Your Word to be guesed is:");
			for(int i=0;i<len;i++)
				System.out.print(dash[i]+"  ");
			int flag=0,dup_flag=0;
			int wrong_attempts=0;
			while(wrong_attempts<=10)
			{
				String char_input=ob.next();
				System.out.println();
				int count_index=0;
				for(int j=0;j<len;j++)
				{
					if(char_input.equalsIgnoreCase(Character.toString(word.charAt(j))))
					{
						dash[j]=Character.toString(word.charAt(j));
						count_index++;
					}
				}
				if(count_index==0)
					wrong_attempts++;
				for(int j=0;j<len;j++)
					System.out.print(dash[j]+"  ");
				int f=0;
				for(int k=0;k<len;k++)
				{
					if(dash[k].equals("_"))
						f++;
				}
				if(f==0)
				{
					dup_flag=1;
					break;
				}
			}
			for(int i=0;i<len;i++)
			{
				if(dash[i].equals("_"))
				{
					flag=1;
					break;
				}
			}
			System.out.println();
			if(flag==1 || dup_flag==0)
				System.out.println("YOU LOSE");
			else
				System.out.println("YOU WIN");
			System.out.println("Do You Want to Continue (Y/N) ?");
			choice_cont=ob.next();
			if(choice_cont.equalsIgnoreCase("N"))
			{
				System.out.println(ANSI_RED+"Thank You for Using HANGMAN."+ANSI_RESET);
			}
			}while(choice_cont.equals("Y") || choice_cont.equals("y"));
		}
	
	public static void main(String args[])
	{
		hangman obj=new hangman();
		obj.clearConsole();
		obj.instructions();
		obj.game();
	}
}		
