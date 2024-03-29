# Boda Boda Tracking System


## Terms
Boda boda - motocycle

Rider - the person who rides the motorcycle

Owner - the person who owns the motorcycle, this could be the rider himself or another person

## Description
This repository contains the code for a real-time GPS tracking system implemented in Java. The system is designed to track the location of the boda boda in real-time, as well as store information the the rider, owner, and boda boda.

## Features
- **Real-time tracking**: The system can track the location of boda boda in real-time.
Real-time tracking: It provides the ability to track the location of the boda boda in real-time, which is crucial for logistics, fleet management, and security purposes.

- **Storing information of the rider, owner and the boda boda**: The system stores the information of the rider of the bike, the boda boda details and the owner's information as well.
The information is stored is critical because when it comes to any legal issues it easier to get the necessary information.


## Usage

### Setting up the system
1. Clone the repository to your local machine.
2. Install the required dependencies.
3. Set up the database with the necessary tables.

### Running the system
1. Start the server by running the MySQL database server first and then the main Java file.
2. The system will start the interface as shown.
<img width="1082" alt="Screenshot 2023-12-13 112311" src="https://github.com/rvctech/bodaMatrix/assets/48275650/46e93986-f324-4fec-8aac-d1b0e5edc98f">

### Tracking the boda boda and necessary data
1. You can access the current location of a boda boda by searching the id of either the owner or the rider.
2. This will give you the information of the rider, the owner, and the location of the boda boda as shown.
<img width="1067" alt="Screenshot 2023-12-13 112704" src="https://github.com/rvctech/bodaMatrix/assets/48275650/da9ab20a-508c-44a6-ba0f-693be9aa9c5d">

### Adding new users
1. When the system is running and you need to add new users ie rider, owner, and boda boda, just click the add button.
2. A new window will appear where you have to input the necessary information. The window is as shown.
<img width="765" alt="Screenshot 2023-12-13 112758" src="https://github.com/rvctech/bodaMatrix/assets/48275650/f34a9e9a-c519-495a-9127-02475c11fff9">

3. Press the submit button to save the information.

### Edit users
1. This option is allowed when there is a transfer of ownership, or when the rider is being substituted. The boda boda information CANNOT be changed as per Kenyan law. 
2. When the system is running, you need to search the boda boda first to get the information of the rider, owner, and the boda boda.
3. When you press the edit button, a window should appear where you need to edit the necessary details of the  owner, rider, or both.
4. Press the save button to save the information. The window is as shown
<img width="431" alt="Screenshot 2023-12-13 112836" src="https://github.com/rvctech/bodaMatrix/assets/48275650/664d4357-90f9-40b8-ab76-0a069ca725b0">




## Contributing
We welcome contributions to the Real-Time GPS Tracking System! Here's how you can contribute:

1. **Fork the Repository**: Start by forking the repository to your own GitHub account.

2. **Clone the Repository**: Clone the forked repository to your local machine.

3. **Create a New Branch**: Always create a new branch for your changes. This keeps the project history clean and makes it easier to manage your changes.

4. **Make Your Changes**: Make your changes in the new branch. Be sure to follow the project's coding style and conventions.

5. **Commit Your Changes**: Commit your changes regularly with clear, concise commit messages.

6. **Push Your Changes**: Push your changes to your forked repository on GitHub.

7. **Submit a Pull Request**: Finally, submit a pull request from your forked repository to the main repository. Be sure to provide a clear description of the changes in your pull request.

Before submitting a pull request, please ensure your code adheres to our coding standards and passes all tests.

Thank you for considering contributing to the Real-Time GPS Tracking System!


## Credits
This project was developed by RVC Tech (Farid Ali). 

We also want to acknowledge the open-source libraries and tools used in this project:

- **Java**: The main programming language used for development.
- **MySQL**: The database used for storing and retrieving location data.
- **jxmaps**: The library used for displaying the map and location of the rider.
- **MySQL connector**: The library used for connecting the java application to the database.

If you have any questions or suggestions, feel free to open an issue or submit a pull request.

