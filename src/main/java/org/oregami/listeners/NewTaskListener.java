package org.oregami.listeners;

import com.google.inject.Inject;
import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;
import org.apache.log4j.Logger;
import org.oregami.messages.NewTask;
import org.oregami.messages.ToDoMessage;

public class NewTaskListener {

    @Inject
    public NewTaskListener(MBassador<ToDoMessage> eventBus) {
        eventBus.subscribe(this);
    }

    @Handler
    public void handleNewTask(NewTask task)
    {
        Logger.getLogger(this.getClass()).error("New Task Created: " + task.toString());
    } 
    

}
