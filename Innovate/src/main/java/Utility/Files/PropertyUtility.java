package Utility.Files;

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtility
{
		public String readDatafromPropertyFile(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
		}


}
