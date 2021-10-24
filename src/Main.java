import java.io.*;

import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("The length of the arguments is not 2!");
            
            return;
        }
        
        File src = new File(args[0]);
        File out = new File(args[1]);
        
        try {
            List<String> lines = Files.readAllLines(src.toPath(), StandardCharsets.UTF_8);
            List<String> output = new ArrayList<String>();
            
            int[] cells = new int[1000];
            int pointer = 0;
            
            Arrays.fill(cells, 0);
            
            for (String s : lines) {
                String line = "";
                String[] split = s.split(" ", 1);
                
                ///
                
                switch (split[0]) {
                    case "print":
                        if (split[1].startsWith("$")) { // é uma variável
                            
                        }
                        else {
                            
                        }
                    break;
                }
                
                ///
                
                output.add(line);
            }
        } catch (Exception e) {
            System.err.println("An problem occurred and the program has been terminated.");
        }
    }
}
