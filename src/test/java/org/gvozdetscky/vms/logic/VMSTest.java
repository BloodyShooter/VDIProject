package org.gvozdetscky.vms.logic;

import org.gvozdetscky.model.VM;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VMSTest {

    VMS vms = new VMS();

    @Test
    public void testGetListVMS() {

        List<String> listVMS = vms.getListVMS(VMS.ALL);

        System.out.println("==========LIST=VMS=ALL===========");
        for (String name: listVMS) {
            System.out.println(name);
        }
        System.out.println("=================================\n");

        assertNotNull("Не получили список ВМ", listVMS);

        listVMS = vms.getListVMS(VMS.RUNNING);

        System.out.println("==========LIST=VMS=RUNNING+======");
        for (String name: listVMS) {
            System.out.println(name);
        }
        System.out.println("=================================");
    }

    @Ignore
    @Test
    public void testStartVM() {
        int status = vms.startVM("xubuntu");

        assertEquals("Машина не запустилась", 1,status);
    }

    @Test
    public void testCreateVM() {

        VM vm = new VM();
        vm.setName("ubuntu1604");
        vm.setType("Ubuntu_64");
        vm.setMemory(2048);
        vm.setPort("12345");

        vms.createAndConfigVM(vm);
    }
}