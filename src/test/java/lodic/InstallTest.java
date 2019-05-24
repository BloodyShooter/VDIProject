package lodic;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstallTest {
    @Test
    public void testInstall() {
        Install i = new Install();

        i.run("VBoxManage list vms");
    }
}