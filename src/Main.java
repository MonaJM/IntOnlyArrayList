/***
 * @author Mona Jakob Meshal
 */
public class Main {

    public static void main(String[] args) {

        //Create new obj to add values in list.
        IntOnlyArrayList myList = new IntOnlyArrayList();
        myList.add(1);
        myList.add(4);
        myList.add(50);
        myList.add(23);
        myList.add(5);
        myList.add(7);

        //Calling the methods
        System.out.println("My list contains\n"+myList);
        System.out.println("\nGotten value of index (3): "+myList.get(3));

        System.out.println("\nbefore deletion, index 3:\n"+myList);
        myList.remove(3);
        System.out.println("after deletion, index 3:\n"+myList);

        System.out.println("\nbefore addition, in index 2\n"+myList);
        myList.add(2,100);
        System.out.println("after addition:\n" +myList);
    }
}
