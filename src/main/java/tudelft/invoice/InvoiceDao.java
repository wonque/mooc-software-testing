package tudelft.invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDao {

    private static Connection c;

    public InvoiceDao() {
        try {
            if (c != null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:D:\\Documents\\projects\\db", "SA", "");
            dropInvoices();
            c.prepareStatement("create table invoice (name varchar(100), value double)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Invoice> all() {

        List<Invoice> allInvoices = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from invoice");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                double value = rs.getDouble("value");
                allInvoices.add(new Invoice(name, value));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allInvoices;
        }

    }

    public void save(Invoice inv) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into invoice (name, value) values (?,?)");
            ps.setString(1, inv.getCustomer());
            ps.setDouble(2, inv.getValue());

            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void dropInvoices() {
        try {
            PreparedStatement ps = c.prepareStatement("DROP TABLE IF EXISTS invoice;");
            ps.execute();
            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearAndClose() {
        try {
            dropInvoices();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}