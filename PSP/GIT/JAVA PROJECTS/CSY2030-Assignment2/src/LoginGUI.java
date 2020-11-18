import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

abstract class LoginGUI extends JFrame implements ActionListener, WindowListener {
    JPanel panel;

    //Login fields
    JRadioButton radioClient, radioStaff;
    JTextField textLogin;
    JPasswordField textPassword;
    JButton buttonLogin, buttonRegister, buttonReturn, buttonCreateAccount;

    //Registration fields
    JTextField textName, textAddress, textPhoneNumber, textEmail, textDoB;
    JPasswordField textPasswordRepeat;

    LoginGUI(String title) {
        super(title);

        getContentPane();
        setLayout(new FlowLayout());
        setSize(new Dimension(400, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        createLoginGUI();
        pack();
        setVisible(true);
        addWindowListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void createLoginGUI() {
        createPanel();
        createRadioButtons();
        createLoginInput();
        createButtons();
    }

    void createRegistrationGUI() {
        createPanel();

        JLabel labelRegister = new JLabel("Register new customer:", SwingConstants.CENTER);
        labelRegister.setPreferredSize(new Dimension(400, 30));

        panel.add(labelRegister);

        JLabel labelLogin = new JLabel("Username:");
        labelLogin.setPreferredSize(new Dimension(190, 30));
        panel.add(labelLogin);

        textLogin = new JTextField();
        textLogin.setPreferredSize(new Dimension(190, 30));
        panel.add(textLogin);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setPreferredSize(new Dimension(190, 30));
        panel.add(textPassword);

        JLabel labelPasswordRepeat = new JLabel("Repeat password");
        labelPasswordRepeat.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPasswordRepeat);

        textPasswordRepeat = new JPasswordField();
        textPasswordRepeat.setPreferredSize(new Dimension(190, 30));
        panel.add(textPasswordRepeat);

        JLabel labelName = new JLabel("Firstname & Surname:");
        labelName.setPreferredSize(new Dimension(190, 30));
        panel.add(labelName);

        textName = new JTextField();
        textName.setPreferredSize(new Dimension(190, 30));
        panel.add(textName);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setPreferredSize(new Dimension(190, 30));
        panel.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setPreferredSize(new Dimension(190, 30));
        panel.add(textAddress);

        JLabel labelPhoneNumber = new JLabel("Phone number:");
        labelPhoneNumber.setPreferredSize(new Dimension(190, 30));
        panel.add(labelPhoneNumber);

        textPhoneNumber = new JTextField();
        textPhoneNumber.setPreferredSize(new Dimension(190, 30));
        panel.add(textPhoneNumber);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setPreferredSize(new Dimension(190, 30));
        panel.add(labelEmail);

        textEmail = new JTextField();
        textEmail.setPreferredSize(new Dimension(190, 30));
        panel.add(textEmail);

        JLabel labelDoB = new JLabel("Date of Birth:");
        labelDoB.setPreferredSize(new Dimension(190, 30));
        panel.add(labelDoB);

        textDoB = new JTextField();
        textDoB.setPreferredSize(new Dimension(190, 30));
        panel.add(textDoB);

        buttonReturn = new JButton("Return");
        buttonReturn.addActionListener(this);
        panel.add(buttonReturn);

        buttonCreateAccount = new JButton("Create account");
        buttonCreateAccount.addActionListener(this);
        panel.add(buttonCreateAccount);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(400, 500));
        panel.setBackground(Color.YELLOW);
        add(panel);
    }

    private void createRadioButtons() {
        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new FlowLayout());
        panelRadio.setPreferredSize(new Dimension(400, 50));

        radioClient = new JRadioButton("Client", true);
        panelRadio.add(radioClient);

        radioStaff = new JRadioButton("Staff");
        panelRadio.add(radioStaff);

        ButtonGroup groupType = new ButtonGroup();
        groupType.add(radioClient);
        groupType.add(radioStaff);

        panel.add(panelRadio);
    }

    private void createLoginInput() {
        JLabel labelLogin = new JLabel("Login:");
        panel.add(labelLogin);

        textLogin = new JTextField("admin");
        textLogin.setPreferredSize(new Dimension(100, 30));
        panel.add(textLogin);

        JLabel labelPassword = new JLabel("Password:");
        panel.add(labelPassword);

        textPassword = new JPasswordField("bob");
        textPassword.setPreferredSize(new Dimension(100, 30));
        panel.add(textPassword);
    }

    private void createButtons() {
        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(this);
        panel.add(buttonLogin);

        buttonRegister = new JButton("Register");
        buttonRegister.addActionListener(this);
        panel.add(buttonRegister);
    }
}
