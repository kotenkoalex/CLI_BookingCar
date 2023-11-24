package com.kotenko.cli.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class UserReaderFromFile implements IUserReader {
    @Override
    public List<User> readUsers(File file) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] lines;
            String line;
            while ((line = reader.readLine()) != null) {
                lines = line.split(", ");
                users.add(new User(UUID.fromString(lines[0]), lines[1]));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
        return users;
    }

    @Deprecated
    private static int calculateLinesInFile(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return (int) lines.count();
        } catch (IOException e) {
            System.out.println("Cannot calculate lines in file");
        }
        return 0;
    }
}
