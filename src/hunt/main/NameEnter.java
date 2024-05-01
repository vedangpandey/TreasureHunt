package hunt.main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NameEnter {

    public NameEnter(int playTime){
        JFrame frame=new JFrame("Player's Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(20);
        JButton okayButton = new JButton("Okay");
        okayButton.addActionListener(e -> {
            ResultSet rs=null;
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String location="jdbc:mysql://localhost:3307/signup";
                Connection con= DriverManager.getConnection(location,"root","S@k4tag1n");
                String sql="insert into game values (?,?)";
                PreparedStatement ps;
                ps=(PreparedStatement) con.prepareStatement(sql);
                ps.setString(1,nameTextField.getText());
                ps.setInt(2,playTime);
                ps.execute();
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            new Leaderboard();
            frame.setVisible(false);

        });
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(okayButton);
        frame.setVisible(true);

    }

}
