package com.kanav.assessment.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
