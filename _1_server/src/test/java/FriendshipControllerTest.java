import hello.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendshipControllerTest {
    @Autowired
    private FriendshipController friendshipController = new FriendshipController();

    @MockBean
    private FriendshipRepository friendshipRepository = Mockito.mock(FriendshipRepository.class);

    @MockBean
    private FriendRequestRepository friendRequestRepository = Mockito.mock(FriendRequestRepository.class);

    @MockBean
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Before
    public void setUp(){
        friendshipController.setFriendRequestRepository(friendRequestRepository);
        friendshipController.setFriendshipRepository(friendshipRepository);
        friendshipController.setUserRepository(userRepository);
    }

    @Test
    public void getAllFriendsTest(){
        Mockito.when(friendshipRepository.getAllFriends("admin")).thenReturn(Arrays.asList("friend1","friend2"));
        Mockito.when(userRepository.findUserByUsername("friend1")).thenReturn(Arrays.asList(new User("friend1","hash1")));
        Mockito.when(userRepository.findUserByUsername("friend2")).thenReturn(Arrays.asList(new User("friend2","hash2")));
        List<User> list = friendshipController.getAllFriends("admin");
        assertEquals(2,list.size());
    }

    @Test
    public void makeRequestTest(){
        FriendRequest f = new FriendRequest("a","b");
        assertEquals("SENT",friendshipController.makeRequest(f));
    }

}