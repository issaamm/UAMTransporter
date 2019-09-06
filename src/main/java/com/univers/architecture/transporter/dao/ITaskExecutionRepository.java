/**
 * 
 */
package com.univers.architecture.transporter.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.univers.architecture.transporter.model.TaskExecution;

/**
 * @author sabir
 *
 */
public interface ITaskExecutionRepository extends PagingAndSortingRepository<TaskExecution, Long> {
}
