package com.kotenko.user;

import java.io.File;
import java.util.List;

public interface IUserReader {
    List<User> readUsers(File file);
}
