import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static String inputUser(String query){
        System.out.print(query + " : ");
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        label:
        while (true){
            System.out.println("\n  SEARCH DATA FOOTBALL CLUBS FROM BRAZIL");
            System.out.println("==========================================");
            String result = inputUser("WHAT'S CLUB");

            GetDataFromQuery getDataFromQuery = new GetDataFromQuery();
            ModelAPI resultQuery = getDataFromQuery.ResultData(result);
            if(resultQuery.getName() == null && resultQuery.getCode() == null && resultQuery.getCountry() == null){
                System.out.println("Data Empty...");
            } else {
                System.out.println("\n  Result Query");
                System.out.println("****************");
                System.out.println("Name : " + resultQuery.getName());
                System.out.println("Code : " + resultQuery.getCode());
                System.out.println("Country : " + resultQuery.getCountry());
            }
            System.out.println(" ");
            String choose = inputUser("You Want to Search More ? (y/n)");
            if(choose.equals("n") || choose.equals("N")) {
                break label;
            }
        }
    }
}
