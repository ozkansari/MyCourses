package tr.edu.medipol.vize1.gamzenurkeskin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagement{
    public static void main(String[] args) {
        new LoginWindow();
    }

}

class LoginWindow{

    private JFrame LoginWindow = new JFrame("STORE MANAGEMENT");

    public LoginWindow() {

        JLabel Slabel = new JLabel("STORE MANAGEMENT");
        Slabel.setFont(new Font("Arial", Font.BOLD, 50));
        Slabel.setForeground(Color.WHITE);
        Slabel.setBounds(120, 250, 900, 100);

        MenuBar();

        LoginWindow.getContentPane().add(Slabel);

        LoginWindow.getContentPane().setBackground(new Color(139, 58, 58));
        LoginWindow.setLayout(null);
        LoginWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        LoginWindow.setSize(800, 700);
        LoginWindow.setLocationRelativeTo(null);
        LoginWindow.setVisible(true);

    }
    public void MenuBar() {

        JMenuItem Employee = new JMenuItem("Employee");
        Employee.addActionListener(event -> {
            StoreEmployeeOpen();
        });

        JMenuItem Stock = new JMenuItem("Stock");
        Stock.addActionListener(event -> {
            StoreStockOpen();
        });

        JMenu Menu = new JMenu("MENU");
        Menu.add(Employee);
        Menu.add(Stock);

        JMenuBar Menubar = new JMenuBar();
        LoginWindow.setJMenuBar(Menubar);
        Menubar.add(Menu);

        Menu.setBackground(Color.WHITE);
        Menu.setForeground(new Color(139, 58, 58));
        Menu.setFont(new Font("Arial", Font.BOLD, 15));
        Stock.setBackground(Color.WHITE);
        Stock.setForeground(new Color(139, 58, 58));
        Stock.setFont(new Font("Arial", Font.BOLD, 15));
        Employee.setBackground(Color.WHITE);
        Employee.setForeground(new Color(139, 58, 58));
        Employee.setFont(new Font("Arial", Font.BOLD, 15));


        LoginWindow.setSize(800, 700);
        LoginWindow.setVisible(true);
    }
    private void StoreEmployeeOpen() {
        LoginWindow.dispose();
        new StoreEmployee();
    }
    private void StoreStockOpen() {
        LoginWindow.dispose();
        new StoreStock();
    }
}
class StoreEmployee{

    private JFrame Employee = new JFrame("STORE MANAGEMENT");
    JTable Table = new JTable();
    JTextField ENameTxt, ESurnameTxt, EDepartmentTxt;
    private JButton btnAdd = new JButton("ADD");
    private JButton btnDelete = new JButton("DELETE");
    private JButton btnHome = new JButton("HOME");
    JScrollPane ScrollPane = new JScrollPane(Table);


