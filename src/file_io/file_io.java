package file_io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.FileWriter;
/**
 *
 * @author tobias
 */
//import java.io.*;

public class file_io {

    public static void main(String[] args) throws IOException {     
            String path_in="/home/tobias/eclipse-workspace/file_io/input.txt";
            String str=r_file_to_string(path_in);
                        
            str=reverseCase(str);
            
            String path_out="/home/tobias/eclipse-workspace/file_io/output.txt";
            w_string_to_file(path_out,str); 
        } 
            
    private static String r_file_to_string(String filePath){
    	StringBuilder contentBuilder= new StringBuilder();
    	try(Stream<String> stream = Files.lines(Paths.get(filePath),StandardCharsets.UTF_8)){
    		stream.forEach(s-> contentBuilder.append(s).append("\n"));
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return contentBuilder.toString();
    }
    
    private static void w_string_to_file(String filename, String input_buffer) {
    	try {
			File file = new File("output.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(input_buffer);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
    private static String reverseCase(String t_str) {
       	int offset = 0, strLen = t_str.length();
    	String str="";
    	while (offset < strLen-1) {
    	  int cur_char = t_str.codePointAt(offset);
    	  offset += Character.charCount(cur_char);
    	   
    	  char c='b';
    	 
    	  if(Character.isUpperCase(t_str.charAt(offset-1))){
    		  c = Character.toLowerCase(t_str.charAt(offset-1));
    	  }
    	  else if (Character.isLowerCase(t_str.charAt(offset-1))) {
              c = Character.toUpperCase(t_str.charAt(offset-1));
          }       
    	 String temp=Character.toString(c);
    	 str+=temp;
    	}
    	str+="\n";
    	return str;
    }
}
