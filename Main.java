
import java.util.Scanner;

interface utility {
    public void set_details();
    public void get_details();
}

class showroom implements utility {
    String showroom_name;
    String showroom_address;
    int total_employees = 0;
    int total_cars_in_stock;
    String manager_name;
    
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter showroom Details:");
        System.out.println("Enter showroom name:");
        showroom_name = sc.nextLine();
        System.out.println("Enter showroom address:");
        showroom_address = sc.nextLine();
        System.out.println("Enter total number of employees:");
        total_employees = sc.nextInt();
        System.out.println("Enter total cars in stock:");
        total_cars_in_stock = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.println("Enter manager name:");
        manager_name = sc.nextLine();
    }
    
    public void get_details() {
        System.out.println("showroom name: " + showroom_name);
        System.out.println("showroom address: " + showroom_address);
        System.out.println("total number of employees: " + total_employees);
        System.out.println("total cars in stock: " + total_cars_in_stock);
        System.out.println("manager name: " + manager_name);
    }
}

class employee extends showroom implements utility {
    int emp_id;
    String emp_name;
    int emp_age; 
    String emp_department;
    
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee Details:");
        System.out.println("Enter employee id:");
        emp_id = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.println("Enter employee name:");
        emp_name = sc.nextLine();
        System.out.println("Enter employee age:");
        emp_age = sc.nextInt();
        sc.nextLine(); // consume the newline
        System.out.println("Enter employee department:");
        emp_department = sc.nextLine();
    }
    
    public void get_details() {
        System.out.println("employee id: " + emp_id);
        System.out.println("employee name: " + emp_name);
        System.out.println("employee age: " + emp_age);
        System.out.println("employee department: " + emp_department);
    }
}

class car extends showroom implements utility {
    String car_name;
    String car_color;
    String car_ftype;
    int car_price; 
    
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car Details:");
        System.out.println("Enter car name:");
        car_name = sc.nextLine();
        System.out.println("Enter car color:");
        car_color = sc.nextLine();
        System.out.println("Enter fuel type:");
        car_ftype = sc.nextLine();
        System.out.println("Enter car price:");
        car_price = sc.nextInt();
        total_cars_in_stock++;
    }
    
    public void get_details() {
        System.out.println("car name: " + car_name);
        System.out.println("car color: " + car_color);
        System.out.println("fuel type: " + car_ftype);
        System.out.println("car price: " + car_price);
    }
}

public class Main {
    static void main_menu() {
        System.out.println("WELCOME TO CAR AND SHOWROOM INFO:-");
        System.out.println();
        System.out.println("1. ADD SHOWROOM");
        System.out.println("2. ADD EMPLOYEE");
        System.out.println("3. ADD CAR");
        System.out.println("4. GET SHOWROOM");
        System.out.println("5. GET EMPLOYEE");
        System.out.println("6. GET CAR");
        System.out.println("7. EXIT");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        showroom[] showrooms = new showroom[5];
        employee[] employees = new employee[5];
        car[] cars = new car[5];
        
        int showroom_counter = 0;
        int employee_counter = 0;
        int car_counter = 0;
        int choice = 100; 
        
        while(choice != 7) {
            main_menu();
            choice = sc.nextInt();
            
            while(choice != 9 && choice != 7) {
                switch(choice) {
                    case 1:
                        showrooms[showroom_counter] = new showroom();
                        showrooms[showroom_counter].set_details();
                        showroom_counter++;
                        System.out.println();
                        System.out.println("1] ADD SHOWROOM");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                        
                    case 2:
                        employees[employee_counter] = new employee();
                        employees[employee_counter].set_details();
                        employee_counter++;
                        System.out.println();
                        System.out.println("2] ADD NEW EMPLOYEE");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                        
                    case 3:
                        cars[car_counter] = new car();
                        cars[car_counter].set_details();
                        car_counter++;
                        System.out.println();
                        System.out.println("3] ADD NEW CAR");
                        System.out.println("9] GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                        
                    case 4:
                        for(int i = 0; i < showroom_counter; i++) {
                            showrooms[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] TO EXIT");
                        choice = sc.nextInt();
                        break;
                        
                    case 5:
                        for(int i = 0; i < employee_counter; i++) {
                            employees[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] TO EXIT");
                        choice = sc.nextInt();
                        break;
                        
                    case 6:
                        for(int i = 0; i < car_counter; i++) {
                            cars[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9] GO BACK TO MAIN MENU");
                        System.out.println("0] TO EXIT");
                        choice = sc.nextInt();
                        break;
                        
                    default:
                        System.out.println("Enter a valid choice");
                        break;
                }
            }
        }
    }
}