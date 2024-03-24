package TransportBookingManagment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class TransInfo {
    String Transporttype;
    int Transportno;
    int capacity;
    String From;
    String To;
    int charges;
    public static void readtransInfo() throws SQLException {
        String url="jdbc:mysql://localhost:3306/Transport";
        String username="root";
        String Password="Rosh@1206";
        String query="select * from TransInfo";

        Connection con = getConnection(url,username,Password);
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()) {
            System.out.println("Transport type:" + rs.getString(1) + '\t' + "Transport number:" + rs.getInt(2) + '\t' + "Capacity:" + rs.getInt(3) + '\t' + "From:" + rs.getString(4) + '\t' + "To:" + rs.getString(5) + '\t' + "Charges:" + rs.getInt(6));
        }}
    }

