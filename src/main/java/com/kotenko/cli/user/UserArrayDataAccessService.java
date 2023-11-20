package main.java.com.kotenko.cli.user;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

public class UserArrayDataAccessService implements UserDao {
    private static final User[] users;
    private final static String PATH = "src/resources/users.csv";

    static {
        users = readUsersFromFile();
    }

    private static User[] readUsersFromFile() {
        User[] users = new User[calculateLinesInFile()];
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String[] lines;
            for (int i = 0; i < users.length; i++) {
                lines = reader.readLine().split(", ");
                users[i] = new User(UUID.fromString(lines[0]), lines[1]);
            }
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
        return users;
    }

    private static int calculateLinesInFile() {
        try (Stream<String> lines = Files.lines(Paths.get(PATH))) {
            return (int) lines.count();
        } catch (IOException e) {
            System.out.println("Cannot calculate lines in file");
        }
        return 0;
    }

    @Override
    public User[] getUsers() {
        return users;
    }
}
