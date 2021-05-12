package module1;

import java.io.File;

public class Util {
    public static File getFileFromProject(String filePath) {
        return new File(System.getProperty("user.dir")+File.separator+filePath);
    }

    public static File getFileFromResources(String fileName) {
        return getFileFromProject("src/main/resources/" + fileName);
    }
}
