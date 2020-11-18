import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class ApplicationGUI extends JFrame implements ActionListener {
    JButton buttonHire, buttonReturn;

    ApplicationGUI(String title) throws HeadlessException {
        super(title);

        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.createGUI();
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createGUI() {
        JPanel panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(700, 600));
        panelMain.setBackground(Color.BLUE);
        add(panelMain, BorderLayout.CENTER);

        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(300, 600));
        panelRight.setBackground(Color.RED);
        add(panelRight, BorderLayout.EAST);

        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(1000, 200));
        panelBottom.setBackground(Color.GREEN);
        add(panelBottom, BorderLayout.SOUTH);

        createTable();

        buttonHire = new JButton("Hire vehicles");
        panelRight.add(buttonHire);

        buttonReturn = new JButton("Return Vehicles");
        panelRight.add(buttonReturn);
    }

    private void createTable() {
        final Object[][] vehicles = {
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
                {"Tesla", 5, true},
        };

        final String[] headings = {"Model", "Daily hire rate", "Hired"};

        JTable vehicleTable = new JTable(vehicles, headings);

        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        add(scrollPane);
    }
}
