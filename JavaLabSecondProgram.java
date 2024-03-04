import java.util.Scanner;
import java.io.*;
import java.util.Hashtable;




public class JavaLabSecondProgram {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String,String> hashtable= new Hashtable<String,String>();
        Hashtable<String,String> hashtable1= new Hashtable<String,String>();
        FileInputStream fis = new FileInputStream("hello.txt");
        Scanner fileReader = new Scanner(fis).useDelimiter("    ");
        String dataArray[];
        
        // String 
        while(fileReader.hasNext()){
            String str = fileReader.nextLine();
            dataArray = str.split("    ");
            // System.out.println(dataArray[1]);
            hashtable.put(dataArray[0],dataArray[1]);
            hashtable1.put(dataArray[1],dataArray[0]);
        }
        String key;
        System.out.print("Enter key : ");
        key = scanner.nextLine();
        if(hashtable.containsKey(key)){
            System.out.println("value is : "+hashtable.get(key));
        }else if(hashtable1.containsKey(key)){
            System.out.println("key is : "+hashtable1.get(key));
        }else{
            System.out.println("key or value not present");
        }
        fileReader.close();
        scanner.close();


        
    }
}
