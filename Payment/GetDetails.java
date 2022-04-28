package Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDetails
{
    public GetDetails()
    {
        // Create a new frame
        JFrame f =new JFrame("Choose your subscription");
        f.getContentPane().setBackground(new Color(230,230,0));
        f.setBackground(Color.cyan);

        // Create a new Label for the Title
        JLabel title = new JLabel("Choose your subscription",JLabel.CENTER);
        title.setBounds(500,50,400,80);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.BLUE);
        f.add(title);

        JLabel name,charge,startdate,cardnumber,expiry,cvv;
        JTextField chargeField,dateField,nameoncard_field,cardnumber_field,expiry_field,cvv_field;

        //Create a  JLabel with text "Personal Information"
        name = new JLabel("Subscription Model :");
        name.setBounds(400,175,400,50);
        name.setFont(new Font("Calibri", Font.ITALIC, 24));
        name.setForeground(Color.BLACK);
        f.add(name);

        // Option List for the Gender
        String[] subscription_options =
                {
                        "Please Select",
                        "Monthly",
                        "Quarterly",
                        "Semi-Yearly",
                        "Yearly"
                };

        JComboBox SubscriptionList = new JComboBox (subscription_options);
        SubscriptionList.setBounds(675,183,130,20);
        f.add(SubscriptionList);

        //Create a  JLabel with text "Personal Information"
        charge = new JLabel("Subscription Charge :");
        charge.setBounds(400,225,400,50);
        charge.setFont(new Font("Calibri", Font.ITALIC, 24));
        charge.setForeground(Color.BLACK);
        f.add(charge);

        chargeField = new JTextField();
        chargeField.setBounds(675,237,40,25);

        JTextField enddateField = new JTextField();
        enddateField.setBounds(675,337,70,25);
        // Make the end date field null by default
        enddateField.setText("");

        // If the SubscriptionList chosen is Monthly, then display 700 in the field
        // Add a Listener to the SubscriptionList choosen is "Monthly"
        SubscriptionList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SubscriptionList.getSelectedItem().toString() == "Monthly")
                {
                    chargeField.setText("700");
                    chargeField.setEditable(false);
                    enddateField.setText(java.time.LocalDate.now().plusMonths(1).toString());
                    enddateField.setEditable(false);
                }
                else if (SubscriptionList.getSelectedItem().toString() == "Quarterly")
                {
                    chargeField.setText("2500");
                    chargeField.setEditable(false);
                    enddateField.setText(java.time.LocalDate.now().plusMonths(3).toString());
                    enddateField.setEditable(false);
                }
                else if (SubscriptionList.getSelectedItem().toString() == "Semi-Yearly")
                {
                    chargeField.setText("3800");
                    chargeField.setEditable(false);
                    enddateField.setText(java.time.LocalDate.now().plusMonths(6).toString());
                    enddateField.setEditable(false);
                }
                else if (SubscriptionList.getSelectedItem().toString() == "Please Select")
                {
                    JOptionPane.showMessageDialog(f , "Please select a subscription model to subscribe!");
                    chargeField.setText("");
                    chargeField.setEditable(false);
                    enddateField.setText("");
                    enddateField.setEditable(false);
                }
                else
                {
                    chargeField.setText("8000");
                    chargeField.setEditable(false);
                    enddateField.setText(java.time.LocalDate.now().plusYears(1).toString());
                    enddateField.setEditable(false);
                }
            }
        });
        f.add(chargeField);

        //Create a  JLabel
        startdate = new JLabel("Start Date : ");
        startdate.setBounds(400,275,400,50);
        startdate.setFont(new Font("Calibri", Font.ITALIC, 24));
        startdate.setForeground(Color.BLACK);
        f.add(startdate);

        dateField= new JTextField();
        dateField.setBounds(675,287,70,25);
        dateField.setText(java.time.LocalDate.now().toString());
        dateField.setEditable(false);
        f.add(dateField);

        JLabel enddate = new JLabel("End Date : ");
        enddate.setBounds(400,325,400,50);
        enddate.setFont(new Font("Calibri", Font.ITALIC, 24));
        enddate.setForeground(Color.BLACK);
        f.add(enddate);
        enddateField.setText(java.time.LocalDate.now().toString());
        f.add(enddateField);

        // Frame Properties
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new GetDetails();
    }
}