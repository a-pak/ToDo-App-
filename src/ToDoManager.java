import java.util.ArrayList;
import java.util.List;

public class ToDoManager {
    private List<ToDo> todoList;
    public ToDoManager() {
        this.todoList = new ArrayList<>();
    }
    public void addTask(ToDo task){
        todoList.add(task);
    }
    public void updateTask(int id, String name, String desc, boolean state){
        for (ToDo task: todoList){
            if (task.getId() == id){
                task.setName(name);
                task.setDesc(desc);
                task.setState(state);
            }
        }
    }
    public void removeTask(ToDo returnedTask){
        todoList.removeIf(task -> task.getId() == returnedTask.getId());
    }
    public List<ToDo> returnTasks(){
        return todoList;
    }

}
