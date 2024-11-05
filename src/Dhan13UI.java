import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dhan13UI extends JFrame {
    private MedicinePanel medicinePanel;
    private ConsumablePanel consumablePanel;

    public Dhan13UI() {
        setTitle("Dhan13 Evaluation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel navigationPanel = new JPanel();
        JButton medicineButton = new JButton("Medicine Evaluation");
        JButton consumableButton = new JButton("Consumable Evaluation");

        medicinePanel = new MedicinePanel();
        consumablePanel = new ConsumablePanel();

        navigationPanel.add(medicineButton);
        navigationPanel.add(consumableButton);
        add(navigationPanel, BorderLayout.NORTH);

        medicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(medicinePanel);
            }
        });

        consumableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(consumablePanel);
            }
        });

        add(medicinePanel, BorderLayout.CENTER); // Show medicine panel by default
    }

    private void switchPanel(JPanel panel) {
        remove(medicinePanel);
        remove(consumablePanel);
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dhan13UI frame = new Dhan13UI();
            frame.setVisible(true);
        });
    }
}
