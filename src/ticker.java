import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ticker {
    private JRadioButton firstClassRadioButton;
    private JRadioButton economyRadioButton;
    private JRadioButton singleRadioButton;
    private JRadioButton returnRadioButton;
    private JRadioButton yesAdultRadioButton1;
    private JRadioButton yesChildRadioButton;
    private JRadioButton standardRadioButton;
    private JComboBox comboToBox;
    private JComboBox comboFromBox;
    private JButton resetButton;
    private JButton exitButton;
    private JButton totalButton;
    private JTextField routeDisplay;
    private JTextField textTicketDisplay;
    private JTextField priceDisplay;
    private JPanel main;
    private JTextField subTotal;
    private JTextField taxDisplay;
    private JTextField totalDisplay;
    private JTextField displayClassType;
    private JTextField ticketTypeDisplay;
    private JTextField textAdult;
    private JTextField textChild;
    private JTextField fromTextDisplay;
    private JTextField toTextDisplay;
    private JTextField dateDisplay;
    private JTextField timeDisplay;

    String place1;
    String place2;



    public static void main(String[] args) {
        JFrame frame = new JFrame("BusTicketingSystem");
        frame.setContentPane(new ticker().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ticker() {
        firstClassRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstClassRadioButton.isSelected()){
                    economyRadioButton.setSelected(false);
                    standardRadioButton.setSelected(false);
                }
            }
        });
        economyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(economyRadioButton.isSelected()){
                    firstClassRadioButton.setSelected(false);
                    standardRadioButton.setSelected(false);
                }
            }
        });
        standardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(standardRadioButton.isSelected()){
                    firstClassRadioButton.setSelected(false);
                    economyRadioButton.setSelected(false);
                }
            }
        });
        singleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(singleRadioButton.isSelected()){
                    returnRadioButton.setSelected(false);
                }
            }
        });
        returnRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(returnRadioButton.isSelected()){
                    singleRadioButton.setSelected(false);
                }
            }
        });
        yesAdultRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(yesAdultRadioButton1.isSelected()){
                    yesChildRadioButton.setSelected(false);

                }
                if (firstClassRadioButton.isSelected() && singleRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    // for clear the display value
                    subTotal.setText("");
                    taxDisplay.setText("");
                    totalDisplay.setText("");
                }

            }
        });
        yesChildRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(yesChildRadioButton.isSelected()){
                    yesAdultRadioButton1.setSelected(false);
                }
                if (firstClassRadioButton.isSelected() && singleRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    // for clear the display value
                    subTotal.setText("");
                    taxDisplay.setText("");
                    totalDisplay.setText("");
                }
            }
        });


        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                place1 = comboFromBox.getSelectedItem().toString();
                place2 = comboToBox.getSelectedItem().toString();


                int price = 0;
                int subPrice = 0;
                int tax = 0;
                int totalPrice = 0;
                String classType = null;
                String ticketType = null;
                boolean conditionCheck = false;
                String child = null;
                String adult = null;
                String route = null;


                int num1;
                String p1 = "";
                num1 = 1204 + (int) (Math.random())*37523;
                p1 += num1 + 1504;



                // First Class, Single Ticket , For Adult
                if (firstClassRadioButton.isSelected() && singleRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }

                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 800;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 900;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1300;
                        subPrice = price;
                        tax = 40;
                        totalPrice = price + tax;
                        route = "LHN -PKR ";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1300;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 800;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 700;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 900;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // First Class , Single Ticket , For Child
                if (firstClassRadioButton.isSelected() && singleRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                        firstClassRadioButton.setSelected(false);
                        economyRadioButton.setSelected(false);
                        standardRadioButton.setSelected(false);
                        singleRadioButton.setSelected(false);
                        returnRadioButton.setSelected(false);
                        yesAdultRadioButton1.setSelected(false);
                        yesChildRadioButton.setSelected(false);
                        subTotal.setText("");
                        totalDisplay.setText("");
                        taxDisplay.setText("");
                        displayClassType.setText("");
                        ticketTypeDisplay.setText("");
                        textChild.setText("");
                        textAdult.setText("");
                        fromTextDisplay.setText("");
                        toTextDisplay.setText("");
                        dateDisplay.setText("");
                        timeDisplay.setText("");
                        textTicketDisplay.setText("");
                        priceDisplay.setText("");
                        routeDisplay.setText("");
                        comboFromBox.setSelectedItem(String.valueOf("Kathmandu"));
                        comboToBox.setSelectedItem(String.valueOf("Lahan"));

                        ///
                        subTotal.setText(String.valueOf(subPrice));
                        taxDisplay.setText(String.valueOf(tax));
                        totalDisplay.setText(String.valueOf(totalPrice));
                        displayClassType.setText(classType);
                        ticketTypeDisplay.setText(ticketType);
                        textAdult.setText(adult);
                        textChild.setText(child);

                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 700;
                        subPrice = price;
                        tax = 20;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 600;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1000;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 700;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1000;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 900;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 600;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 900;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 700;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // First Class, Return Ticket , For Adult
                if (firstClassRadioButton.isSelected() && returnRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 1900;
                        subPrice = price;
                        tax = 60;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 1500;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 1700;
                        subPrice = price;
                        tax = 40;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 2500;
                        subPrice = price;
                        tax = 80;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 1300;
                        subPrice = price;
                        tax = 80;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 1900;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 2500;
                        subPrice = price;
                        tax = 80;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 1900;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 1500;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 1300;
                        subPrice = price;
                        tax = 80;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 1900;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 1700;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // First Class , Return Ticket , For Child
                if (firstClassRadioButton.isSelected() && returnRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 1300;
                        subPrice = price;
                        tax = 40;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 600;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM -JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1000;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 700;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1000;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 900;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 600;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 900;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 700;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Economy Class, Single Ticket , For Adult
                if (economyRadioButton.isSelected() && singleRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 500;
                        subPrice = price;
                        tax = 20;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }

                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 600;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 400;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 500;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1000;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 25;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 400;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 700;
                        subPrice = price;
                        tax = 25;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 600;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Economy Class , Single Ticket , For Child
                if (economyRadioButton.isSelected() && singleRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 300;
                        subPrice = price;
                        tax = 10;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 300;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 400;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 700;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 300;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 300;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 700;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 300;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 300;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 400;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Economy , Return Ticket , For Adult
                if (economyRadioButton.isSelected() && returnRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 900;
                        subPrice = price;
                        tax = 60;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 900;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 1100;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1800;
                        subPrice = price;
                        tax = 60;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 900;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1800;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price =1300;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 900;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 700;
                        subPrice = price;
                        tax = 60;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 1300;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 1100;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Economy Class , Return Ticket , For Child
                if (economyRadioButton.isSelected() && returnRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "KTM - PKR";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1200;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "LHN - PKR";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 500;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1200;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "PKR - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 900;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "PKR - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "PKR - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 500;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 900;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 600;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }


                // Standard Class, Single Ticket , For Adult
                if (standardRadioButton.isSelected() && singleRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 250;
                        subPrice = price;
                        tax = 15;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }

                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 200;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - POK";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 400;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 700;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "LHN - POK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 250;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 700;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "POK - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 300;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "POK - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 200;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "POK - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 300;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - POK";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 400;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Standard Class , Single Ticket , For Child
                if (standardRadioButton.isSelected() && singleRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 150;
                        subPrice = price;
                        tax = 10;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 100;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - POK";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = price + tax;
                        route = "LHN - POK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 100;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "LHN -JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 150;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 500;
                        subPrice = price;
                        tax = 15;
                        totalPrice = tax + subPrice;
                        route = "POK - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "POK - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 100;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "POK - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 100;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "JNK - POK";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 200;
                        subPrice = price;
                        tax = 10;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                // Standard Class , Return Ticket , For Adult
                if (standardRadioButton.isSelected() && returnRadioButton.isSelected() && yesAdultRadioButton1.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 400;
                        subPrice = price;
                        tax = 30;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 300;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "KTM - POK";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 700;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 1200;
                        subPrice = price;
                        tax = 40;
                        totalPrice = price + tax;
                        route = "LHN - POK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 350;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 400;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 1200;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "POK - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price =500;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "POK - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 300;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "POK - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 350;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 500;
                        subPrice = price;
                        tax = 40;
                        totalPrice = tax + subPrice;
                        route = "JNK - POK";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 700;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";

                    }
                }

                //work start from here
                // Standard Class , Return Ticket , For Child
                if (standardRadioButton.isSelected() && returnRadioButton.isSelected() && yesChildRadioButton.isSelected()) {
                    conditionCheck = true;
                    // For Kathmandu
                    if (place1.equals("Kathmandu") && place2.equals("Kathmandu")) {
                        JOptionPane.showMessageDialog(null, "The Request is not supported");
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Lahan")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = subPrice + tax;
                        route = "KTM - LHN";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Pokhara")) {
                        price = 180;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "KTM - POK";
                    }
                    if (place1.equals("Kathmandu") && place2.equals("Janakpur")) {
                        price = 300;
                        subPrice = price;
                        tax = 20;
                        totalPrice = price + tax;
                        route = "KTM - JNK";
                    }

                    // For Lahan
                    if (place1.equals("Lahan") && place2.equals("Lahan")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Lahan") && place2.equals("Pokhara")) {
                        price = 800;
                        subPrice = price;
                        tax = 30;
                        totalPrice = price + tax;
                        route = "LHN - POK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Janakpur")) {
                        price = 180;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - JNK";
                    }
                    if (place1.equals("Lahan") && place2.equals("Kathmandu")) {
                        price = 250;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "LHN - KTM";
                    }

                    // For Pokhara
                    if (place1.equals("Pokhara") && place2.equals("Pokhara")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Pokhara") && place2.equals("Lahan")) {
                        price = 800;
                        subPrice = price;
                        tax = 30;
                        totalPrice = tax + subPrice;
                        route = "POK - LHN";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Janakpur")) {
                        price = 350;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "POK - JNK";
                    }
                    if (place1.equals("Pokhara") && place2.equals("Kathmandu")) {
                        price = 180;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "POK - KTM";
                    }

                    // For Janakpur
                    if (place1.equals("Janakpur") && place2.equals("Janakpur")) {
                        JOptionPane.showMessageDialog(null, "The request is not supported");
                    }
                    if (place1.equals("Janakpur") && place2.equals("Lahan")) {
                        price = 180;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - LHN";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Pokhara")) {
                        price = 350;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - PKR";
                    }
                    if (place1.equals("Janakpur") && place2.equals("Kathmandu")) {
                        price = 300;
                        subPrice = price;
                        tax = 20;
                        totalPrice = tax + subPrice;
                        route = "JNK - KTM";
                    }
                }

                if(conditionCheck== true) {

                    // For Class Type
                    if (firstClassRadioButton.isSelected()) {
                        classType = "First";
                    }
                    if (economyRadioButton.isSelected()) {
                        classType = "Economy";
                    }
                    if (standardRadioButton.isSelected()) {
                        classType = "Standard";
                    }

                    // For Ticket Type
                    if (singleRadioButton.isSelected()) {
                        ticketType = "Single";
                    }
                    if (returnRadioButton.isSelected()) {
                        ticketType = "Return";
                    }

                    // For Adult Or Child
                    if(yesAdultRadioButton1.isSelected()){
                        adult = "ONE";
                        child = "NULL";

                    }
                    if(yesChildRadioButton.isSelected()){
                        child = "ONE";
                        adult = "NUll";

                    }
                    fromTextDisplay.setText(String.valueOf(place1));
                    toTextDisplay.setText(String.valueOf(place2));
                    priceDisplay.setText(String.valueOf(totalPrice));

                    Calendar timer = Calendar.getInstance();
                    SimpleDateFormat tDate= new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat tTime= new SimpleDateFormat("HH:mm:ss");

                    timeDisplay.setText(tTime.format(timer.getTime()));
                    dateDisplay.setText(tDate.format(timer.getTime()));

                    textTicketDisplay.setText(String.valueOf(p1));
                    routeDisplay.setText(route);
                }
                // for display
                subTotal.setText(String.valueOf(subPrice));
                taxDisplay.setText(String.valueOf(tax));
                totalDisplay.setText(String.valueOf(totalPrice));
                displayClassType.setText(classType);
                ticketTypeDisplay.setText(ticketType);
                textAdult.setText(adult);
                textChild.setText(child);

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstClassRadioButton.setSelected(false);
                economyRadioButton.setSelected(false);
                standardRadioButton.setSelected(false);
                singleRadioButton.setSelected(false);
                returnRadioButton.setSelected(false);
                yesAdultRadioButton1.setSelected(false);
                yesChildRadioButton.setSelected(false);
                subTotal.setText("");
                totalDisplay.setText("");
                taxDisplay.setText("");
                displayClassType.setText("");
                ticketTypeDisplay.setText("");
                textChild.setText("");
                textAdult.setText("");
                fromTextDisplay.setText("");
                toTextDisplay.setText("");
                dateDisplay.setText("");
                timeDisplay.setText("");
                textTicketDisplay.setText("");
                priceDisplay.setText("");
                routeDisplay.setText("");
                comboFromBox.setSelectedItem(String.valueOf("Kathmandu"));
                comboToBox.setSelectedItem(String.valueOf("Lahan"));

            }
        });
    }
}
