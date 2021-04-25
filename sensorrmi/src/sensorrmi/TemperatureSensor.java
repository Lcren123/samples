package sensorrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * This interface represents temperature sensor
 * 
 * @author emalianakasmuri
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int hashmap(String i) throws RemoteException;
	public int getDay(String i)  throws RemoteException;
	public int getTemperature() throws RemoteException;

}
