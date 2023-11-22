package main.java.com.kotenko.cli.user;

import java.util.List;

public interface IUserReader {
    List<User> readUsers(String path);
}
