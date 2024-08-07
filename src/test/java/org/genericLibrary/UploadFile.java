package org.genericLibrary;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class UploadFile {

	private static File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        // Get the latest file based on last modified time
        return Arrays.stream(files)
                .filter(File::isFile)
                .max(Comparator.comparing(File::lastModified))
                .orElse(null);
    }
}
