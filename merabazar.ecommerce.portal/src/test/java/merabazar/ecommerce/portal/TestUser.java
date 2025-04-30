package merabazar.ecommerce.portal;

import com.learnlogic.ecommerce.merabazar.database.daoImpl.UserDaoImpl;
import com.learnlogic.ecommerce.merabazar.model.Orders;
import com.learnlogic.ecommerce.merabazar.model.Users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestUser {

	@Test
	public void testCreateUser() {
	
			Users users = new Users();
			users.setOrders(new Orders());
			users.setUserAddress1("s");
			users.setUserAddress2("sss");
			users.setUserBillingaddress1("s");
			users.setUserBillingaddress2("sss");
			users.setUserCardType("mastercard");
			users.setUserCity("richardspon");
			users.setUserId(1L);
			users.setUserLname("shah");
			users.setUserFname("jugal");
			UserDaoImpl daoImpl= new UserDaoImpl();
			daoImpl.createUser(users);;
			
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetriveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetriveById() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckDaoConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testHibernateDaoSupport() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateHibernateTemplate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHibernateTemplate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHibernateTemplate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCurrentSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testDaoSupport() {
		fail("Not yet implemented");
	}

	@Test
	public void testAfterPropertiesSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
