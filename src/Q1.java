import ContigousList.ContigousList;
import Interfaces.List;
import Linked.LinkedList;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        String prodsToString="P1001 Toothpaste Grocery 220.00\n" +
                "P1002 Notebook Stationery 120.00\n" +
                "P1003 Shampoo Grocery 450.00\n" +
                "P1004 Pen Stationery 50.00\n" +
                "P1005 Soap Grocery 110.00\n" +
                "P1006 Marker Stationery 180.00\n" +
                "P1007 Chips Snacks 250.00\n" +
                "P1008 Chocolate Snacks 300.00\n" +
                "P1009 Rice Grocery 1000.00\n" +
                "P1010 Biscuit Snacks 200.00";

        String[] arrOfStr=prodsToString.split("\n");

        LinkedList<Product> productList=new LinkedList<>();

        for(String str: arrOfStr){
            String[] prodStrArr=str.split(" ");
            Product product=new Product(prodStrArr[0],prodStrArr[1],prodStrArr[2],Float.parseFloat(prodStrArr[3]));
            productList.insertLast(product);
        }

        displayProducts(productList);


        System.out.println("Sorting the products based on price using selection sort...\n\n\n");
        productList.selectionSort();
        System.out.println("Sorted Interfaces.List");
        displayProducts(productList);



        System.out.println("iii ).\n\ta." );
        System.out.print("\n\n\nEnter the price of the item to search: ");
        String searchPrice=input.nextLine();
        LinkedList<Product> searchResult= productList.sequentialSearch(new Product(Float.parseFloat(searchPrice)));
        displayProducts(searchResult);
        System.out.println("the Search mechanism is working");

        //Binary search part we use contigous lists
        ContigousList<Product> Conlist=new ContigousList(productList.listSize());
        for(int i=0;i<productList.listSize();i++){
            Conlist.insertLast(productList.retrieveList(i));
        }
        System.out.println("iii ).\n\tb." );
        displayProducts(Conlist);

        System.out.print("\n\n\nEnter the price of the item to search: ");
        searchPrice=input.nextLine();

        LinkedList<Product> binarySearchResult= Conlist.binarySearch(new Product(Float.parseFloat(searchPrice)));
        if(binarySearchResult.listSize()>0) {
            System.out.println("The product with price " + searchPrice + " is found");
            displayProducts(binarySearchResult);
        }
        else{
            System.out.println("The product with price "+searchPrice+" is not found");
        }
    }

    static void displayProducts(List<Product> listOfProducts){
        System.out.printf("%-12s %-10s %-12s %-5s%n", "ProductId", "Name", "Category", "Price");
        System.out.println("----------------------------------------------");
        for(int i=0;i<listOfProducts.listSize();i++){
            System.out.printf("%-12s %-10s %-12s %-5s%n",
                    listOfProducts.retrieveList(i).productId,
                    listOfProducts.retrieveList(i).name,
                    listOfProducts.retrieveList(i).category.toString(),
                    listOfProducts.retrieveList(i).price);
        }

    }


}


class Product implements Comparable<Product> {
    String productId;
    String name;
    Category category;
    float price;

    public Product(String productId, String name, String category, float price) {
        this.productId = productId;
        this.name = name;
        this.category = Category.valueOf(category);
        this.price = price;
    }

    public Product(float price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Float.compare(this.price, other.price);
    }

    enum Category {
        Grocery, Stationery, Snacks
    }

    @Override
    public String toString() {
        return String.format("%-12s %-10s %-12s %-5.2f",
                this.productId,
                this.name,
                this.category.toString(),
                this.price);
    }
}