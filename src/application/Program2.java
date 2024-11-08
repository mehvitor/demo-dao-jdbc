package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Department Insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department Update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update Complete");
		
		System.out.println("\n=== TEST 5: Department Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Complete");
		
		sc.close();
	

	}

}
