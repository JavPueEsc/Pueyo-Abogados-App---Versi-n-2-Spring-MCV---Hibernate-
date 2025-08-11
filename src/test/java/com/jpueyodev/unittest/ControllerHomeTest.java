package com.jpueyodev.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.jpueyodev.controllers.Controller_Home;

public class ControllerHomeTest {

	@Test
	void showHomeWeb_returnsHome() {
		
		Controller_Home controller = new Controller_Home();
		
		String viewName = controller.showHomeWeb();
		assertEquals("home",viewName,"El controlador Home debe devolver la vista 'home'");
	}
}

