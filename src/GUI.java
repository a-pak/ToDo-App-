import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JButton addButton, removeButton;
    private JTextField taskField, descField;
    private JList<String> todoList;
    private DefaultListModel<String> listModel;
    private JTable grid;

    private ToDoManager manager;

    public GUI(final ToDoManager manager) {
        this.manager = manager;

        frame = new JFrame("ToDo Application");
        frame.setLayout(new BorderLayout());


        taskField = new JTextField(20);
        descField = new JTextField(20);
        addButton = new JButton("Add task");
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        removeButton = new JButton(("Set done"));


        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(taskField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descField);
        inputPanel.add(addButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(todoList), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = taskField.getText();
                String desc = descField.getText();

                ToDo task = new ToDo(name, desc);
                manager.addTask(task);

                updateTodoList();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.pack();
    }
    private void updateTodoList(){
        listModel.clear();
        for (ToDo task : manager.returnTasks()) {
            listModel.addElement(task.getName() + " - " + task.getDesc());
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeTodo(task);
                }
            });
        }
    }
    private void removeTodo(ToDo task){
        manager.removeTask(task);
    }
}
