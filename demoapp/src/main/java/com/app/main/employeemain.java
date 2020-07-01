package com.app.main;

import java.util.List;
import java.util.Scanner;

import com.app.bo.employeeBO;
import com.app.bo.impl.employeeboimpl;
import com.app.exception.BusinessException;
import com.app.model.employee;

public class employeemain {

	public static void main(String[] args) {
		System.out.println("Welcome to Player App");
		Scanner scanner = new Scanner(System.in);
		employeeBO employeeBO = new employeeboimpl();
		int ch = 0;
		do {
			System.out.println("employee Menu");
			System.out.println("----------------");
			System.out.println("1)Add emloyee");
			System.out.println("2)Remove employee");
			System.out.println("3)Search employee By id");
			System.out.println("4)Get All employees");
			System.out.println("5)Search Players By gender");
			System.out.println("6)EXIT");
			System.out.println("Enter your choice");
			ch = Integer.parseInt(scanner.nextLine());

			switch (ch) {
			case 1:
				System.out.println("Enter employee details");
				System.out.println("Enter employee Id");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter employee name");
				String name = scanner.nextLine();
				
				System.out.println("Enter employee Gender(m/f/o)");
				String gender = scanner.nextLine();
				employee employee = new employee(id, name, gender);

				try {
					employee = employeeBO.createemployee(employee);
					if (employee != null && employee.getId() != 0) {
						System.out.println("employee created with below details");
						System.out.println(employee);
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}

				break;
			case 2:
				System.out.println("Under construction please try other option");

				break;
			case 3:
				System.out.println("Enter player id for player details");
				int id1 = Integer.parseInt(scanner.nextLine());
				try {
					employee p = employeeBO.getemployeeByID(id1);
					if (p != null) {
						System.out.println("Player with id " + id1 + " found with details ");
						System.out.println(p);
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				try {
					List<employee> employeeList = employeeBO.getAllemployees();
					if (employeeList != null && employeeList.size() > 0) {
						System.out.println("Total there are " + employeeList.size() + " no of players.. Details are");
						for (employee e1 : employeeList) {
							System.out.println(e1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Enter gender(m/f/o) to get the players list");
				String gender1=scanner.nextLine();
				try {
					List<employee> employeeList = (List<com.app.model.employee>) employeeBO.getemployeessBygender(gender1);
					if (employeeList != null && employeeList.size() > 0) {
						System.out.println("Total there are " + employeeList.size() + " no of players..with gender "+gender1+" Details are");
						for (employee e1 : employeeList) {
							System.out.println(e1);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				System.out.println("Thank you for using our app");

				break;

			default:
				System.out.println("Invalid option Try again");
				break;
			}
		} while (ch != 6);
	}

}
