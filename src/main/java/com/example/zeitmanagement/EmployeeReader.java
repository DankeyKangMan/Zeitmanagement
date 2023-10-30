//EmployeeReader Idee: In einer Textdatei sind die Namen, Passwörter und IDs der Benutzer drin. EmployeeReader liest die und erstellt Employee-Objekte

/*package com.example.zeitmanagement_login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReader {
    public List<Employee> readEmployeesFromTextFile(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String name = parts[0];
                    String password = parts[1];
                    int employeeId = Integer.parseInt(parts[2]);
                    employees.add(new Employee(name, password, employeeId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }
}
*/
