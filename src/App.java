import java.util.Arrays;
import java.util.Random;
import java.io.*;
import dataStra.MyArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        // list.sortList();
        // System.out.println("2.elements ir: " +list.retrieve(2));
        // list.search(2);
        // System.out.println("Nakosais elements: " +list.nextElem(10));
        // list.clearList();

        
        MyArrayList list = new MyArrayList();
        FileReader file = new FileReader("C:\\Users\\pelpu\\OneDrive\\Desktop\\numbers.txt");
        BufferedReader bufferedreader = new BufferedReader(file);
        String line = bufferedreader.readLine();
        while(line != null){
            int nr = Integer.parseInt(line);
            Random r = new Random();
            list.add(nr, r.nextInt(9));
            line = bufferedreader.readLine();
        }
        System.out.println("Vai saraksts ir tukss: "+list.isEmpty());
        System.out.println("Vai saraksts ir pilns: "+list.isFull());
        System.out.println("Saraksta lielums ir: "+list.getSize());
        list.add(7);
        list.add(8, 3);
        list.remove(2);
        System.out.print("Masivs: ");    
        list.getList();
        System.out.println("-------------------------------------");
        System.out.println("3.elements ir: "+list.retrieve(3));
        System.out.println("Meklētais elements 3 ir : " + Arrays.toString(list.search(3)));
        System.out.println("Nakosais elements: "+Arrays.toString(list.nextElem(2)));
        list.sortList();
        System.out.print("Sakartots masivs: "); 
        list.getList();
        System.out.print("Dzest sarakstu \n");
        list.clearList();
        System.out.print("Masivs: "); 
        list.getList();
        System.out.print("-------------------------------------");
    }
    
}
