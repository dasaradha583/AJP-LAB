import java.util.Scanner;
import java.io.*;
import java.util.Hashtable;




public class JavaLabSecondProgram {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String,String> hashtable= new Hashtable<String,String>();
        FileInputStream fis = new FileInputStream("hello.txt");
        Scanner fileReader = new Scanner(fis).useDelimiter("    ");
        String dataArray[];
        // String 
        while(fileReader.hasNext()){
            String str = fileReader.nextLine();
            dataArray = str.split("    ");
            // System.out.println(dataArray[1]);
            hashtable.put(dataArray[0],dataArray[1]);
        }
        String key;
        System.out.print("Enter key ; ");
        key = scanner.nextLine();
        System.out.println(hashtable);
        if(hashtable.containsKey(key)){
            System.out.println("value is : "+hashtable.get(key));
        } else {
            System.out.println("Given key is wrong");
        }
        fileReader.close();
        scanner.close();


        
    }
}
