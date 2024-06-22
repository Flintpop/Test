public class Test {
  public static void main(String[] args) {
    String i1 = "Oui";
    String oui = new String("Oui"); // oui plutôt que de vraiment valoir un nouveau "Oui", il sera égal à i1

    Integer test1 = new Integer(5);
    Integer test2 = new Integer(5);

    System.out.println(i1 == oui);
    System.out.println(i1.equals(oui));

    System.out.println(test1 == test2);
    System.out.println(test1.equals(test2));
  }
}