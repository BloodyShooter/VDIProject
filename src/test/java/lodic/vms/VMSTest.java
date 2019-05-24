package lodic.vms;

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

    @Test
    public void testStartVM() {
        int status = vms.startVM("xubuntu");

        assertEquals("Машина не запустилась", 1,status);
    }
}