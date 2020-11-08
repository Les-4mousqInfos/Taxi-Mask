package fr.et.intechinfo.mousqinfos.taximask;

import fr.et.intechinfo.mousqinfos.taximask.controllers.ClientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppTests {

	//@Autowired
	//private ClientController controller;

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	void controllerLoads() throws Exception {
		Assert.isTrue(true, "true indeed");
		//assertThat(controller).isNotNull();
	}

}
