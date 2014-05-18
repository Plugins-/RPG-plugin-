package two.HDMinecraftnerd.Deepstream.rpg.economy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PluginProperties extends Properties{
	private static final long serialVersionUID = 0L;
	
	private String fileName;
	
	public PluginProperties(String file){
		this.fileName = file;
	}
	
	public void load(){
		File file = new File(fileName);
		if(file.exists()){
			try{
				load(new FileInputStream(fileName));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public void save(String start, String file) {
		try{
			store(new FileOutputStream(file), start);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public int getInteger(String key, int value) {
		if(containsKey(key)){
			return Integer.parseInt(getProperty(key));
		}
		put(key, "" + value);
		return value;
	}

	public String getString(String key, String value) {
		if(containsKey(key)){
			return getProperty(key);
		}
		put(key, value);
		return value;
	}
	
	public boolean getBoolean(String key, boolean value){
		if(containsKey(key)){
			return Boolean.getBoolean(getProperty(key));
		}
		return value;
	}
	
}
