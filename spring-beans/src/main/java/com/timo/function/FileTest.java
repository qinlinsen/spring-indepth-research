package com.timo.function;

import org.springframework.util.Assert;

import java.io.File;
import java.util.ArrayList;

/**
 * @author qinlinsen
 */
public class FileTest {
    private static final String FILE_NAME = "D:\\cloudwalk\\IBIS3.0\\src\\main\\resources\\cn\\cloudwalk\\mapper";

    private static void countFileNumber(String directoryPath, String fileExtensiveName) {
        ArrayList<File> filesWithSpecialExtensiveName = new ArrayList<File>();
        ArrayList<File> filesWithoutSpecialExtensiveName = new ArrayList<File>();
        Assert.notNull(directoryPath, "file is required");
        Assert.notNull(fileExtensiveName, "file extensive name is required");
        File file = new File(directoryPath);
        Assert.state(file.isDirectory(), "This require is directory rather than file,please check you input");
		//get all files of this directory
		File[] files = file.listFiles();
		for (File f : files) {
			if(f.isDirectory()){
				continue;
			}
			if (f.isFile()) {
				//only ends with special extensive name can add to filesWithSpecialExtensiveName
				String fileName = f.getName();
				if (fileName.endsWith(fileExtensiveName)) {
					filesWithSpecialExtensiveName.add(f);
				} else {
					filesWithoutSpecialExtensiveName.add(f);
				}
			}
		}
        System.out.println("the total number of file with " + fileExtensiveName
                + " is " + filesWithSpecialExtensiveName.size() +
                " without the " + fileExtensiveName + " the count number is : "
                + filesWithoutSpecialExtensiveName.size());
    }


    public static void main(String[] args) {

        countFileNumber("D:\\cloudwalk\\IBIS3.0\\src\\main\\resources\\com\\cloudwalk\\common",".xml");

    }
}
