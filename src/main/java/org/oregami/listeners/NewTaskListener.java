package org.oregami.listeners;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.oregami.messages.NewTask;

public class NewTaskListener {

    @Inject
    public NewTaskListener(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void handleNewTask(NewTask task)
    {
        Logger.getLogger(this.getClass()).error("New Task Created: " + task.toString());
    } 
    

}
