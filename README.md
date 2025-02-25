# Car Rental System 🚗💨

## Overview  
The **Car Rental System** is a Java-based console application that allows users to rent and return cars efficiently. It provides functionalities for managing cars, customers, and rental transactions while ensuring smooth operations with real-time availability checks.  

---

## Features ✨  
- **🏎️ Car Management** → Add cars with unique IDs, brands, models, and rental prices.  
- **👤 Customer Management** → Store customer details, including name, ID, and phone number.  
- **📅 Car Rental System** → Users can rent available cars for a specified number of days.  
- **🔄 Car Return System** → Users can return rented cars and update availability.  
- **📊 Pricing Calculation** → The system calculates total rental cost based on the number of days.  

---

## Technologies Used 🛠️  
- **Java** (Core programming)  
- **OOP (Object-Oriented Programming)**  
- **Data Structures** (`ArrayList` for managing records)  
- **Scanner API** (for user input handling)  

---

## How to Use? 📖  

Start the system and choose an option from the menu:  
- 🚗 **Rent a Car**  
- 🔄 **Return a Car**  
- ❌ **Exit the System**  

### If renting a car:  
1. Enter your **name** and **phone number**.  
2. Select an available car by entering its **ID**.  
3. Enter the **number of days** for rental.  
4. **Confirm** the rental.  

### If returning a car:  
1. Enter the **car ID** to mark it as returned.  
2. The system updates its **availability**.  

## Renting a Car  
- The system displays available cars.  
- The user enters their **name**, **phone number**, and **rental duration**.  
- The user selects a **car ID** from the available list.  
- The system calculates the total price and asks for confirmation.  
- If confirmed, the car is marked as **rented**, and the system stores the rental details.  

## Example Interaction 🖥️  

### Renting a Car  

====== Welcome in Car Rental System =======
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 1

== Rent a Car ==

- Enter your name: John Doe
- Available Cars:
- C001 .. Toyota .. Camry .. 60.0
- C002 .. Honda .. Accord .. 70.0

- Enter the car ID you want to rent: C001
- Enter your number of days for rent: 3
- Total Price: $180.00

- Confirm rental (Y/N): Y
- Car rented successfully!

### Returning a Car

====== Welcome in Car Rental System =======
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 2

== Return a Car ==

- Enter the car ID you want to return: C001

- Car returned successfully by John Doe
  
---
## Future Enhancements 🚀
- 🖥️ GUI Integration for a better user experience.
- 🛢️ Database Connectivity for storing cars, customers, and rentals persistently.
- 📱 Web or Mobile App Extension to enable remote car bookings.
