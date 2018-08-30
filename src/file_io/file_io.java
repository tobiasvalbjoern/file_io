package file_io;

/**
 *
 * @author tobias
 */
import java.io.*;

public class file_io {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            
            //true means appending. If you want to overwrite
            //remove the second argument.  
            out = new FileOutputStream("output.txt",true);
            reverseCase(in,out);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    private static void reverseCase(FileInputStream t_in, FileOutputStream t_out) throws IOException {
    	int c;
        
        while ((c = t_in.read()) != -1) {
        	if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }       
        t_out.write(c);
        
        }
    }
}

