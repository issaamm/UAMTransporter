package com.univers.architecture.transporter.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.model.TaskExecutionStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskConfigRepositoryTest {

	@Autowired
	private ITaskExecutionRepository taskExecutionRepository;

	@Test
	public void createTaskExecution() {

		LocalDateTime startldt = LocalDateTime.of(2018, 6, 20, 15, 15, 15);
		Date startDate = Date.from(startldt.atZone(ZoneId.systemDefault()).toInstant());

		LocalDateTime endldt = LocalDateTime.of(2018, 6, 25, 15, 30, 55);
		Date endDate = Date.from(endldt.atZone(ZoneId.systemDefault()).toInstant());

		TaskExecution task1 = new TaskExecution();
		TaskExecution task2 = new TaskExecution();
		TaskExecution task3 = new TaskExecution();
		TaskExecution task4 = new TaskExecution();
		
		
		task1.setTaskConfigName("taskConfigName1");
		task1.setStatus(TaskExecutionStatus.STARTED);
		task1.setTransportedFiles("file1, file2, file3");
		task1.setStartDate(startDate);
		task1.setMessage("long message");
		task1.setEndDate(endDate);

		
		task2.setTaskConfigName("taskConfigName2");
		task2.setStatus(TaskExecutionStatus.STARTED);
		task2.setTransportedFiles("file4, file5, file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message");
		task2.setEndDate(endDate);
		
		task2.setTaskConfigName("taskConfigName3");
		task2.setStatus(TaskExecutionStatus.STARTED);
		task2.setTransportedFiles("fil, file5*, ile6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message ggg");
		task2.setEndDate(endDate);
		
		task2.setTaskConfigName("taskConfigNa4");
		task2.setStatus(TaskExecutionStatus.STARTED);
		task2.setTransportedFiles("file4, e5, file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new mee");
		task2.setEndDate(endDate);
		
		TaskExecution task5 = new TaskExecution();
		task2.setTaskConfigName("tasonfigName5");
		task2.setStatus(TaskExecutionStatus.SUCCESS);
		task2.setTransportedFiles("file4");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message");
		task2.setEndDate(endDate);
		
		
		TaskExecution task6 = new TaskExecution();
		task2.setTaskConfigName("taskConfigName6");
		task2.setStatus(TaskExecutionStatus.ERROR);
		task2.setTransportedFiles("file4,file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam message");
		task2.setEndDate(endDate);
//		
//		
//		TaskExecution task7 = new TaskExecution();
//		task2.setTaskConfigName("taskC");
//		task2.setStatus(TaskExecutionStatus.STARTED);
//		task2.setTransportedFiles("file");
//		task2.setStartDate(startDate);
//		task2.setMessage("issam sage");
//		task2.setEndDate(endDate);
//		
//		TaskExecution task8 = new TaskExecution();
//		task1.setTaskConfigName("Name14");
//		task1.setStatus(TaskExecutionStatus.ERROR);
//		task1.setTransportedFiles("hhhhhh");
//		task1.setStartDate(startDate);
//		task1.setMessage("long message");
//		task1.setEndDate(endDate);
//
//		TaskExecution task9 = new TaskExecution();
//		task2.setTaskConfigName("taskConfigName8");
//		task2.setStatus(TaskExecutionStatus.STARTED);
//		task2.setTransportedFiles("file4, file5, file6");
//		task2.setStartDate(startDate);
//		task2.setMessage("issam new message");
//		task2.setEndDate(endDate);
//		
//		TaskExecution task10 = new TaskExecution();
//		task2.setTaskConfigName("taskConfigName9");
//		task2.setStatus(TaskExecutionStatus.STARTED);
//		task2.setTransportedFiles("file4, file5, file6");
//		task2.setStartDate(startDate);
//		task2.setMessage("issam new message");
//		task2.setEndDate(endDate);
//		
//		TaskExecution task11 = new TaskExecution();
//		task2.setTaskConfigName("taskConfigName10");
//		task2.setStatus(TaskExecutionStatus.STARTED);
//		task2.setTransportedFiles("file4, file5, file6");
//		task2.setStartDate(startDate);
//		task2.setMessage("issam new message");
//		task2.setEndDate(endDate);
//		
		TaskExecution task12 = new TaskExecution();
		task2.setTaskConfigName("taskConfigName11");
		task2.setStatus(TaskExecutionStatus.ERROR);
		task2.setTransportedFiles("file4, file5, file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message");
		task2.setEndDate(endDate);
		
		
		TaskExecution task13 = new TaskExecution();
		task2.setTaskConfigName("taskConfigName12");
		task2.setStatus(TaskExecutionStatus.STARTED);
		task2.setTransportedFiles("file4, file5, file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message");
		task2.setEndDate(endDate);
		
		
		TaskExecution task14 = new TaskExecution();
		task2.setTaskConfigName("taskConfigName13");
		task2.setStatus(TaskExecutionStatus.STARTED);
		task2.setTransportedFiles("file4, file5, file6");
		task2.setStartDate(startDate);
		task2.setMessage("issam new message");
		task2.setEndDate(endDate);
		
		
		List<TaskExecution> liste = new ArrayList<>();
		liste.add(task1);
		liste.add(task2);
		liste.add(task3);
		liste.add(task4);
//		liste.add(task5);
//		liste.add(task6);
//		liste.add(task7);
//		liste.add(task8);
//		liste.add(task9);
//		liste.add(task10);
//		liste.add(task11);
//		liste.add(task12);
//		liste.add(task13);
//		liste.add(task14);


       //this.taskExecutionRepository.deleteAll();
////		this.taskExecutionRepository.saveAll(liste);
		this.taskExecutionRepository.save(task1);
		this.taskExecutionRepository.save(task2);
		this.taskExecutionRepository.save(task3);
		this.taskExecutionRepository.save(task4);
		this.taskExecutionRepository.save(task5);
		this.taskExecutionRepository.save(task6);
		this.taskExecutionRepository.save(task12);
		this.taskExecutionRepository.save(task13);
		this.taskExecutionRepository.save(task14);
		assertTrue(task1.getId() != null);
	}

}
