package com.company;

public class StringTask implements Runnable {

    private volatile TaskState state;
    private Thread thread;
    private String result;
    private String taskName;
    private int number;

    public StringTask(String taskName, int number) {
        this.taskName = taskName;
        this.number = number;
        this.state = TaskState.CREATED;
        this.result = "";
    }


    /**
     * Obligatory
     *
     * @return result of task
     */
    public String getResult() {
        return result;
    }

    /**
     * Returns state of current task
     *
     * @return current task state
     */
    public TaskState getState() {
        return state;
    }

    /**
     * Runs a task in external thread
     */
    public void start() {
        if (thread == null) {
            thread = new Thread(this, taskName);
            thread.start();
        }
    }


    /**
     * Obligatory
     */
    public void abort() {
        state = TaskState.ABORTED;
        thread.interrupt();
    }

    /**
     * Obligatory
     *
     * @return isDOne
     */
    public boolean isDone() {
        return state == TaskState.READY || state == TaskState.ABORTED;
    }


    @Override
    public void run() {
        state = TaskState.RUNNING;
        for (int i = 0; i < number && state == TaskState.RUNNING && !thread.isInterrupted(); i++) {
            result += taskName;
        }
        if (state != TaskState.ABORTED) {
            state = TaskState.READY;
        }
    }
}


