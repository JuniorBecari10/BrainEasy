import java.io.*;
import java.nio.Files;

import java.util.List;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("The length of the arguments is not 2!");
            
            return;
        }
        
        File src = new File(args[0]);
        File out = new File(args[1]);
        
        List<String> lines = new ArrayList<String>();
        
        try {
            
        } catch (Exception e) {
            System.err.println("An problem occurred and the program has been terminated.");
        }
    }
}
