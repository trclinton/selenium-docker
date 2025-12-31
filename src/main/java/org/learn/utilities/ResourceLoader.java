package org.learn.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {

    public static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);

    public static InputStream getResourceAsStream(String resourcePath) throws IOException {
        log.info("Loading resource from path: {}", resourcePath);
        InputStream is = ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (Objects.nonNull(is)) {
            log.info("Resource loaded successfully.");
            return is;
        }
        return Files.newInputStream(Path.of(resourcePath));
    }
}
