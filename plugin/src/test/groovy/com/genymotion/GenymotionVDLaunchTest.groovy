package test.groovy.com.genymotion

import main.groovy.com.genymotion.GMTool
import main.groovy.com.genymotion.GenymotionVDLaunch
import org.junit.*

import static org.junit.Assert.*

class GenymotionVDLaunchTest {

    @BeforeClass
    public static void setUpClass() {
        TestTools.init()
        TestTools.setDefaultUser(true)
    }

    @Test
    public void setDeleteWhenFinish() {
        GenymotionVDLaunch vdLaunch = new GenymotionVDLaunch([stopWhenFinish:false, template: TestTools.DEVICES."Nexus10-junit"])
        vdLaunch.deleteWhenFinish = true
        assertTrue("Set Delete is enabled failed", vdLaunch.deleteWhenFinish)
        assertTrue("Device should be stopped when delete is enabled", vdLaunch.stopWhenFinish)
    }

    @Test
    public void setStopWhenFinish() {
        GenymotionVDLaunch vdLaunch = new GenymotionVDLaunch([deleteWhenFinish:true, template: TestTools.DEVICES."Nexus10-junit"])
        vdLaunch.stopWhenFinish = false
        assertFalse("Set Stop disabled failed", vdLaunch.stopWhenFinish)
        assertFalse("Device should be deleted when stop is disabled", vdLaunch.stopWhenFinish)
    }

}