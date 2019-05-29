package org.gvozdetscky.servies.impl;

import org.gvozdetscky.lodic.vms.VMS;
import org.gvozdetscky.model.VM;
import org.gvozdetscky.servies.VMServies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMServiesImpl implements VMServies {

    private VMS vms = new VMS();

    @Override
    public List<VM> listVMs() {
        List<String> listAllVMS = vms.getListVMS(VMS.ALL);
        List<String> listRunningVMS = vms.getListVMS(VMS.RUNNING);

        List<VM> listVMs = new ArrayList<>();

        listAllVMS.forEach(nameVM -> listVMs.add(new VM(nameVM, listRunningVMS.contains(nameVM) ? "Работает " : "Не работает")));
        return listVMs;
    }

    @Override
    public List<String> listAllVMs() {
        return vms.getListVMS(VMS.ALL);
    }

    @Override
    public List<String> listRunningVMs() {
        return vms.getListVMS(VMS.RUNNING);
    }

    @Override
    public int startVM(String nameVM) {
        return vms.startVM(nameVM);
    }

    @Override
    public int powerOffVM(String nameVM) {
        return vms.powerOffVM(nameVM);
    }

    @Override
    public void connectVM(String name) {
        List<String> listRunningVMS = vms.getListVMS(VMS.RUNNING);

        //TODO Доработать сообщение о том что ВМ не запушена
        if (!listRunningVMS.contains(name)) {
            System.out.println("Машина " + name + " не запушена");
            return;
        }

        VM vm = null;

        vms.connectVM(vm);

    }
}
