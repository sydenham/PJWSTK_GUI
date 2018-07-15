package zad2;


public class StringTask implements Runnable {
	
	volatile TaskState state;
	String result = "";
	String word;
	int multiply;
	Thread th;
	
	
	enum TaskState {CREATED, RUNNING, ABORTED, READY};
	
	
	 public StringTask(String word, int multiply){
		this.word = word;
		this.multiply = multiply;
		this.state = TaskState.CREATED;
	}

	
	public TaskState getState(){
		return state;
	}
	
	public String getResult(){
		return result;
	}
	
	public boolean isDone(){
		if(state == TaskState.READY || state == TaskState.ABORTED ){
			return true;
		}else
			return false;
	}
	
	
	public void run(){
		int i = 0;
		while(true){
			if (Thread.interrupted()) return;
			if(i < multiply){
				result = result + word;
				i++;
		}else{
			state = TaskState.READY;
			return;
		}
		}
	}
	
	public void abort(){
		th.interrupt();
		state = TaskState.ABORTED;
	}
	
	
	public void start(){
		th = new Thread(this);
		th.start();
		this.state = TaskState.RUNNING;	
	}
	

}
