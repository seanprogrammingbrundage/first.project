import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {

        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("XX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("XL"), 40);
        assertEquals(RomanToDecimal.romanToDecimal("XCVII"), 97);
        assertEquals(RomanToDecimal.romanToDecimal("XXX"), 30);
        assertEquals(RomanToDecimal.romanToDecimal("MCC"), 1200);
        assertEquals(RomanToDecimal.romanToDecimal("CDXVII"), 417);
        assertEquals(RomanToDecimal.romanToDecimal("MX"), 1010);
        assertEquals(RomanToDecimal.romanToDecimal("ICXL"), 141);
        assertEquals(RomanToDecimal.romanToDecimal("IIII"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("IIVI"), 6);
        assertEquals(RomanToDecimal.romanToDecimal("VVICLX"), 171);
        assertEquals(RomanToDecimal.romanToDecimal("ABC"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("portapotty"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XXBII"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XIR"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("IXIXIX"), 33);
        assertNotEquals(RomanToDecimal.romanToDecimal("joe"), 555);
    }
}
