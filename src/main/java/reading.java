
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emil
 */
public class reading {
    
    public static String[] toStringArray(String delimterPattern) throws IOException{
        return Files.lines(path)
                .flatMap(line-> Stream.of(line.split(delimterPattern)))
                .filter(word->!word.isEmpty())
                .map(word->word.toLowerCase())
                .toArray(String[]::new);
    }

    final static Charset ENCODING = StandardCharsets.UTF_8;
    static Path path;
    ArrayList<String> complete = new ArrayList<>();

    public reading(Path path) {
        this.path = path;

    }
    
    public boolean isSorted(String[] str){
        for (int i = 0; i < str.length-1; i++) {
            if(str[i].compareTo(str[i+1]) > 1)
                return false;
        }
        return true;
    }
    String[] array;
    int length;
    public String[] quicksort(String[] inputArr,int lengthOfArray) {
         
        if (inputArr == null || inputArr.length == 0) {
            return null;
        }
        this.array = inputArr;
        if(lengthOfArray<inputArr.length)
            length = lengthOfArray;
        else
        length = inputArr.length;
        sort(0, length - 1);
        return array;
    }
    public String[] quicksort(String[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return null;
        }
        this.array = inputArr;
        length = inputArr.length;
        sort(0, length - 1);
        return array;
    }
    private void sort(int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {
            while(array[i].compareTo(pivot)<0){
                i++;
            }
            while(array[j].compareTo(pivot)>0){
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            sort(lowerIndex, j);
        if (i < higherIndex)
            sort(i, higherIndex);
    }
    private void exchangeNumbers(int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
