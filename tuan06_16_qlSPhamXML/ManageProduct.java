package tuan06_16_qlSPhamXML;


import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageProduct {
	private static String filename = "src//qlSPham//Products.xml";
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public ManageProduct() {
		try {
			
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(filename);
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(org.xml.sax.SAXException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product p) {
		Element root = document.getDocumentElement();
		Element pProduct = document.createElement("product");
		root.appendChild(pProduct);
		pProduct.setAttribute("id", p.getProductID());
		
		Node pProductName = document.createElement("productName");
		pProduct.appendChild(pProductName);
		pProductName.setTextContent(p.getName());
		
		Node pManefature = document.createElement("manufacture");
		pProduct.appendChild(pManefature);
		pManefature.setTextContent(p.getManufacture());
		
		Node pDescription = document.createElement("description");
		pProduct.appendChild(pDescription);
		pDescription.setTextContent(p.getDescription());
		
				Element pSupplier = document.createElement("suplier");
				pProduct.appendChild(pSupplier);
				Node pSupplierName = document.createElement("suplierName");
				pSupplier.appendChild(pSupplierName);
				pSupplierName.setTextContent(p.getSupplier().getName());
				
				Node pCountry = document.createElement("country");
				pSupplier.appendChild(pCountry);
				pCountry.setTextContent(p.getSupplier().getCountry());
				
				Node pWeb = document.createElement("website");
				pSupplier.appendChild(pWeb);
				pWeb.setTextContent(p.getSupplier().getWebsite());
				
		Node pPrice = document.createElement("price");
		pProduct.appendChild(pPrice);
		pPrice.setTextContent(p.getPrice() + "");
	}
	
	public void deleteProduct(String pID) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for(int i= 0; i < pList.getLength();i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(pID)) {
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}
	
	public void updatePrice(String pID, double newPrice) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for(int i= 0; i < pList.getLength();i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(pID)) {
				Node priceNode = pNode.getElementsByTagName("price").item(0);
				priceNode.setTextContent(newPrice +"");
				break;
			}
		}
	}
	
	public void writeXMLFile() {
		TransformerFactory factory;
		Transformer transformer;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printAll() {
		TransformerFactory factory;
		Transformer transformer;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> list = new ArrayList<Product>();
		
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		
		int pCount = pList.getLength();
		for(int i=0;i< pCount;i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("productName").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();
		
			Element sNode = (Element) pNode.getElementsByTagName("suplier").item(0);
			String sName = pNode.getElementsByTagName("suplierName").item(0).getTextContent();
			String country = pNode.getElementsByTagName("country").item(0).getTextContent();
			String website = pNode.getElementsByTagName("website").item(0).getTextContent();
			
			Supplier supplier = new Supplier(sName, country, website);
			
			String sprice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0;
			try {
				price = Double.valueOf(sprice);
			} catch (NumberFormatException e) {
				
			}	
			Product p = new Product(productID, name, manufacture, description, supplier, price);
			list.add(p);
		}
		return list;
	}
}
