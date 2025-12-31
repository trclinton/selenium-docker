package org.learn.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class jsonReader {

    private static final Logger log = LoggerFactory.getLogger(jsonReader.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T>T readJSON(Class<T> type, String jsonFile) {
        String baseDir = System.getProperty("user.dir");
        Path dataPath = Paths.get(
                baseDir,
        //        "src",
        //        "test",
        //        "resources",
                "testData",
                jsonFile
        ).normalize();

        log.info("Reading JSON file from path: {}", dataPath);
        try (InputStream is = Files.newInputStream(dataPath)) {
            return mapper.readValue(is, type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + dataPath, e);
        }
    }
}
