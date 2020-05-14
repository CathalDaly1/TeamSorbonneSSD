package RestAPIHandlers.Command;

import java.util.LinkedList;

public class CommandQueue {
    private LinkedList<Command> queue;
    CommandQueue singleInstance = null;

    /**
     * Singleton approach so only one queue
     * @return
     */
    public CommandQueue getInstance(){
        if(singleInstance == null){
            singleInstance = new CommandQueue();
        }

        return singleInstance;
    }

    private CommandQueue() {
        queue = new LinkedList<>();
    }

    public LinkedList<Command> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<Command> queue) {
        this.queue = queue;
    }

//    public void runNextCommand(){
//        queue.pop().execute();
//    }

    public void addToQueue(Command command){
        queue.add(command);
    }

}
