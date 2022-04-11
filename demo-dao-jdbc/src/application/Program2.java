package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = depDao.findByID(3);
		System.out.println(dep);		
		
		
		System.out.println("\n=== TEST 2: department findAll ====");		 
		
		 List<Department> list = depDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");		
		
		Department newDep = new Department(null, "Animes");
		
		depDao.insert(newDep);
		
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: seller update ====");		
		
		dep = depDao.findByID(6);
		dep.setName("Computer Science");
		
		depDao.update(dep);
		
		System.out.println("Update Completed");
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
