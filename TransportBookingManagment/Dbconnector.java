package TransportBookingManagment;

import java.sql.*;
import java.util.Scanner;

import static TransportBookingManagment.CustomerInfo.*;
import static TransportBookingManagment.TransInfo.readtransInfo;

public class Dbconnector {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        readtransInfo();
        while(true){
            System.out.println("Choose the menu");
            System.out.println("0.Exit the window");
            System.out.println("1.Insert the customer information");
            System.out.println("2.Delete the customer information");
            System.out.println("3.Update the customer information");
            System.out.println("4.Read the customer information");
            System.out.println("Enter the number :");
        int menu=scanner.nextInt();
    if(menu !=0 ){
        switch (menu){
            case 1:insertInfo();
            break;
            case 2:DeleteInfo();
            break;
            case 3:UpdateInfo();
            break;
            case 4:readcustInfo();}
    }else {System.out.println("you are exit from main window.....");}
        scanner.close();
        System.exit(0);}}}


