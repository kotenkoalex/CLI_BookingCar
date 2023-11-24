package com.kotenko.cli.user;

import java.io.File;
import java.util.List;

public interface IUserReader {
    List<User> readUsers(File file);
}
