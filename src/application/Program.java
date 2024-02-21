package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
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

		System.out.println("\n=== TESTE 3: Seller findByAll===");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}
	}
}
