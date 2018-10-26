package utill;
/*
 * @shubsing
 * A Single class to be used for all java robot functions.
 * Any funtion can be overwritten here to provide more flexibility.
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import utill.Generic;


public class MyRobot extends Robot
{
	public static final int DEFAULT_AUTO_DELAY_MS = 50;

	private static MyRobot uniqueInstance;

	Field[] fields = KeyEvent.class.getFields();

	static
	{
		try
		{
			uniqueInstance = new MyRobot();
		}
		catch (Exception e)
		{
			System.out.println("Could not get instance of Robot");
		}
	}

	private MyRobot() throws AWTException
	{
		super();
	
		setAutoDelay(DEFAULT_AUTO_DELAY_MS);
	}

	public static MyRobot getInstance()
	{
		return uniqueInstance;
	}

	/* Key press and release event processing */
	public void PressKeys(String s, int State, String shift) throws Exception
	{
		System.out.println("in PressKeys and s=" + s + " State=" + State + " shift=" + shift);
		//try
		//{
			setAutoDelay(30);
			Field f;
			int k;

			String ch;
			boolean found = false;
			for (int i = 0; i < s.length(); i++)
			{
				found = false;
				k = (int) s.charAt(i);
				ch = s.substring(i, i + 1).toUpperCase();

				if (ch.equals(" "))
					ch = "SPACE";

				if (shift.toUpperCase().equals("$KEYCODE"))
				{
					String cods[] = s.split(",");
					for (int m = 0; m < cods.length; m++)
					{
						ch = cods[m];
						if ((ch.equals("CONTROL") && Generic.currentBR().equals("mac")))
								ch = "META";
						for (int j = 0; j < fields.length; j++)
						{
							f = fields[j];
							if (f.getName().equals("VK_" + ch))
							{
								if (State == 1 || State == 0)
								{
									keyPress(f.getInt(null));
								}
								if (State == 2 || State == 0)
								{
									keyRelease(f.getInt(null));
								}
								break;
							}
						}
					}
					return;
				}

				if ((k > 64 && k < 91) || shift.toUpperCase().equals("$SHIFT"))
				{
					keyPress(16);
				} else {
				}
				for (int j = 0; j < fields.length; j++)
				{
					f = fields[j];
					if (f.getName().equals("VK_" + ch))
					{
						found = true;
						// System.out.println("Char is " + ch + " >> Keycode : "
						// + f.getInt(null));
						if (State == 1 || State == 0)
							keyPress(f.getInt(null));
						if (State == 2 || State == 0)
							keyRelease(f.getInt(null));

						if ((k > 64 && k < 91) || shift.toUpperCase().equals("$SHIFT"))
							keyRelease(16);
						break;
					}
				}
				if (!found)
				{
					if (k == 39) // VK_QUOTE
						k = 222;

					if (k == 58) // For Colon
					{
						keyPress(16);
						keyPress(KeyEvent.VK_SEMICOLON);
						keyRelease(KeyEvent.VK_SEMICOLON);
						keyRelease(16);
						continue;
					}

					if (k == 95) // For Underscore
					{
						keyPress(16);
						keyPress(KeyEvent.VK_MINUS);
						keyRelease(KeyEvent.VK_MINUS);
						keyRelease(16);
						continue;
					}

					if (s.charAt(i) == '`')
						k = 192;

					// System.out.println("Pressing : " + k);
					if (State == 1 || State == 0)
						keyPress(k);

					if (State == 2 || State == 0)
						keyRelease(k);

					if (shift.toUpperCase().equals("$SHIFT"))
						keyRelease(16);
				}
			}
		/*}
		catch (Exception e)
		{
			logger.error("Exception while pressing keys : " + e);
			e.printStackTrace();
		}*/
	}

	
	
}     



