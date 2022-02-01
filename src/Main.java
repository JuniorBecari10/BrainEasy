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
                if (s.length() == 0) continue;
                
                String line = "";
                String[] split = s.split(" ");
                split[1] = s.substring(s.indexOf(" ") + 1);
                
                ///
                
                switch (split[0]) {
                    case "print": // print <message> / <$cell> / <$> (Local do ponteiro)
                        int counter = cells[pointer];
                        
                        if (split[1].startsWith("$")) { // é uma variável
                            if (split[1].length() != 1) {
                                int cell = Integer.parseInt(split[1].substring(1));
                                
                                while (pointer > cell) {
                                    line += "<";
                                    pointer--;
                                }
                                
                                while (pointer < cell) {
                                    line += ">";
                                    pointer++;
                                }
                            }
                            
                            line += ".";
                        }
                        else {
                            while (pointer > 0) { // a célula usada é o 0
                                line += "<";
                                pointer--;
                            }
                                
                            while (pointer < 0) {
                                line += ">";
                                pointer++;
                             }
                            
                            for (char c : split[1].toCharArray()) {
                                int ascii = (int) c;
                                
                                while (counter > 0) {
                                    line += "-";
                                    counter--;
                                }
                                
                                ///////////////////////////////
                                
                                while (counter < 0) {
                                    line += "+";
                                    counter++;
                                }
                                
                                while (counter > 0) {
                                    line += "-";
                                    counter--;
                                }
                                
                                while (counter < ascii) {
                                    line += "+";
                                    counter++;
                                }
                                
                                while (counter > ascii) {
                                    line += "-";
                                    counter--;
                                }
                                
                                line += ".";
                                
                                while (counter < 0) {
                                    line += "+";
                                    counter++;
                                }
                                
                                while (counter > 0) {
                                    line += "-";
                                    counter--;
                                }
                            }
                            
                            cells[pointer] = counter;
                        }
                    break;
                    
                    case "set": // set <cell> <value>/$<cell>
                        String[] spl = s.split(" ");
                        String[] onlyArgs = Arrays.copyOfRange(spl, 1, spl.length);
                        
                        boolean isSecondCell = onlyArgs[1].startsWith("$");
                        
                        int cell = Integer.parseInt(onlyArgs[0]);
                        int value = -1;
                        
                        if (!isSecondCell)
                            value = Integer.parseInt(onlyArgs[1]);
                        else
                            value = cells[Integer.parseInt(onlyArgs[1].substring(1))];
                        
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
                        
                        //if (isSecondCell) value = cells[value];
                        
                        while (counter < value) {
                            line += "+";
                            counter++;
                        }
                        
                        while (counter < value) {
                            line += "-";
                            counter--;
                        }
                        
                        cells[pointer] = counter;
                        
                    break;
                    
                    case "input": // input <cell>
                        cell = Integer.parseInt(split[1]);
                        
                        while (pointer > cell) {
                            line += "<";
                            pointer--;
                        }
                            
                        while (pointer < cell) {
                            line += ">";
                            pointer++;
                        }
                        
                        line += ",";
                        
                    break;
                    
                    case "moveptr": // moveptr <left> / <right>
                        switch (split[1]) {
                            case "left":
                                line += "<";
                                pointer--;
                            break;
                            
                            case "right":
                                line += ">";
                                pointer++;
                            break;
                        }
                    break;
                    
                    case "setpointer": // setpointer <position>
                        cell = Integer.parseInt(split[1]);
                        
                        while (pointer > 0) {
                            line += "<";
                            pointer--;
                        }
                        
                        while (pointer < cell) {
                            line += ">";
                            pointer++;
                        }
                        
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
            //System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
