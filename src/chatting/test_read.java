package chatting;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class test_read {

    public static void main(String args[]) throws Exception {
        String a="C:\\Users\\Administrator\\IdeaProjects\\instagram\\chatting_data\\65ae42cb8042dfefdc124bfdfb7e5038.txt";
        if(a.length()>0){
            File file = new File(a);
            System.out.println(file.getAbsolutePath());
            if(file.exists() && file.canRead()){
                long fileLength = file.length();
                readFile(file,0L);
                while(true){

                    if(fileLength<file.length()){
                        readFile(file,fileLength);
                        fileLength=file.length();
                    }
                }
            }
        }else{
            System.out.println("no file to read");
        }
    }

    public static void readFile(File file,Long fileLength) throws IOException {
        String line = null;

        BufferedReader in = new BufferedReader(new java.io.FileReader(file));
        in.skip(fileLength);
        while((line = in.readLine()) != null)
        {
            System.out.println(line);
        }
        in.close();
    }
}