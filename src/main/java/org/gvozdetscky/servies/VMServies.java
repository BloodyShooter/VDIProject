package org.gvozdetscky.servies;

import java.util.List;

public interface VMServies {

    List<String> listAllVMs();

    List<String> listRunningVMs();

    int startVM(String nameVM);

    int powerOffVM(String nameVM);
}
