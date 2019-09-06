/**
 * 
 */
package com.univers.architecture.transporter.web;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.service.ITaskExecutionService;

/**
 * @author sabir
 *
 */
@RestController
@RequestMapping("/api")
public class TaskExecutionController {

	@Autowired
	private ITaskExecutionService taskExecutionService;

	@GetMapping("/taskExecution")
	@CrossOrigin(origins = "http://localhost:3000")
	public Page<TaskExecution> getAllTaskExecutions(@RequestParam Optional<Integer> page,
			                                         @RequestParam Optional<Integer> size) {
		Pageable pgRequest = PageRequest.of(page.orElse(0),size.orElse(3));
		return this.taskExecutionService.getAllTaskExecution(pgRequest);
	}
}
