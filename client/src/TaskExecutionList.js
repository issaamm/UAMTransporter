import React, { Component } from 'react';
import { Button } from 'reactstrap';
import AppNavbar from './AppNavbar';
import styles from './App.css';
class TaskExecutionList extends Component {

	constructor(props){
		super(props);
		this.state = { taskExecutions : null,
		               total : null,
		               per_page : null,
	                   current_page : 0
	                   };
		this.intervalID = 0;
	}

	componentDidMount() {
	    this.makeHttpRequestWithPage(0,4);
	  }
		
	componentWillUnmount(){
		clearTimeout(this.intervalID);
	}
	
	makeHttpRequestWithPage = async (pageNumber,sizePerPage) => {
		if(sizePerPage <= 0){
			sizePerPage = this.state.per_page;
		}

		
		fetch(`http://localhost:8080/api/taskExecution?page=${pageNumber}&size=${sizePerPage}`)
		       .then(response => response.json())
		       .then(data => {
		    	   this.setState({taskExecutions : data,
			                      total : data.totalPages,
			                      per_page : data.size,
			                      current_page : data.number});
		    	  this.intervalID = setTimeout(() => this.makeHttpRequestWithPage(this.state.current_page,this.sizeValue.value),this.timeToRefresh.value);
		       });
		
	}
	
	render(){
		
		let taskExecutions,renderPageNumbers;
		
		if(this.state.taskExecutions !== null){
			
			taskExecutions = this.state.taskExecutions.content.map(task => (
				<tr key={task.id}>
		          <td>{task.taskConfigName}00</td>
		          <td>{task.durationInSeconds}</td>
		          <td>{task.status}</td>
		          <td>{task.message}</td>
		          <td>{task.transportedFiles}</td>
		        </tr>
		      ));
			
		}
		
		const pageNumbers = [];
	    if (this.state.total !== null) {
	      for (let i = 0; i < Math.ceil(this.state.total); i++) {
	        pageNumbers.push(i);
	      }
		
	      renderPageNumbers = pageNumbers.map(number => {
	    	//  let classes = this.state.current_page === number ? styles.active : '';

	    	  if (number === 0 || number === this.state.total || (number >= this.state.current_page - 2 && number <= this.state.current_page + 2)) {
	    	    return (
	    	      <Button key={number} onClick={() => this.makeHttpRequestWithPage(number,this.sizeValue.value)}>{number}</Button>
	    	    );
	    	  }
	    	});
		
	}
	    
	    return (

	    		
	    	      <div className={styles.app}>
	    	      <AppNavbar/>
	    	      <label>put the number of records to display per page  </label>
	    	      <input type = "text" class = "input-text" ref = { rel => this.sizeValue = rel} />
	    	      <Button  onClick={() => this.makeHttpRequestWithPage(0,this.sizeValue.value)}>Display</Button><br></br>
	    	      <label>put the interval of Time to refresh data  periodically </label>
	    	      <input type = "text" defaultValue="10000" class = "input-text" ref = { rel => this.timeToRefresh = rel} />
	    	      <Button  onClick={() => this.makeHttpRequestWithPage(0,this.sizeValue.value)}>Refresh</Button>
	    	      
	    	        <table className={styles.table}>
	    	          <thead>
	    	            <tr>
	    	              <th>taskEtaskConfigName</th>
	    	              <th>durationInSeconds</th>
	    	              <th>status</th>
	    	              <th>message</th>
	    	              <th>transportedFiles</th>
	    	            </tr>
	    	          </thead>
	    	          <tbody>
	    	            {taskExecutions}
	    	          </tbody>
	    	        </table>


	    	        <div>
	    	          <Button onClick={() => this.makeHttpRequestWithPage(((this.state.current_page > 0) ? (this.state.current_page-1) : this.state.current_page  ),this.sizeValue.value)}>&laquo;</Button>
	    	          {renderPageNumbers}
	    	          <Button onClick={() => this.makeHttpRequestWithPage(((this.state.current_page < this.state.taskExecutions.totalPages - 1) ? (this.state.current_page + 1) : this.state.current_page),this.sizeValue.value )}>&raquo;</Button>
	    	        </div>
	    	      </div>
	    	    );
}
	
}

export default TaskExecutionList;