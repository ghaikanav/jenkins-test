package com.kanav.assessment.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.kanav.assessment.fileReader.App;

class AppTest {
	
	App app;

	@Before
	void setUp() throws Exception {
		
		App app = new App();
	}

	
	@Test
	void test() {
		assertEquals("true", "true");
		
	}

}
