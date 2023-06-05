package main.DPBook.decorator.filesDecorator;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        try{

            InputStream in= new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("file.txt")));
            int c=in.read();
            while (c >= 0){
                System.out.print((char) c);
                c=in.read();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
