# Vehicle Dealership Management System

This Java application simulates a vehicle dealership management system. It includes classes for managing vehicles, dealership information, and contracts. The system allows for adding, removing, and searching for vehicles, as well as creating and saving contracts for vehicle sales or leases.

## Classes

### Main

The `Main` class contains the main method to run the application. It initializes the user interface and displays it.

### Vehicle

The `Vehicle` class represents a vehicle with various attributes such as VIN, year, make, model, etc. It provides methods to get and set these attributes, as well as a toString method for displaying vehicle details.

### Dealership

The `Dealership` class manages dealership information and inventory. It includes methods to add, remove, and search for vehicles in the inventory based on different criteria such as price, make, model, etc.

### Contract

The `Contract` class is an abstract class representing a contract for a vehicle sale or lease. It includes common attributes like date, customer information, and the vehicle sold. Subclasses `SalesContract` and `LeaseContract` implement specific types of contracts with methods to calculate total price and monthly payment.

### DealershipFileManager

The `DealershipFileManager` class provides functionality to read dealership information and inventory from a CSV file and save it back to the file.

### ContractFileManager

The `ContractFileManager` class handles the saving of contracts to a text file.

## Usage

1. Compile all Java files.
2. Run the `Main` class.
3. Use the provided user interface to interact with the dealership management system.
4. Dealership information and inventory are loaded from and saved to `DB_Dealership.csv`.
5. Contracts are saved to `contracts.txt`.