import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

 
public class Config
{
   Properties configFile;
   
   public Config()
   {
	   configFile = new java.util.Properties();
	   String configFileName = "config.properties";
	   
	   try 
	   {
		   InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
		   
		   if (inputStream != null) 
		   {
			   configFile.load(inputStream);
		   } 
		   else 
		   {
			   throw new FileNotFoundException("Config file " + configFileName + " not found in the classpath");
		   }
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
 
   public String getProperty(String key)
   {
	   String value = this.configFile.getProperty(key);
	   return value;
   }
}