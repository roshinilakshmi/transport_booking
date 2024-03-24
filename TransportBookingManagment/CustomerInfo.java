package TransportBookingManagment;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;

import static java.sql.DriverManager.getConnection;

public class CustomerInfo {
    String CustomerName;
    String Phonenumber;
    String Email;
    static Date date;
    String Pikcup_point;
    String JorneyType;
    private int Customer_Id;

    public static void readcustInfo() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Transport";
        String username = "root";
        String Password = "Rosh@1206";
        String query = "select * from CustomerInfo";

        Connection conread = getConnection(url, username, Password);
        Statement st = conread.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("Customer name:" + rs.getString(1) + '\t' + "Phone number:" + rs.getString(2) + '\t' + "Email id:" + rs.getString(3) + '\t' + "Date:" + rs.getString(4) + '\t' + "Pickup point:" + rs.getString(5) + '\t' + "Journey  type:" + rs.getString(6));
        }
        conread.close();
    }

    public static void insertInfo() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "Insert into customerInfo values(?,?,?,?,?,?,?); ";
        System.out.println("Enter the customer id");
        int customer_id = sc.nextInt();
        System.out.println("Enter name of the customer:");
        String CustomerName = sc.next();
        System.out.println("Enter phone number of the customer:");
        String Phonenumber = sc.next();
        System.out.println("Enter Email of the customer:");
        String Email = sc.next();
        System.out.println("Enter Date of jorney:");
        String dateInput = sc.next();
        System.out.println("Enter the pickup point of customer:");
        String Pikcup_point = sc.next();
        System.out.println("Enter the journey type of customer:");
        String journeytype = sc.next();

        Connection conIns = getConnection("jdbc:mysql://localhost:3306/Transport", "root", "Rosh@1206");
        PreparedStatement pst = conIns.prepareStatement(query);
        pst.setInt(1, customer_id);
        pst.setString(2, CustomerName);
        pst.setString(3, Phonenumber);
        pst.setString(4, Email);
        pst.setString(5, dateInput);
        pst.setString(6, Pikcup_point);
        pst.setString(7, journeytype);
        int rows = pst.executeUpdate();
        System.out.println("Booking is confirmed successfully....." + rows);
        conIns.close();
    }

    public static void DeleteInfo() throws SQLException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Booking Id:");
        int Customer_Id = sc1.nextInt();
        String query = "Delete from CustomerInfo where customer_Id = " + Customer_Id;
        Connection condel = getConnection("jdbc:mysql://localhost:3306/Transport", "root", "Rosh@1206");
        Statement st1 = condel.createStatement();
        int deleterows = st1.executeUpdate(query);
        System.out.println("Booking is canceled successfully......." + deleterows);
        condel.close();
    }

    public static void UpdateInfo() throws SQLException {
        Connection conup = getConnection("jdbc:mysql://localhost:3306/Transport", "root", "Rosh@1206");
        Scanner sc2 = new Scanner(System.in);
        while (true) {
            System.out.println("choose the option for update");
            System.out.println("0.Exit");
            System.out.println("1.CustomerName");
            System.out.println("2.Phonenumber");
            System.out.println("3.Email");
            System.out.println("Select the option");
            int option = sc2.nextInt();
            if (option != 0) {
                switch (option) {

                    case 1: {
                        System.out.println("Enter the updating customer name:");
                        String CustomerName = sc2.next();
                        System.out.println("Enter the refference Booking id:");
                        int customer_Id = sc2.nextInt();
                        String queryupdate1 = "UPDATE  CustomerInfo set CustomerName=(?) where customer_Id=(?)";
                        PreparedStatement pstupdate1 = conup.prepareStatement(queryupdate1);
                        pstupdate1.setInt(2, customer_Id);
                        pstupdate1.setString(1, CustomerName);
                        int rows = pstupdate1.executeUpdate();
                        System.out.println(pstupdate1);
                        System.out.println("Your name ia successfully updated.....");
                    }
                    break;

                    case 2: {
                        System.out.println("Enter the updating Phone number:");
                        String PhoneNumber = sc2.next();
                        System.out.println("Enter the refference Booking id:");
                        int customer_Id1 = sc2.nextInt();
                        String queryupdate2 = "UPDATE  CustomerInfo set PhoneNumber=(?) where customer_Id=(?)";
                        PreparedStatement pstupdate2 = conup.prepareStatement(queryupdate2);
                        pstupdate2.setInt(2, customer_Id1);
                        pstupdate2.setString(1, PhoneNumber);
                        int rows1 = pstupdate2.executeUpdate();
                        System.out.println(pstupdate2);
                        System.out.println("Your phone number ia successfully updated.....");
                    }
                    break;

                    case 3: {
                        System.out.println("Enter the updating customer Email:");
                        String Email = sc2.next();
                        System.out.println("Enter the refference Booking id:");
                        int customer_Id2 = sc2.nextInt();
                        String queryupdate3 = "UPDATE  CustomerInfo set Email=(?) where customer_Id=(?)";
                        PreparedStatement pstupdate = conup.prepareStatement(queryupdate3);
                        pstupdate.setInt(2, customer_Id2);
                        pstupdate.setString(1, Email);
                        int rows2 = pstupdate.executeUpdate();
                        System.out.println(pstupdate);
                        System.out.println("Your Email ia successfully updated.....");
                    }
                    break;

                }


            } else {
                System.out.println("You are exit from update window......");
                sc2.close();
                System.exit(0);
            }
        }
    }}
