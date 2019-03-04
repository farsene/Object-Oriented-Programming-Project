import client.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user1;

    @Before

    public void setUp() {
        user1 = new User("Flo", "abc");
    }

    @Test
    public void constrTest() {
        assertEquals(true, user1 != null);
    }

    @Test
    public void getSetTest() {
        assertEquals("Flo", user1.getUsername());
        assertEquals("abc", user1.getHash());
        user1.setUsername("username");
        user1.setHash("hash");
        assertEquals("username", user1.getUsername());
        assertEquals("hash", user1.getHash());
    }

    @Test
    public void toStringTest() {
        assertTrue(user1.toString().contains(user1.getUsername()));
        assertTrue(user1.toString().contains(user1.getHash()));
    }
}
