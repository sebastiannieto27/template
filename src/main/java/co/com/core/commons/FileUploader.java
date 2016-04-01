package co.com.core.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

public class FileUploader {

	private static final Logger logger = Logger.getLogger(FileUploader.class);
	
	 public static boolean uploadFile(FileUploadEvent event, String path) {  
		 boolean succesful = false;
	        try {
	        	succesful = copyFile(event.getFile().getFileName(), event.getFile().getInputstream(), path);
	        } catch (IOException io) {
	        	logger.error("Throwed IOException [FileUploader.uploadFile]: " +io.getMessage());
	        	succesful = false;
	        } catch (Exception ex) {
	        	logger.error("Throwed IOException [FileUploader.uploadFile]: " +ex.getMessage());
	        	succesful = false;
	        }
	        return succesful;
    } 
	 
	 public static boolean copyFile(String fileName, InputStream in, String path) {
	    	try {
		        OutputStream out = new FileOutputStream(new File(path + normalizeFileName(fileName)));
		        int read = 0;
		        byte[] bytes = new byte[1024];
		        while ((read = in.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		        in.close();
		        out.flush();
		        out.close();
		        return true;
	        } catch (IOException io) {
	        	logger.error("Throwed IOException [FileUploader.copyFile]: " +io.getMessage());
	        	return false;
	        } catch (Exception ex) {
	        	logger.error("Throwed IOException [FileUploader.copyFile]: " +ex.getMessage());
	        	return false;
	        }
    }

	 private static String normalizeFileName(String oldName) {
		 String newName = null;
		 newName = oldName.replace("\\s","_");
		 return newName;
	 }
}
