
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path path = Paths.get("C:\\Users\\Emil\\Desktop\\shakespeare.txt");
        reading read = new reading(path);
        String[] words = null;
        try {
            words =read.toStringArray("[^A-Za-z]");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        read.quicksort(words);
        System.out.println(read.isSorted(words));
//        for (String object : words) {
//            System.out.println(object);
//        }
    }
    
}
