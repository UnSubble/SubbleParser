package com.unsubble.util;

import com.unsubble.exceptions.InvalidFileExtensionException;
import com.unsubble.exceptions.UnreadableFileException;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

@UtilityClass
public class FileUtil {
    public static void checkPath(Path path) throws NoSuchFileException {
        if (Files.notExists(path))
            throw new NoSuchFileException(path.toAbsolutePath().toString());
        if (!Files.isReadable(path))
            throw new UnreadableFileException("File has no read permission.");
        if (!path.getFileName().toString().endsWith(".xml")) {
            String targetFileName = path.getFileName().toString();
            int extensionIndex = targetFileName.lastIndexOf(".") + 1;
            throw new InvalidFileExtensionException("xml", targetFileName.substring(extensionIndex));
        }
    }
}
