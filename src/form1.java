import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 extends JFrame {
    private JTextField ingreso;
    private JButton cedulaBtn;
    private JLabel B1TxT;
    private JPanel mainPanel;
    private JButton nombreButton;
    private JLabel nombreTxT;
    private JLabel CedulaTxT;
    private JLabel B2TxT;
    private JLabel PromedioTxT;

    public form1() {
        setTitle("Mi aplicacion");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        pack();
        setVisible(true);
        cedulaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/clase";
                String usuario = "root";
                String clave = "123456";
                try (Connection connection = DriverManager.getConnection(url, usuario, clave)){
                    System.out.println("Conexión Exitosa a la BD");
                    String query = "select * from estudiantes where cedula = '" + ingreso.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        nombreTxT.setText("Nombre: "+resultSet.getString("nombre"));
                        CedulaTxT.setText("Cédula: "+resultSet.getString("cedula"));
                        double b1 = Double.parseDouble(resultSet.getString("b1"));
                        double b2 = Double.parseDouble(resultSet.getString("b2"));
                        double promedio = (b1+b2)/2;
                        B1TxT.setText("Nota bimestre 1 : "+resultSet.getString("b1"));
                        B2TxT.setText("Nota bimestre 2 : "+resultSet.getString("b2"));
                        PromedioTxT.setText("Promedio: "+String.valueOf(promedio));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }
            }
        });
        nombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/clase";
                String usuario = "root";
                String clave = "123456";
                try (Connection connection = DriverManager.getConnection(url, usuario, clave)){
                    System.out.println("Conexión Exitosa a la BD");
                    String query2 = "select * from estudiantes where nombre = '" + ingreso.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query2);
                    while (resultSet.next()) {
                        nombreTxT.setText("Nombre: "+resultSet.getString("nombre"));
                        CedulaTxT.setText("Cédula: "+resultSet.getString("cedula"));
                        double b1 = Double.parseDouble(resultSet.getString("b1"));
                        double b2 = Double.parseDouble(resultSet.getString("b2"));
                        double promedio = (b1+b2)/2;
                        B1TxT.setText("Nota bimestre 1: "+resultSet.getString("b1"));
                        B2TxT.setText("Nota bimestre 2: "+resultSet.getString("b2"));
                        PromedioTxT.setText("Promedio: "+String.valueOf(promedio));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                }
            }
        });
    }
}
