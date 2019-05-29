package org.gvozdetscky.servies;

import java.util.List;

public interface LogService {
    void addLog(String log);

    List<String> getLogs();
}
