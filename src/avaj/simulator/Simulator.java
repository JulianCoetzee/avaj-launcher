package src.avaj.simulator;

import java.io.*;

import src.avaj.simulator.control.*;
import src.avaj.simulator.hangar.*;

public class Simulator {

    public static PrintWriter output; // output file writer
    public static int wc; // weather cycles
public static void main(String[] args)
{ 
    File simFile = new File("./simulation.txt"); 

    if (args.length < 1)
        return ;

    String scenarioName = args[0]; // scenario file

    try {
        output = new PrintWriter(simFile); // create output file
        } catch (FileNotFoundException fnf) {
            System.out.println("Error: " + fnf.getMessage());
            return ;
        }
        if (simFile.exists() && !simFile.isDirectory())
            output.print("");

        Hangar hangar = new Hangar();
        Tower tower = new Tower();

        try {
            BufferedReader br = new BufferedReader(new FileReader(scenarioName)); //read file
            String str;
            int i;
            String[] split;

            i = 1;
            while ((str = br.readLine()) != null)
            {
                if (i == 1) //analyse first line of scenario file
                {
                    try {
                        wc = Integer.parseInt(str);
                        if (wc < 0)
                        {
                            System.out.println("Error: Invalid scenario format. The first line must use a positive integer to indicate number of weather changes");
                            return ;
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error: Invalid scenario format. The first line must use a positive integer to indicate number of weather changes");
                        return ;
                    }
                }
                else
                {
                    split = str.split(" ");
                    if (split.length == 1 && split[0].isEmpty()) //ignore empty lines
                        continue ;
                    if (split.length != 5) // Aircraft format parameter check
                    {
                        throw new Exception("Aircraft format error: Scenario line " + i + ". Requires 5 parameters.");
                    }
                    // Register Aircraft
                    try {
                        hangar.Flight(
                            split[0],
                            split[1],
                            Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]),
                            Integer.parseInt(split[4])
                            ).registerToTower(tower);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error: Invalid coordinate parameters (non-integers)");
                    } catch (Exception err) {
                        System.out.println("Error: " + err.getMessage());
                    }
                }
                i++;
            }
            br.close();
        } catch (FileNotFoundException sfnf) {
            System.out.println("Error: Scenario file not found");
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
            return ;
        }
        // Run sim by changing weather
        while (wc > 0)
        {
            tower.weatherChange();
            wc--;
        }
        output.close();
    } 
}