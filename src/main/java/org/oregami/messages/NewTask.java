
package org.oregami.messages;

import org.oregami.entities.Task;

public class NewTask implements ToDoMessage {

    private final Task task;

    public NewTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
