package test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mvc.manager.aquarium.AquariumManagerImpl;
import mvc.service.aquarium.AquariumServiceImpl;

public class MockTest {

	@Mock
	// this is creating fake data in for the service so i dont need data from db
	AquariumServiceImpl aqImpl;

	@InjectMocks
	// will inject the mocks marked ith @Mark to this instance when it is created
	// this is what I am going to test because it has most logic
	AquariumManagerImpl aqMan;

	@Test
	public void f() {
		System.out.println("MOCKITO TEST TIME");
	}

	@BeforeTest
	public void beforeTest() {
		// these instances are created here
		MockitoAnnotations.initMocks(this);
	}

	@AfterTest
	public void afterTest() {
	}

}
//We want to test the layer that has more business logic. (Manager)
//We are testing the MANAGER layer, the manager layer calls the service layer. That creates a problem for us
//Because it  can just keep on going down and we dont want that. We want to run a unit test on the functions in the manager
//layer.

//To do that, we do something called MOCKING. What that is, we are gonna mock the service layer. So any calls the manager
//layer makes to the service layer will be mocked.

//The layer that is not mocked and the one we are testing is the MANAGER layer for that one because of .... autowired stuff
//We inject

//FRONT END = SELENIUM
//BACK END = MOCKITO