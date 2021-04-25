package sensorrmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import sensorrmi.TemperatureSensor;
import sensorrmi.TemperatureSensorManager;

/**
 * This class represent the server-side application using RMI
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Create interface object
			TemperatureSensor sensorAKeroh = new TemperatureSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			rmiRegistry.rebind("Sensor Ayeh Keroh", sensorAKeroh);
			
			System.out.println("Sensor Ayeh Keroh is successfully registered");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
