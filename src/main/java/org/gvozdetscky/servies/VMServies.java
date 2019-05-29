package org.gvozdetscky.servies;

import org.gvozdetscky.model.VM;

import java.util.List;

public interface VMServies {

    List<VM> listVMs();

    List<String> listAllVMs();

    List<String> listRunningVMs();

    int startVM(String nameVM);

    int powerOffVM(String nameVM);

    void connectVM(String name);

    int createVM(VM vm);
}
