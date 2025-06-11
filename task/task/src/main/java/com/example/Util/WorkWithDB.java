package com.example.Util;

import com.example.DTO.Balance;
import com.example.DTO.Transactions;
import com.example.enums.BalanceType;
import com.example.enums.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDB {
    private static Connection conn = null;
    private static Statement stmt;

    public static void main(String[] args) {
        createStatement();
        createBalanceTypeTable();
        createCurrencyTable();
        createBalanceTable();
        createTransactionsTable();

        fillTableBalanceType();
        fillTableCurrency();

//        getTransactionsByAccountId("arsen003");

//        getBalanceByAccountName("arsen003");
//        deleteBalanceByAccountName("arsen003");
    }

    public static void createStatement() {
        String url = "jdbc:sqlite:bank.db"; // SQLite DB file
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Connected to SQLite database.");
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createBalanceTypeTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS balanceType ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT UNIQUE NOT NULL)";
        try {
            stmt.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createCurrencyTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS currency ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT UNIQUE NOT NULL)";
        try {
            stmt.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createBalanceTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS balance ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT UNIQUE NOT NULL,"
                + "value DOUBLE DEFAULT 0.0 NOT NULL)";
        try {
            stmt.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createTransactionsTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS transactions "
                + "("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "amount DOUBLE NOT NULL,"
                    + "balanceType INTEGER NOT NULL,"
                    + "currency INTEGER NOT NULL,"
                    + "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,"// Data and time https://www.sqlitetutorial.net/sqlite-date/
                    + "FOREIGN KEY (name) REFERENCES balance(id),"
                    + "FOREIGN KEY (balanceType) REFERENCES balanceType(id),"
                    + "FOREIGN KEY (currency) REFERENCES currency(id) "
                + ")";
        try {
            stmt.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillTableBalanceType() {
        String sql = "SELECT COUNT(*) AS total FROM balanceType";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int count = rs.getInt("total");
                if (count == 0) {
                    String insert = "INSERT INTO balanceType (name) VALUES (?)";
                    for (BalanceType balanceType: BalanceType.values()){
                        try (PreparedStatement pstmt = conn.prepareStatement(insert)) {
                            pstmt.setString(1, balanceType.name());
                            pstmt.executeUpdate();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fillTableCurrency() {
        String sql = "SELECT COUNT(*) AS total FROM balanceType";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int count = rs.getInt("total");
                if (count == 0) {
                    String insert = "INSERT INTO currency (name) VALUES (?)";
                    for (Currency currency: Currency.values()){
                        try (PreparedStatement pstmt = conn.prepareStatement(insert)) {
                            pstmt.setString(1, currency.name());
                            pstmt.executeUpdate();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addBalance(Balance balance) {
        String insert = "INSERT INTO balance (name, value) VALUES (?, ?)";
        insert = "INSERT INTO balance (name) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insert)) {
            pstmt.setString(1, balance.getName());
//            pstmt.setDouble(1, balance.getValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addTransactions(Transactions transactions) {
        String insert = "INSERT INTO transactions (name, amount, balanceType, currency) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insert)) {
            pstmt.setString(1, transactions.getName());
            pstmt.setDouble(2, transactions.getAmount());
            pstmt.setInt(3, transactions.getBalanceType().ordinal());
            pstmt.setInt(4, transactions.getCurrency().ordinal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateBalance(String username, double amount) {
        String updateSQL = "UPDATE balance SET value = ? WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, username);
            int affectedRows = pstmt.executeUpdate();
            System.out.println("Updated " + affectedRows + " record(s).");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Transactions> getTransactionsByAccountId(String accountName) {
        String selectSQL = "SELECT * FROM transactions WHERE name = ?";
        List<Transactions> transactionsList = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL);) {
            pstmt.setString(1, accountName);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transactions transactions = new Transactions();
                transactions.setName(rs.getString("name"));
                transactions.setAmount(Double.parseDouble(rs.getString("amount")));
                transactions.setCurrency(Currency.values()[rs.getInt("currency")]);
                transactions.setBalanceType(BalanceType.values()[rs.getInt("balanceType")]);
                transactions.setTimestamp(rs.getString("timestamp"));
                transactionsList.add(transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transactionsList;
    }
    public static Double getBalanceByAccountName(String accountName) {
        String selectSQL = "SELECT value FROM balance WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL);){
            pstmt.setString(1, accountName);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                return rs.getDouble("value");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }

    public static boolean isUsernameExist(String username) {
        String selectSQL = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) return true;
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteBalanceByAccountName(String accountName) {
        String selectSQL = "DELETE FROM balance WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL);){
            pstmt.setString(1, accountName);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void cleanTables() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM balance"); // Clean table for repeatability
            stmt.execute("DELETE FROM transactions"); // Clean table for repeatability
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

class TableCheck {
    public static void main(String[] args) {
        String dbPath = "mydata.db";  // Path to your SQLite database
        String url = "jdbc:sqlite:" + dbPath;
        String tableName = "users";   // Replace with your table name

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to database.");



            }
        } catch (SQLException e) {
            System.out.println("SQLite error: " + e.getMessage());
        }
    }
}
