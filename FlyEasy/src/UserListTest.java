import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class UserListTest {
    private UserList users = UserList.getInstance();
	private ArrayList<RegisteredUser> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new RegisteredUser("pirateKing", "Monkey D.", "Luffy", "pirateking@gmail.com", "4434 2343 2343 2345"));
		userList.add(new RegisteredUser("onigiri", "Roronoa", "Zoro", "onigiri@gmail.com", "4454 2353 2323 2365"));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		boolean hasLuffy = users.haveUser("pirateKing");
		assertTrue(hasLuffy);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		boolean hasZoro = users.haveUser("onigiri");
		assertTrue(hasZoro);
	}
	
	@Test
	void testHaveUserInValid() {
		boolean hasSanji = users.haveUser("professionalSimp");
		assertFalse(hasSanji);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null);
		assertFalse(hasNull);
	}
}
