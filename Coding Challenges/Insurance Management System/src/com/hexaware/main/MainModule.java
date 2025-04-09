package com.hexaware.main;

import com.hexaware.entity.Policy;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.dao.InsuranceServiceImpl;
import com.hexaware.dao.IPolicyService;
import com.hexaware.util.DBConnUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class MainModule {

    private static Scanner scanner = new Scanner(System.in);
    private static IPolicyService policyService = new InsuranceServiceImpl();

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        // Establishes the database connection
        Connection conn = null;
        try {
            conn = DBConnUtil.getConnection();
            System.out.println("Database connection established successfully !!");
        } catch (SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
            return; 
        }

        int choice=-1;
        while (choice != 0) {
        	//show menu of options
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                //switch case to call appropriate methods
                switch (choice) {
                    case 1:
                        createPolicy();
                        break;
                    case 2:
                        getPolicy();
                        break;
                    case 3:
                        getAllPolicies();
                        break;
                    case 4:
                        updatePolicy();
                        break;
                    case 5:
                        deletePolicy();
                        break;
                    case 0:
                        System.out.println("Exiting application....\n Thank you for Working with Us !");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
    
    //Show Menu Method
    private static void showMenu() {
        System.out.println("\n--- Insurance Management System ---");
        System.out.println("1. Create Policy");
        System.out.println("2. Get Policy by ID");
        System.out.println("3. Get All Policies");
        System.out.println("4. Update Policy");
        System.out.println("5. Delete Policy");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    //Create policy Method (Option 1)
    private static void createPolicy() {
        try {
            System.out.print("Enter Policy ID: ");
            int policyId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Policy Number: ");
            String policyNumber = scanner.nextLine();
            System.out.print("Enter Policy Type: ");
            String policyType = scanner.nextLine();
            System.out.print("Enter Premium: ");
            double premium = Double.parseDouble(scanner.nextLine());
            Policy policy = new Policy(policyId, policyNumber, policyType, premium);
            if (policyService.createPolicy(policy)) {
                System.out.println("Policy created successfully.");
            } else {
                System.out.println("Policy creation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error creating policy: " + e.getMessage());
        }
    }

    //Get Policy By ID Method (Option 2)
    private static void getPolicy() {
        try {
            System.out.print("Enter Policy ID: ");
            int policyId = Integer.parseInt(scanner.nextLine());
            Policy policy = policyService.getPolicy(policyId);
            System.out.println("Policy Details: ");
            System.out.println("Policy Id: " + policy.getPolicyId());
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Policy Type: " + policy.getPolicyType());
            System.out.println("Premium: " + policy.getPremium());
        } catch (PolicyNotFoundException pfe) {
            System.out.println(pfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error fetching policy: " + e.getMessage());
        }
    }

    //Retrieve All Available Policies from DB (Option 3)
    private static void getAllPolicies() {
        try {
            Collection<Policy> policies = policyService.getAllPolicies();
            if (policies.isEmpty()) {
                System.out.println("No policies found.");
                return;
            }
            // Print table header
            System.out.println("Policy Id\tPolicy Number\tPolicy Type\t\tPremium");
            System.out.println("--------------------------------------------------------------");
            // Print each policy's details separated by tab (\t)
            for (Policy policy : policies) {
                System.out.println(
                    policy.getPolicyId() + "\t\t" +
                    policy.getPolicyNumber() + "\t\t" +
                    policy.getPolicyType() + "\t\t" +
                    policy.getPremium()
                );
            }
        } catch (Exception e) {
            System.out.println("Error retrieving policies: " + e.getMessage());
        }
    }

    //Update Policy Method (Option 4)
    private static void updatePolicy() {
        try {
            System.out.print("Enter Policy ID to update: ");
            int policyId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter New Policy Number: ");
            String policyNumber = scanner.nextLine();
            System.out.print("Enter New Policy Type: ");
            String policyType = scanner.nextLine();
            System.out.print("Enter New Premium: ");
            double premium = Double.parseDouble(scanner.nextLine());
            Policy policy = new Policy(policyId, policyNumber, policyType, premium);
            if (policyService.updatePolicy(policy)) {
                System.out.println("Policy updated successfully.");
            } else {
                System.out.println("Policy update failed.");
            }
        } catch (PolicyNotFoundException pfe) {
            System.out.println(pfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error updating policy: " + e.getMessage());
        }
    }

    //Delete Policy Based on "PolicyID" (Option 5)
    private static void deletePolicy() {
        try {
            System.out.print("Enter Policy ID to delete: ");
            int policyId = Integer.parseInt(scanner.nextLine());
            if (policyService.deletePolicy(policyId)) {
                System.out.println("Policy deleted successfully.");
            } else {
                System.out.println("Policy deletion failed.");
            }
        } catch (PolicyNotFoundException pfe) {
            System.out.println(pfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error deleting policy: " + e.getMessage());
        }
    }
}
