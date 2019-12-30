package msb.bank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MsbBank {
    private static ArrayList<Customer> arrayCustomer= new ArrayList<Customer>();
    private static double totalMoneyVND=0, totalMoneyUSD=0, numberAccountUSD=0,numberAccountVND=0, numberCustomerNameLinh =0;
    public  static void removeHoa(){
        ArrayList<Customer> arrayCustomer2=  new ArrayList<Customer>();
        for(Customer customer: arrayCustomer){
            if(customer.getAccountName().endsWith("HOA"))
                arrayCustomer2.add(customer);
        }
        arrayCustomer.removeAll(arrayCustomer2);
    }
    public static void countLinh(){
        for( Customer customer1: arrayCustomer){
            if( customer1.getAccountName().endsWith("LINH"))
                numberCustomerNameLinh++;
        }
    }
    public static void totalMoney(){
        for( Customer customer1: arrayCustomer){
            if(customer1.getCurrentType().equals("USD"))
            {
                totalMoneyUSD += customer1.getCurrentBalance();
            }
            else {
                totalMoneyVND += customer1.getCurrentBalance();
            }
        }
    }
    public static void countUsdAndVnd(){
        for( Customer customer1: arrayCustomer){
            if(customer1.getCurrentType().equals("USD"))
            {
                numberAccountUSD++;
            }
            else {
                numberAccountVND++;
            }
        }
    }
    public static void transferMoney(long a,long b){
        long c=0;
        int d=0,e=0;
        for (Customer customer:arrayCustomer ) {
            if (customer.getCifNumber() == a){
                c= customer.getCurrentBalance();
                customer.setCurrentBalance(0);
            }
            if(customer.getCifNumber() == b) e=d;
            d++;
        }
        arrayCustomer.get(e).setCurrentBalance((arrayCustomer.get(e).getCurrentBalance()+c));
    }
    public static void analysis(){
        int analysisMonth[]= new int[12];
        for(int i=0;i<12;i++) analysisMonth[i]=0;
        for (Customer customer: arrayCustomer){
            int i= Integer.parseInt(customer.getOpenDate().substring(5,7))-1;
            analysisMonth[i]++;
        }
        int maxMonth=analysisMonth[0] ,minMonth= analysisMonth[0],max=0,min=0;
        for(int i=1;i<12;i++){
            if( analysisMonth[i] >maxMonth){
                maxMonth= analysisMonth[i];
                max=i;
            }
            if( analysisMonth[i] <minMonth) {
                minMonth= analysisMonth[i];
                min=i;
            }
        }
        max++;
        min++;
        System.out.println(" Vậy tháng mở nhiều tài khoản nhất là: "+max+ " có "+ maxMonth +" tai khoan được mở va thang mo it tai khoan nhat la: "+min +" có "+minMonth +" tài khoản được mở.");
    }
    public static void showCustomerList(){
        for( Customer customer: arrayCustomer)
            System.out.println(customer.toString());
    }
    public static void show(){
        System.out.println("App Msb Bank for  Company's Employee");
        System.out.println("Moi chon:");
        System.out.println("1.\tNeu muon thoat \n"+
                "2.\tThực hiện count xem tổng số dư của toàn bộ khách hàng có tài khoản là VND là bao nhiều , USD là bao nhiêu .\n" +
                "3.\tCó bao nhiêu khách hàng mở tài khoản VND , có bao nhiều khách hàng mở tài khoản USD\n" +
                "4.\tThống kê xem tháng nào là tháng có nhiều khách hàng mở tài khoản nhất tháng nào là tháng có ít tài khoản nhất\n" +
                "5.\tCó bao nhiêu khách hàng tên Linh trong database\n" +
                "6.\tXoá toàn bộ khách hàng có tên Hoa trong database\n" +
                "7.\tThực hiện chuyển toàn bộ tiền của khách hàng có mã cif là 1109536 sang khách hàng có mã cif là 1068405\n" +
                "8.\tHiển thị danh sách khách hàng trong database");
    }
    public static void main(String args[]) throws Exception {
        FileReader reader= null;
        int numberCustomer=0;
        totalMoneyVND=0;
        totalMoneyUSD=0; numberAccountUSD=0;
        numberAccountVND=0;
        numberCustomerNameLinh =0;
        try {
            reader = new FileReader("C:\\Users\\ADMIN\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\balance_demo.txt");
            int i,countTab=1;
            String beetwen="";
            long cifNumber1=0,account1=0,status1=0, currentBalance=0;
            String accountName="", accountType="", openDate="", currentType="",lastActiveDate="",statusChangedDate="",cardActiveDate="";
//            while ((i = reader.read()) != 13){
//                if((i = reader.read()) == 10) break;
//            }
            while ((i = reader.read()) != -1) {
                if(i == 10 || i == 34 || i == 44) continue;
                if(i == 13){
                    if(countTab == 9) lastActiveDate = beetwen;
                    if(countTab == 10) statusChangedDate = beetwen;
                    if(countTab == 11) cardActiveDate = beetwen;
                    Customer customer= new Customer(cifNumber1, account1, status1, accountName,accountType, openDate, currentBalance, currentType, lastActiveDate, statusChangedDate,cardActiveDate);
                    arrayCustomer.add(customer);
                    numberCustomer++;
                    countTab=1;
                    beetwen="";
                    cifNumber1=0;
                    account1=0;status1=0;
                    currentBalance=0;
                    accountName=""; accountType=""; openDate=""; currentType="";lastActiveDate="";statusChangedDate="";cardActiveDate="";
                }
                else {
                    if(i == 9){
                        switch (countTab){
                            case 1:
                                cifNumber1= Long.parseLong(beetwen);
                                break;
                            case 2:
                                account1= Long.parseLong(beetwen);
                                break;
                            case 3:
                                accountName= beetwen;
                                break;
                            case 4:
                                accountType = beetwen;
                                break;
                            case 5:
                                openDate = beetwen;
                                break;
                            case 6:
                                status1= Long.parseLong(beetwen);
                                break;
                            case 7:
                                currentBalance = Long.parseLong(beetwen);
                                break;
                            case 8:
                                currentType = beetwen;
                                break;
                            case 9:
                                lastActiveDate = beetwen;
                                break;
                            case 10:
                                statusChangedDate = beetwen;
                                break;
                        }
                        countTab++;
                        beetwen="";
                    }
                    else beetwen +=(char) i;
                }
            }
            if(i== -1){
                if(countTab == 9) lastActiveDate = beetwen;
                if(countTab == 10) statusChangedDate = beetwen;
                if(countTab == 11) cardActiveDate = beetwen;
                Customer customer= new Customer(cifNumber1, account1, status1, accountName,accountType, openDate, currentBalance, currentType, lastActiveDate, statusChangedDate,cardActiveDate);
                arrayCustomer.add(customer);
                numberCustomer++;
            }
            boolean flag= true;
            Scanner input= new Scanner(System.in);
            while (flag){
                show();
                int choice= input.nextInt();
                switch (choice){
                    case 1:
                        flag=false;
                        System.out.println("Hẹn gặp bạn vào này mai.Giữ gìn sức khỏe nhé. Love you!!!");
                        break;
                    case 2:
                        totalMoney();
                        System.out.println("Tổng số dư của toàn bộ khách hàng có tài khoản là VND là: "+ totalMoneyVND +" VND và tổng số dư của toàn bộ khách hàng có tài khoản là USD là: "+totalMoneyUSD +" USD");
                        break;
                    case 3:
                        countUsdAndVnd();
                        System.out.println("Có "+numberAccountVND + " khách hàng mở tài khoản VND , có "+ numberAccountUSD + " khách hàng mở tài khoản USD");
                        break;
                    case 4:
                        analysis();
                        break;
                    case 5:
                        countLinh();
                        System.out.println("Có " + numberCustomerNameLinh +"khách hàng tên Linh trong database");
                        break;
                    case 6:
                        removeHoa();
                        System.out.println("Xoa thanh cong.");
                        break;
                    case 7:
                        System.out.println("Moi nhap CIF cua khach hang muon chuyen tien va khach hang duoc nhan tien:");
                        long fromPerson=input.nextLong(), toPerson=input.nextLong() ;
                        transferMoney(fromPerson,toPerson);
                        break;
                    case 8:
                        showCustomerList();
                        System.out.println("Trong dataase có "+numberCustomer +"khách hàng");
                        break;
                }
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            reader.close();
        }

    }
}