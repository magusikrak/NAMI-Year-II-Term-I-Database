import java.awt.*;
import java.awt.Event;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.sun.xml.internal.stream.StaxXMLInputSource;

public class joecheckbox {

    private JFrame mainframe; // Windows
    private JLabel headerLabel; // Top row
    private JPanel controlPanel; // Middle Row
    private JLabel statusLabel; // Bottom row

    public joecheckbox() {
        prepareGui(); // Call the prepare gui method
    }

    public static void main(String[] args) { // run application
        joecheckbox checkbox = new joecheckbox();
        checkbox.showWindow();
    }

    private void prepareGui() {
        mainframe = new JFrame("Joe's mechanics"); // Title
        mainframe.setSize(400, 400); // Set the window size
        mainframe.setLayout(new GridLayout(3, 1)); // Aplication layout 3 rows 1 column

        // Make application recieve window events

        mainframe.addWindowListener(new WindowAdapter() {
        });

        headerLabel = new JLabel("", JLabel.CENTER); // Top row setup

        statusLabel = new JLabel("", JLabel.CENTER); // Bottom row setup
        statusLabel.setSize(350, 100); // Gives size to bottom row

        controlPanel = new JPanel(); // Middle row setup
        controlPanel.setLayout(new FlowLayout()); // Middle row flow left to right

        mainframe.add(headerLabel); // Add top row
        mainframe.add(controlPanel); // Add middle row
        mainframe.add(statusLabel); // Add bottom row
        mainframe.setVisible(true); // Display rows
    }

    private void showWindow() {

        headerLabel.setText("Joe's Mechanics"); // Print in the top row

        final JCheckBox chkOil = new JCheckBox("Oil change"); // Check box labeled Oil change

        final JCheckBox chkLube = new JCheckBox("Lube Job"); // Check box labeled Lube Job
        final JCheckBox chkRad = new JCheckBox("Radiator flush"); // Checkbox labeled Radiator flush
        final JCheckBox chkTran = new JCheckBox("Transmission flush"); // Check box labeled Transmission flush
        final JCheckBox chkInspec = new JCheckBox("Inspection"); // Check box labeled Inspection
        final JCheckBox chkMuffler = new JCheckBox("Muffler Replacement"); // Check box labeled Muffler Replacement
        final JCheckBox chkTire = new JCheckBox("Tire rotation"); // Check box labeled Tire rotation
        final JCheckBox chkmisc = new JCheckBox("Misc job"); // Check box labeled Misc job

        ItemListener oilItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Oilchange checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener lubItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Lube Job checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener radItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Radiator checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener transItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Transmission checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener inspecItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("instpection checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener mufflerItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Muffler checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener tItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Tire checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        ItemListener miscItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                statusLabel.setText("Misc checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));

            }
        };
        chkOil.addItemListener(oilItemListener);
        controlPanel.add(chkOil);

        chkLube.addItemListener(lubItemListener);
        controlPanel.add(chkLube);

        chkRad.addItemListener(radItemListener);
        controlPanel.add(chkRad);

        chkTran.addItemListener(transItemListener);
        controlPanel.add(chkTran);

        chkInspec.addItemListener(inspecItemListener);
        controlPanel.add(chkInspec);

        chkMuffler.addItemListener(mufflerItemListener);
        controlPanel.add(chkMuffler);

        chkTire.addItemListener(tItemListener);
        controlPanel.add(chkTire);

        chkmisc.addItemListener(miscItemListener);
        controlPanel.add(chkmisc);

        mainframe.setVisible(true);
    }
}
