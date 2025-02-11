/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsbrands.jframe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Khanyi
 */
class JSportsBrandsFrame extends JFrame implements ActionListener{
    //Creating Components
    private JMenuBar mnbMain;
    private JMenu mnuFile, mnuTools;
    private JMenuItem mniExit, mniSubmit, mniReport, mniOrders;
    private JPanel pnlInstruments, pnlBrands, pnlBtn;
    private JLabel lblInstruments, lblInstrumentsLevel;
    private JComboBox cmbInstruments, cmbInstrumentsLevel;
    private JButton btnSubmit, btnReport;
    private String[] arrInstruments, arrLevel;
    private int[][] arrlevelCost;

    
    public JSportsBrandsFrame() {
        // Initialise components
        arrlevelCost = new int[][]{{150, 215, 130}, {250, 232, 185}, {280, 280, 310}, {180, 180, 210}};
        mnbMain = new JMenuBar();
        mnuFile = new JMenu("File");
        mniExit = new JMenuItem("Exit");
        mnuTools = new JMenu("Tools");
        mniSubmit = new JMenuItem("Order");
        mniOrders = new JMenuItem("Submit");
        
        
        mniExit = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exiting Method
                System.exit(0);
            }
        });
        
        
        mniSubmit = new JMenuItem(new AbstractAction("Order") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Submiting Method
                displayIntrumentLevelLeson();

            }
        });
        
        mniReport = new JMenuItem(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reporting Method
                displayAveragelesson();

            }
        });
        
        mniOrders = new JMenuItem(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reporting Method
                displayAveragelesson();
            }
        });

        //Creating a flowlayout using panels
        pnlInstruments = new JPanel(new FlowLayout());
        pnlBrands = new JPanel(new FlowLayout());
        pnlBtn = new JPanel(new FlowLayout());

        //Creating Labels in selection box
        lblInstruments = new JLabel("Brand: ");
        lblInstrumentsLevel = new JLabel("Item: ");

        //Creating arrays for Instruments and Level
        arrInstruments = new String[]{"Nike", "New Balance", "Jordan","Adidas"};
        arrLevel = new String[]{"Sneakers/Shoes", "Pants", "Accoessories"};
        //Creating comboboxes for Instruments and InstrumentsLevel
        cmbInstruments = new JComboBox(arrInstruments);
        cmbInstrumentsLevel = new JComboBox(arrLevel);

        //Creating buttons for Submit and Report 
        btnSubmit = new JButton("Order");
        btnReport = new JButton("Submit");
        
        //Add menu items to the relevant menu
        mnuTools.add(mniSubmit);
        mnuTools.add(mniOrders);
       
        //Add menu to menu Bar
        mnbMain.add(mnuFile);
        mnbMain.add(mnuTools);

        //Set JFrame properties
        setTitle("Vilakazi Sports & Recreation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLayout(new FlowLayout());
        setJMenuBar(mnbMain);
        

        //Add components to Panels
        pnlInstruments.add(lblInstrumentsLevel);
        pnlInstruments.add(lblInstruments);
        pnlInstruments.add(cmbInstruments);

        //Using Panels for InstrumentsLevel label and combobox
        pnlBrands.add(lblInstrumentsLevel);
        pnlBrands.add(cmbInstrumentsLevel);

        //Creating buttons for Submit and Report 
        pnlBtn.add(btnSubmit);
        pnlBtn.add(btnReport);
        
        //Add panels to JFrame
        add(pnlInstruments);
        add(pnlBrands);
        add(pnlBtn);

        //Add listener to button 
        btnSubmit.addActionListener(this);
        btnReport.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        displayIntrumentLevelLeson();
    }

    //Displaying 
    public void displayIntrumentLevelLeson() {
        String selectedCourse = cmbInstruments.getSelectedItem().toString();
        String selectedYear = cmbInstrumentsLevel.getSelectedItem().toString();

        int InstrumentsPos = cmbInstruments.getSelectedIndex();
        int levelPos = cmbInstrumentsLevel.getSelectedIndex();
        int levelCost = arrlevelCost[InstrumentsPos][levelPos];

        JOptionPane.showMessageDialog(null, "Brand: " + selectedCourse
                + "\nItem: " + selectedYear
                + "\nItem Price: R" + levelCost,"Music Lessons Price",JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void displayAveragelesson(){
        int totlevelCost=0;
        String dispString="";
        
        for (int r = 0; r < arrlevelCost.length; r++) {
           for (int c = 0; c < arrlevelCost[r].length; c++) {
           totlevelCost+= arrlevelCost[r][c];
        }
           
           dispString+= "\n Average lesson for " + arrInstruments[r] + " is :R" + totlevelCost;
           totlevelCost=0;
        }
        
        JOptionPane.showMessageDialog(null, dispString,"Message",JOptionPane.INFORMATION_MESSAGE);
    }

}
