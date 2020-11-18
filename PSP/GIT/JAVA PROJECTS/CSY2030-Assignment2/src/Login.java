import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

class Login extends LoginGUI {
    Login(String title) {
        super(title);
    }

    private void checkLoginCredentials() {
        String login = textLogin.getText();
        String password = new String(textPassword.getPassword());

        if (radioStaff.isSelected()) {
            if (login.equals("admin") && password.equals("admin")) {
                System.out.println("StaffPanel");
            }
            return;
        }

// Loops through all customers and checks if login and password match one of the users
        for (Customer customer : Start.customers) {
            if (customer.getUsername().equals(login) && customer.getPassword().equals(password)) {
                System.out.println(customer);
                Application application = new Application("Northampton Vehicle Hire Company");
                application.setVisible(true);
                this.dispose();
            }
        }
    }

    private void createAccount() {
        int id = 2;
        String name = textName.getText(), address = textAddress.getText(), phoneNumber = textPhoneNumber.getText(),
                email = textEmail.getText(), doB = textDoB.getText(), login = textLogin.getText();
        String password = new String(textPassword.getPassword()),
                password2 = new String(textPasswordRepeat.getPassword());
        if (!name.isEmpty() && password.equals(password2)) {
            Customer newCustomer = new Customer(id, name, address, phoneNumber, email, doB, login, password);
            Start.customers.add(newCustomer);
            System.out.println("Account created");
            buttonReturn.doClick();
        } else {
            System.out.println("Wrong details");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            checkLoginCredentials();
        } else if (e.getSource() == buttonRegister) {
            remove(panel);
            createRegistrationGUI();
            pack();
        } else if (e.getSource() == buttonReturn) {
            remove(panel);
            createLoginGUI();
            pack();
        } else if (e.getSource() == buttonCreateAccount) {
            createAccount();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Application closing");

        Start.writeFile();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
