package src.avaj.simulator;

import java.io.*;
import java.util.*;

public class Simulator {

    public static PrintWriter output;
    public static int wc;
public static void main(String[] args)
{ 
// We need to provide file path as the parameter: 
// double backquote is to avoid compiler interpret words 
// like \test as \t (ie. as a escape sequence) 
    File simFile = new File("../../../simulation.txt"); 

    if (args.length < 1)
    return;
// scenario filename
    String scenarioName = args[0];
    try {
        output = new PrintWriter(simFile);
    } catch (FileNotFoundException fnf) {
        System.out.println("Error: " + fnf.getMessage());
        return;
}
    if (simFile.exists() && !simFile.isDirectory())
        output.print("");

    try {
        BufferedReader br = new BufferedReader(new FileReader(scenarioName)); 

        String str; 
        while ((str = br.readLine()) != null)
        {
            System.out.println(str);
        }
        br.close();
    } catch (FileNotFoundException sfnf) {
        System.out.println("Error: Scenario file not found");
    } catch (Exception err) {
        System.out.println("Error: " + err.getMessage());
    }
} 
}