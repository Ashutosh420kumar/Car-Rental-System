import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Car class stores car information
class Car{
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	public Car(String carId,String brand,String model,double basePricePerDay){
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;
	}
	public String getCarId() {
		return carId;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public double calculatePrice(int numberOfDays) {
		return numberOfDays * basePricePerDay;
	}
	public boolean checkAvailability() {
		return isAvailable;
	}
	public void rent() {
		isAvailable = false;
	}
	public void returnCar() {
		isAvailable = true;
	}
	public double getBasePrice() {
		return basePricePerDay;
	}
}
// Customer class stores customer information
class Customer{
	private String name;
	private String customerId;
	private long phoneNumber; 
	public Customer(String name,String customerId,long phoneNumber){
		this.name = name;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
	}
	public String getCustomerName() {
		return name;
	}
	public String getCustomerId() {
		return customerId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
}
// Rental class stores details of the renter and the rented car
class Rental{
	private Car car;
	private Customer customer;
	private int days;
	public Rental(Car car,Customer customer,int days) {
		this.car = car;
		this.customer = customer;
		this.days = days;
	}
	public Car getCar() {
		return car;
	}
	public Customer getCustomer() {
		return customer;
	}
	public int getDays() {
		return days;
	}
}  
// system
public class CarRentalSystem {
	private List<Car>cars;
	private List<Customer>customers;
	private List<Rental> rentals;
	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}
	public void addCar(Car car) {
		cars.add(car);
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public void rentCar(Car car,Customer customer,int days) {
		if(car.checkAvailability()) {
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else {
			System.out.println("Car is not available for rent");
		}
	}
	public void returnCar(Car car) {
		Rental rentalToRemove = null;
		for(Rental rental : rentals) {
			if(car.getCarId().equals(rental.getCar().getCarId())) {
				rentalToRemove = rental;
				break;
			}
		}
		if(rentalToRemove != null) {
			rentals.remove(rentalToRemove);
			car.returnCar();
		}
		else {
			System.out.println("Car was not returned");
		}
	}
	public void menu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("====== Welcome in Car Rental System =======");
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();			
			
			if(choice == 1) {
				System.out.println("\n== Rent a Car ==\n");
				System.out.println("Enter your name:");
				String customerName = sc.nextLine();
					
				System.out.println("\nAvailable Car:");
				for(Car car:cars) {
					if(car.checkAvailability()) {
						System.out.println(car.getCarId()+" .. "+car.getBrand()+" .. "+car.getModel()+" .. "+car.getBasePrice());
					}
				}
				System.out.println("\nEnter the car ID you want to rent: ");
				String carId = sc.nextLine();
					
				System.out.println("Enter your number of days for rents: ");
				int rentalDays = sc.nextInt();
					
				System.out.println("Enter your phone Number: ");
				long phoneNumber = sc.nextLong();
					
				Customer newCustomer = new Customer(customerName,"CUS"+(customers.size()+1),phoneNumber);
				addCustomer(newCustomer);
					
				Car selectCar = null;
				for(Car car:cars) {
					if(car.getCarId().equals(carId)  && car.checkAvailability()) {
						selectCar = car;
						break;
					}
				}
				if(selectCar != null) {
					double totalPrice = selectCar.calculatePrice(rentalDays); 
					System.out.println("\n== Rental Information ==\n");
					System.out.println("Customer Id: " + newCustomer.getCustomerId());
					System.out.println("Customer Name: " + newCustomer.getCustomerName());
					System.out.println("Customer Phone Number: " + newCustomer.getPhoneNumber());
					System.out.println("Car: " + selectCar.getBrand()+" .... "+selectCar.getModel());
					System.out.println("Rental Days: " + rentalDays);
					System.out.printf("Total Price: $%.2f%n",totalPrice);
					
					System.out.println("\nConfirm rental (Y/N): ");
					String confirm = sc.next();
				
					if(confirm.equalsIgnoreCase("y")) {
						rentCar(selectCar,newCustomer,rentalDays);
						System.out.println("\nCar rented successfully");
					}
					else {
						System.out.println("\nRental cancel");
					}
				}
				else {
					System.out.println("Invaild car selection or can not available for rent.");
					
				}
			}
			else if(choice == 2) {
				System.out.println("\n== Return a Car ==\n");
				System.out.println("Enter the car Id you want to return: ");
				String carId = sc.nextLine();
			
				Car carToReturn = null;
				for(Car car:cars) {
					if(car.getCarId().equals(carId) && !car.checkAvailability()) {
						carToReturn = car;
						break;
					}
				}
				if(carToReturn != null) {
					Customer customer = null;
					for(Rental rental : rentals) {
						if(rental.getCar() == carToReturn) {
							customer = rental.getCustomer();
							break;
						}
					}
					if(customer != null) {
						returnCar(carToReturn);
						System.out.println("\nCar returned successfully by "+customer.getCustomerName());
					}
					else {
						System.out.println("Car was not rented or rental information is missing");
					}
				}
				else {
					System.out.println("car was not rented.");
				}
			}
			else if(choice == 3) {
				break;
			}
			else {
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
		sc.close();
		System.out.println("\nThank You for using the car rental system!.");
	}
public static void main(String[] args) {
	CarRentalSystem rentalSystem = new CarRentalSystem();
	
	//  Different base price per day for each day
	Car car1 = new Car("C001", "Toyota", "Camry", 60.0);
	Car car2 = new Car("C002", "Honda", "Accord", 70.0);
	Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
	rentalSystem.addCar(car1);
	rentalSystem.addCar(car2);
	rentalSystem.addCar(car3);
	
	rentalSystem.menu();
	}
}

