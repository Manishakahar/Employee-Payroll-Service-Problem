package com.blz.employeepayroll.service;

import com.blz.employeepayroll.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String Play_With_NIO = "TempPlayGround";
    //private Object FileUtils;

    // Check File Exist
    @Test
    public void givenPath_WhenCheckedThenShouldReturnConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        // Delete File and Check File Not Exist
        Path playPath = Paths.get(HOME + "/" + Play_With_NIO);
        if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());

        // Create Directory
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        //Create File
        IntStream.range(1,10).forEach(centre ->{
            Path textFile = Paths.get(playPath +"/text"+centre);
            Assert.assertTrue(Files.notExists(textFile));
            try {Files.createFile(textFile);
            }catch (IOException e){}
            Assert.assertTrue(Files.exists(textFile));
        });
        //List Files, Directories as well as Files With Extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile()&& path.toString().startsWith("text"))
                .forEach(System.out::println);
    }
}
