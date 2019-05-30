package org.gvozdetscky.vms.logic;

import org.gvozdetscky.model.VM;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandVBTest {

    private CommandVB commandVB = new CommandVB();

    private VM vm;

    {
        vm = new VM();
        vm.setName("win9");
        vm.setType("Windows10_64");
        vm.setPort("12345");
        vm.setMemory(2048);
    }

    @Test
    public void registrVM() {

        String actual = commandVB.registrVM(vm.getName(), vm.getType());

        final String expected = "VBoxManage createvm --name win9 --ostype Windows10_64 --register";

        final String msg = "Неправильная команда регистрации ВМ";

        assertEquals(msg, expected, actual);
    }

    @Test
    public void createHDD() {

        String actual = commandVB.createHDD(vm.getName());

        final String expected = "vboxmanage createhd --filename C:\\vb\\vb\\test\\win9.vdi --size 35000";

        final String msg = "Неправильная команда создания HDD ВМ";

        assertEquals(msg, expected, actual);

    }

    @Ignore
    @Test
    public void createHDD1() {



    }

    @Test
    public void createSataController() {

        String actual = commandVB.createSataController(vm.getName());

        final String expected = "vboxmanage storagectl win9 --name SATA --add sata";

        final String msg = "Неправильная команда установки SATA контроля ВМ";

        assertEquals(msg, expected, actual);

    }

    @Test
    public void createIdeController() {

        String actual = commandVB.createIdeController(vm.getName());

        final String expected = "vboxmanage storagectl win9 --name ide --add ide";

        final String msg = "Неправильная команда установки IDE контроля ВМ";

        assertEquals(msg, expected, actual);

    }

    @Test
    public void modifyMemoryAndPortAndVRam() {

        String actual = commandVB.modifyMemoryAndPortAndVRam(vm.getName(), Integer.toString(vm.getMemory()), vm.getPort());

        final String expected = "VBoxManage modifyvm win9 --memory 2048 --natpf1 \"rdp,tcp,,12345,,22\" --vram 128";

        final String msg = "Неправильная команда изменения настроек ВМ";

        assertEquals(msg, expected, actual);

    }

    @Test
    public void takeHDD() {

        String actual = commandVB.takeHDD(vm.getName(), vm.getName() + ".vdi");

        final String expected = "vboxmanage storageattach win9 --storagectl SATA --port 0 --device 0 --type hdd --medium C:\\vb\\vb\\test\\win9.vdi";

        final String msg = "Неправильная команда установки HDD";

        assertEquals(msg, expected, actual);

    }

    @Test
    public void takeDVD() {

        String actual = commandVB.takeDVD(vm.getName(), vm.getType());

        final String expected = "vboxmanage storageattach win9 --storagectl ide --port 0 --device 1 --type dvddrive --medium C:\\vb\\os\\Windows10.iso";

        final String msg = "Неправильная команда установки DVD";

        assertEquals(msg, expected, actual);

    }
}