package hunt.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Leaderboard {
    private static final String url = "jdbc:mysql://localhost:3307/signup";
    private static final String username = "root";
    private static final String password = "S@k4tag1n";
    private static final String tableName = "game";

    public Leaderboard() {
        JFrame frame = new JFrame("Leaderboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable leaderboardTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocation(900,100);
        loadLeaderboardData(tableModel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Leaderboard();
    }

    private static void loadLeaderboardData(DefaultTableModel tableModel) {
        tableModel.setColumnIdentifiers(new String[]{"Rank", "Player Name", "Score"});

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName + " ORDER BY time LIMIT 10");

            int rank = 1;
            while (resultSet.next()) {
                String playerName = resultSet.getString("name");
                int score = resultSet.getInt("time");
                tableModel.addRow(new Object[]{rank, playerName, score});
                rank++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
