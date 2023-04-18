package tuan06_16_qlSPhamXML;

import java.util.Scanner;

public class Testing {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int luaChon;
		ManageProduct dom = new ManageProduct();
		boolean flag = true;
		
		do {
			createMenu();
			luaChon = sc.nextInt();
			switch(luaChon) {
			case 1:
				sc.nextLine();
				Product p = createNewProduct();
				dom.addProduct(p);
				break;
			
			case 2: 
				sc.nextLine();
				System.out.println("Enter productID: ");
				String productID = sc.nextLine();
				dom.deleteProduct(productID);
				break;
			
			case 3:
				sc.nextLine();
				System.out.println("Enter productID: ");
				productID = sc.nextLine();
				System.out.println("Enter new price: ");
				double donGia = sc.nextDouble();
				dom.updatePrice(productID, donGia);
				break;
				
			case 4:
				dom.printAll();
				break;
			
			case 5: 
				dom.writeXMLFile();
				break;
				
			default:
				flag = false;
				break;
			}
			
		}while(flag);
	}
	
	private static Product createNewProduct() {
		System.out.println("Enter productID: ");
		String productID = sc.nextLine();
		
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter manufacture: ");
		String manufacture = sc.nextLine();
		
		System.out.println("Enter description: ");
		String description = sc.nextLine();
		
		Supplier supplier = createNewSupplier();
		System.out.println("Enter price: ");
		double price = sc.nextDouble();
		
		return new Product(productID, name, manufacture, description, supplier, price);
	}
	
	private static Supplier createNewSupplier() {
		System.out.println("Enter supplier name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter country: ");
		String country = sc.nextLine();
		
		System.out.println("Enter website: ");
		String website = sc.nextLine();
		
		return new Supplier(name, country, website);
	}
	
	private static void createMenu() {
		System.out.println("========MENU=======");
		System.out.println("1. Add product");
		System.out.println("2. Delete");
		System.out.println("3. Update price");
		System.out.println("4. Print all");
		System.out.println("5. Write XML file");
		System.out.println("0. Exit");
		System.out.println("Your choice: ");
	}
	
}
