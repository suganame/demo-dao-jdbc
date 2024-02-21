package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("=== TESTE 1: Seller findById ===");
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 3: Seller findByAll ===");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);

		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TESTE 5: Seller update ===");
		seller = sellerDao.findById(1);
		
		seller.setName("Martha Wayne");

		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
		System.out.println("\n=== TESTE 6: Seller delete ===");
		seller = sellerDao.findById(1);
		
		seller.setName("Martha Wayne");

		sellerDao.update(seller);		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		System.out.println("Delete complete");
		
		sc.close();
	}
}
