package utill;



import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class SocketManager extends Thread
{


	private Generic g;

	private ServerSocket svrsock;

	private Vector<Socket> serverSockets;

	public SocketManager(Generic generic)
	{
		super("SocketManager");
		this.g=generic;
		serverSockets = new Vector<Socket>();
	}

	@Override
	public void run()
	{
		try
		{
			svrsock = new ServerSocket(25001);
			while(true)
			{
				Socket s = svrsock.accept();
				serverSockets.add(s);
				SocketListener sl = new SocketListener(s,g);
				sl.start();
			}
		}
		catch (BindException be)
		{
			
			System.out.println("Unable to bind to socket. If another instance of Tofu already running?");
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

	}

	public void stopSockMan()
	{
		try
		{
			svrsock.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
