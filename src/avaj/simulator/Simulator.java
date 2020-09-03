package src.avaj.simulator;

import java.io.*;
// import java.util.*;

public class Simulator {

    public static PrintWriter output; // output file writer
    public static int wc; // weather cycles
public static void main(String[] args)
{ 
// We need to provide file path as the parameter: 
// double backquote is to avoid compiler interpret words 
// like \test as \t (ie. as a escape sequence) 
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

                }
                System.out.println(str);
                i++;
            }
            br.close();
        } catch (FileNotFoundException sfnf) {
            System.out.println("Error: Scenario file not found");
        } catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }
    } 
}