    public StoreEmployee() {

        JLabel Elabel = new JLabel("STORE MANAGEMENT");
        Elabel.setFont(new Font("Arial", Font.BOLD, 50));
        Elabel.setForeground(Color.WHITE);
        Elabel.setBounds(120, 0, 900, 100);

        JLabel Elabel2 = new JLabel("Store Employee");
        Elabel2.setFont(new Font("Arial", Font.PLAIN, 25));
        Elabel2.setForeground(Color.WHITE);
        Elabel2.setBounds(30, 55, 250, 100);

        JLabel EName = new JLabel("Name               :");
        EName.setFont(new Font("Arial", Font.PLAIN, 14));
        EName.setForeground(Color.WHITE);
        EName.setBounds(40, 100, 250, 100);

        ENameTxt = new JTextField(250);
        ENameTxt.setBounds(150,140,300,25);
        ENameTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        ENameTxt.setForeground(new Color(139, 58, 58));

        JLabel ESurame = new JLabel("Surname          :");
        ESurame.setFont(new Font("Arial", Font.PLAIN, 14));
        ESurame.setForeground(Color.WHITE);
        ESurame.setBounds(40, 150, 250, 100);

        ESurnameTxt =new JTextField(250);
        ESurnameTxt.setBounds(150,190,300,25);
        ESurnameTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        ESurnameTxt.setForeground(new Color(139, 58, 58));

        JLabel EDepartment = new JLabel("Department      :");
        EDepartment.setFont(new Font("Arial", Font.PLAIN, 14));
        EDepartment.setForeground(Color.WHITE);
        EDepartment.setBounds(40, 200, 250, 100);

        EDepartmentTxt =new JTextField(250);
        EDepartmentTxt.setBounds(150,240,300,25);
        EDepartmentTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        EDepartmentTxt.setForeground(new Color(139, 58, 58));

        JLabel EDepartmentType = new JLabel("( Intern, Personnel, Manager vb. )");
        EDepartmentType.setFont(new Font("Arial", Font.PLAIN, 14));
        EDepartmentType.setForeground(Color.WHITE);
        EDepartmentType.setBounds(480, 200, 250, 100);

        Object[] MainRow = {"NAME", "SURNAME", "DEPARTMENT"};

        DefaultTableModel  Tables = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tables.setColumnIdentifiers(MainRow);

        Table.setModel(Tables);
        Table.setBackground(new Color(139, 58, 58));
        Table.setForeground(Color.WHITE);
        Table.setFont(new Font("Arial", Font.PLAIN, 14));
        Table.setRowHeight(20);
        Table.setGridColor(Color.WHITE);
        Table.setSelectionBackground(Color.WHITE);
        Table.setSelectionForeground(new Color(139, 58, 58));
        Table.getTableHeader().setBackground(Color.WHITE);
        Table.getTableHeader().setForeground(new Color(139, 58, 58));
        Table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        btnAdd.setBounds(30, 300, 330, 35);
        btnAdd.setBackground(new Color(139, 58, 58));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));

        btnDelete.setBounds(400, 300, 330, 35);
        btnDelete.setBackground(new Color(139, 58, 58));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 16));

        btnHome.setForeground(Color.WHITE);
        btnHome.setBounds(30, 620, 700, 30);
        btnHome.setBackground(new Color(139, 58, 58));
        btnHome.setFont(new Font("Arial", Font.BOLD, 16));

        ScrollPane.setBounds(30, 350, 700, 260);

        Object[] Rows = new Object[3];

        btnAdd.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                Rows[0] = ENameTxt.getText();
                Rows[1] = ESurnameTxt.getText();
                Rows[2] = EDepartmentTxt.getText();

                Tables.addRow(Rows);}
        });

        btnDelete.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                int g = Table.getSelectedRow();
                if(g >= 0){
                    Tables.removeRow(g);
                }}
        });

        btnHome.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)  {
                HomeOpen();
            }}
        );

        Employee.getContentPane().add(Elabel);
        Employee.getContentPane().add(Elabel2);
        Employee.getContentPane().add(EName);
        Employee.getContentPane().add(ENameTxt);
        Employee.getContentPane().add(ESurame);
        Employee.getContentPane().add(ESurnameTxt);
        Employee.getContentPane().add(EDepartment);
        Employee.getContentPane().add(EDepartmentTxt);
        Employee.getContentPane().add(EDepartmentType);
        Employee.getContentPane().add(btnAdd);
        Employee.getContentPane().add(btnDelete);
        Employee.getContentPane().add(btnHome);
        Employee.getContentPane().add(ScrollPane);
        Employee.getContentPane().setBackground(new Color(139, 58, 58));
        Employee.setLayout(null);
        Employee.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Employee.setSize(800, 700);
        Employee.setLocationRelativeTo(null);
        Employee.setVisible(true);
    }
    private void HomeOpen() {
        Employee.dispose();
        new LoginWindow();
    }

}
class StoreStock{

    private JFrame Stock = new JFrame("STORE MANAGEMENT");
    JTable Table = new JTable();
    JTextField SNameTxt, SCategoryTxt;
    private JButton btnAdd = new JButton("ADD");
    private JButton btnDelete = new JButton("DELETE");
    private JButton btnHome = new JButton("HOME");
    JScrollPane ScrollPane = new JScrollPane(Table);


