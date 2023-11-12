import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting ToDo application...");
        ToDoManager manager = new ToDoManager();

        SwingUtilities.invokeLater(() -> new GUI(manager));

        System.out.println("App running...");
    }
}