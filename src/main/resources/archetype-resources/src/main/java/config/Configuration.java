package ${package}.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.util.text.AES256TextEncryptor;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

public class Configuration {
	private static Configuration instance = null;
	private static Object syncObject = new Object();
	private final static String configurationFile = "config.yaml";
	private final static Logger logger = LogManager.getLogger(Configuration.class.getName());
	private AES256TextEncryptor encryptor = new AES256TextEncryptor();
	private String password;

    private Configuration() {
    	encryptor.setPassword(getJasyptPassword());
    }
	
    public static Configuration getInstance() {
        synchronized(syncObject) {
            if (instance == null) {
            	try {
            	Yaml yaml = new Yaml(new Constructor(Configuration.class));
            	InputStream is = Configuration.class.getClassLoader().getResourceAsStream(configurationFile);
            	
                instance = yaml.load(is);
            	} catch (YAMLException e) {
					logger.fatal("Unable to load the configuration", e);
				}
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = encryptor.decrypt(password);
	}
	
	private String getJasyptPassword() {
	    String filePath = String.format("%s/.nibr/jasypt_pw", System.getProperty("user.home"));
	    String output = null;
	    
	    try (Scanner scanner = new Scanner(new File(filePath))){
	    	output = scanner.next();
	    } catch (IOException e) {
	    	logger.fatal("Could not load Jasypt password", e);
	    }
	    return output;
	}
}