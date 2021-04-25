package sensorrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import sensorrmi.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		return 35;
	}

	@Override
	public int getDay(String i)  throws RemoteException{
		// TODO Auto-generated method stub
	
		return hashmap(i);
		
	
	}

	@Override
	public int hashmap(String i) throws RemoteException {
		// TODO Auto-generated method stub
		 HashMap<String, Integer> temperature = new HashMap<>();

		    // add elements to hashmap
		
		    temperature.put("Monday", 32);
		    temperature.put("Tuesday", 31);
		    temperature.put("Wednesday", 33);
		    temperature.put("Thursday", 35);
		    temperature.put("Friday", 36);
		    temperature.put("Saturday", 33);
		    temperature.put("Sunday", 33);
		  
		
		return temperature.get(i);
	}

}
