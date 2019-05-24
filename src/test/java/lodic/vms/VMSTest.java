package lodic.vms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VMSTest {

    @Test
    public void getListVMS() {
        VMS vms = new VMS();
        List<String> listVMS = vms.getListVMS();

        System.out.println("==========LIST=VMS===========");
        for (String name: listVMS) {
            System.out.println(name);
        }
        System.out.println("=============================");
    }
}