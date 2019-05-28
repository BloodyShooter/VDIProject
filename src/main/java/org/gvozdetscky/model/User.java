package org.gvozdetscky.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private String password;

    private List<VM> vmUserList;

    public User() {
        vmUserList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addVM(VM vm) {
        vmUserList.add(vm);
    }

    public List<VM> getVmUserList() {
        return vmUserList;
    }
}