    public StoreStock() {

        JLabel Slabel = new JLabel("STORE MANAGEMENT");
        Slabel.setFont(new Font("Arial", Font.BOLD, 50));
        Slabel.setForeground(Color.WHITE);
        Slabel.setBounds(120, 0, 900, 100);

        JLabel Slabel2 = new JLabel("Store Stock");
        Slabel2.setFont(new Font("Arial", Font.PLAIN, 25));
        Slabel2.setForeground(Color.WHITE);
        Slabel2.setBounds(30, 55, 250, 100);

        JLabel SName = new JLabel("Name               :");
        SName.setFont(new Font("Arial", Font.PLAIN, 14));
        SName.setForeground(Color.WHITE);
        SName.setBounds(40, 100, 250, 100);

        SNameTxt = new JTextField(250);
        SNameTxt.setBounds(150,140,300,25);
        SNameTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        SNameTxt.setForeground(new Color(139, 58, 58));

        JLabel SCategory = new JLabel("Category          :");
        SCategory.setFont(new Font("Arial", Font.PLAIN, 14));
        SCategory.setForeground(Color.WHITE);
        SCategory.setBounds(40, 150, 250, 100);

        SCategoryTxt =new JTextField(250);
        SCategoryTxt.setBounds(150,190,300,25);
        SCategoryTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        SCategoryTxt.setForeground(new Color(139, 58, 58));


        JLabel SCategoryType = new JLabel("( Clothing, Shoes, Accessories vb. )");
        SCategoryType.setFont(new Font("Arial", Font.PLAIN, 14));
        SCategoryType.setForeground(Color.WHITE);
        SCategoryType.setBounds(480, 150, 250, 100);

        Object[] MainRow = {"NAME", "CATEGORY"};
        DefaultTableModel  Tables = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tables.setColumnIdentifiers(MainRow);

        Table.setModel(Tables);
        Table.setBackground(new Color(139, 58, 58));
        Table.setForeground(Color.WHITE);
        Table.setFont(new Font("Arial", Font.PLAIN, 14));
        Table.setRowHeight(20);
        Table.setGridColor(Color.WHITE);
        Table.setSelectionBackground(Color.WHITE);
        Table.setSelectionForeground(new Color(139, 58, 58));
        Table.getTableHeader().setBackground(Color.WHITE);
        Table.getTableHeader().setForeground(new Color(139, 58, 58));
        Table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        btnAdd.setBounds(30, 300, 330, 35);
        btnAdd.setBackground(new Color(139, 58, 58));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));

        btnDelete.setBounds(400, 300, 330, 35);
        btnDelete.setBackground(new Color(139, 58, 58));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 16));

        btnHome.setForeground(Color.WHITE);
        btnHome.setBounds(30, 620, 700, 30);
        btnHome.setBackground(new Color(139, 58, 58));
        btnHome.setFont(new Font("Arial", Font.BOLD, 16));

        ScrollPane.setBounds(30, 350, 700, 260);

        Object[] Rows = new Object[2];

        btnAdd.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                Rows[0] = SNameTxt.getText();
                Rows[1] = SCategoryTxt.getText();

                Tables.addRow(Rows);}
        });

        btnDelete.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                int g = Table.getSelectedRow();
                if(g >= 0){
                    Tables.removeRow(g);
                }}
        });

        btnHome.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                HomeOpen();
            }}
        );

        Stock.getContentPane().add(Slabel);
        Stock.getContentPane().add(Slabel2);
        Stock.getContentPane().add(SName);
        Stock.getContentPane().add(SNameTxt);
        Stock.getContentPane().add(SCategory);
        Stock.getContentPane().add(SCategoryTxt);
        Stock.getContentPane().add(SCategoryType);
        Stock.getContentPane().add(btnAdd);
        Stock.getContentPane().add(btnDelete);
        Stock.getContentPane().add(btnHome);
        Stock.getContentPane().add(ScrollPane);
        Stock.getContentPane().setBackground(new Color(139, 58, 58));
        Stock.setLayout(null);
        Stock.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Stock.setSize(800, 700);
        Stock.setLocationRelativeTo(null);
        Stock.setVisible(true);
    }
    private void HomeOpen() {
        Stock.dispose();
        new LoginWindow();
    }

}

