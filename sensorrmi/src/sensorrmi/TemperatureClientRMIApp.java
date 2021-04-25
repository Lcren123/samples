package sensorrmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import sensorrmi.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("Sensor Ayeh Keroh");
			
			// Invoke method from the remote object
			String week[] = {"Monday","Tuesday","Tuesday","Thursday","Friday","Saturday","Sunday"};
		
			System.out.println("Temperature in Ayeh Keroh this week is:\n "); 
			for(int i = 0; i < 7; i++) {
				int temperature = remoteSensorJasin.getDay(week[i]);
				System.out.println(week[i] + ":" + temperature + " Celcius\n");
			}
			
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
