package com.fat_fire_face.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskManagerApplicationTests {

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskController taskController;

	@Test
	void contextLoads() {
	}

	@Test
	void taskServiceIsNotNull(){
		assertNotNull(taskService);
	}

	@Test
	void taskControllerIsNotNull(){
		assertNotNull(taskController);
	}

}
