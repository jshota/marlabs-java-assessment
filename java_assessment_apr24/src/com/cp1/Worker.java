package com.cp1;

public class Worker {
	static LimitedQueue<Order> queue = new LimitedQueue<Order>(5);

	public static void main(String[] args) throws InterruptedException {
		int n = 100;
		for (int i = 0; i < n; i++) {
			WorkerThread wt = new WorkerThread(i+1, queue);
			wt.start();
		}
	}
}

class WorkerThread implements Runnable {
	Thread th;
	
	private Integer threadNumberInteger;
	
	WorkerThread(Integer threadNumberInteger, LimitedQueue<Order> queue) {
		this.threadNumberInteger = threadNumberInteger;
	}

	@Override
	public void run() {
		
		// wait for a room in the queue
		while(Worker.queue.isFull()) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// add an order into the queue
		Order order = new Order(threadNumberInteger);
		Worker.queue.add(order);
		
		// fulfilled after a certain time
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Worker.queue.remove(order);
		order.setStateString("FULFILLED");
	}

	public void start() {
		if (th == null) {
			th = new Thread(this, Integer.toString(threadNumberInteger));
			th.start();
		}
	}
}
