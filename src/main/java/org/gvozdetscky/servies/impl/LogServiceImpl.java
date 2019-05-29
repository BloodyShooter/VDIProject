package org.gvozdetscky.servies.impl;

import org.gvozdetscky.servies.LogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private List<String> logs = new ArrayList<>();

    private final int startIndex = 0;

    @Override
    public void addLog(String log) {
        logs.add(startIndex ,log);
    }

    @Override
    public List<String> getLogs() {
        return logs;
    }
}
