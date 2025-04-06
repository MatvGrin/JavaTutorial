package ua.mgrin;

import lombok.Getter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
@Getter
public class FileEventLogger implements EventLogger{
    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, String.valueOf(event), false);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + filename);
        }
    }

    public void init() throws IOException {
        this.file = new File(filename);

        if (!file.canWrite()) {
            System.out.println("file not exists");
        }
    }

}

