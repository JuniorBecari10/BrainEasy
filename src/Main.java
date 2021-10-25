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
                String[] split = s.split(" ");
                split[1] = s.substring(s.indexOf(" ") + 1);
                
                ///
                
                switch (split[0]) {
                    case "print":
                        int counter = cells[pointer];
                        
                        if (split[1].startsWith("$")) { // é uma variável
                            int cell = Integer.parseInt(split[1].substring(1));
                            
                            while (pointer > cell) {
                                line += "<";
                                pointer--;
                            }
                            
                            while (pointer < cell) {
                                line += ">";
                                pointer++;
                            }
                            
                            line += ".";
                        }
                        else {
                            for (char c : split[1].toCharArray()) {
                                int ascii = (int) c;
                                
                                while (counter > 0) {
                                    line += "-";
                                    counter--;
                                }
                                
                                ///////////////////////////////
                                
                                while (counter < ascii) {
                                    line += "+";
                                    counter++;
                                }
                                
                                while (counter < ascii) {
                                    line += "-";
                                    counter--;
                                }
                                
                                System.out.println(counter);
                                line += ".";
                            }
                            
                            cells[pointer] = counter;
                        }
                    break;
                    
                    case "set": // set <cell> <value>
                        String[] spl = s.split(" ");
                        String[] onlyArgs = Arrays.copyOfRange(spl, 1, spl.length);
                        
                        int cell = Integer.parseInt(onlyArgs[0]);
                        int value = Integer.parseInt(onlyArgs[1]);
                        
                        while (pointer > cell) {
                            line += "<";
                            pointer--;
                        }
                            
                        while (pointer < cell) {
                            line += ">";
                            pointer++;
                        }
                        
                        /// Set Value
                        
                        counter = cells[pointer];
                        
                        while (counter > 0) {
                            line += "-";
                            counter--;
                        }
                                
                        ///////////////////////////////
                                
                        while (counter < value) {
                            line += "+";
                            counter++;
                        }
                        
                        while (counter < value) {
                            line += "-";
                            counter--;
                        }
                        
                        System.out.println(counter);
                        
                    break;
                }
                
                ///
                
                output.add(line);
            }
            
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(out))) {
                for (String s : output) {
                    wr.write(s + "\n");
                }
                
                wr.close();
            }
        } catch (Exception e) {
            System.err.println("An problem occurred and the program has been terminated.");
        }
    }
}
