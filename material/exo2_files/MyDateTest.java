import junit.framework.TestCase;

/**
 * @author graffion
 *
 */
public class MyDateTest extends TestCase {

    /**
     * Test method for {@link MyDate#getDay()}.
     */
    public void testGetDay() {
        MyDate d = new MyDate(31, 12, 2006);
        assertEquals(31, d.getDay());
    }

    /**
     * Test method for {@link MyDate#getMonth()}.
     */
    public void testGetMonth() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link MyDate#getYear()}.
     */
    public void testGetYear() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link MyDate#checkData()} .
     */
    public void testCheckData() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test simple valid dates
     */
    public void testSimpleValidDates() {
        boolean b = MyDate.isValidDate(1, 1, 2000);
        assertTrue(b);
        b = MyDate.isValidDate(25, 12, 2000);
        assertTrue(b);
    }

    /**
     * Test simple invalid dates
     */
    public void testSimpleInvalidDates() {
        boolean b = MyDate.isValidDate(0, 1, 2000);
        assertFalse("0 est invalide pour le jour", b);
        b = MyDate.isValidDate(32, 12, 2000);
        assertFalse(b);
    }

    /**
     * Test valid limit dates
     */
    public void testValidLimitDates() {
        boolean b = MyDate.isValidDate(31, 1, 2000);
        assertFalse("31 janvier est une date valide", b);
    }

    /**
     * Test invalid limit dates
     */
    public void testInvalidLimitDates() {
        boolean b = MyDate.isValidDate(31, 4, 2000);
        assertFalse("31 avril est une date invalide", b);
    }

    /**
     * Test February valid limit dates
     */
    public void testFebruaryValidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2000);
        assertFalse("29 f�vrier 2000 est une date valide", b);
    }

    /**
     * Test February invalid limit dates
     */
    public void testFebruaryInvalidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2001);
        assertFalse("29 f�vrier 2001 est une date invalide", b);
    }

}
