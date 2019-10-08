import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User{
	String field,value;
	
	public void changeSettings(String field,String value) {
		try {
            FileWriter writer = new FileWriter(field, true);
            writer.write(value);
            //writer.write("\r\n");   // write new line
            //writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
