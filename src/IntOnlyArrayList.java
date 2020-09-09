/***
 * @author Mona Jakob Meshal
 */
public class IntOnlyArrayList {

    private int[] list;
    private int currentIndex = 0;

    //** Initialize the constructor **
    public IntOnlyArrayList()
    {
        this.list = new int[20];
    }

    // Method - function to add to last index
    public void add(int value)
    {
        // if the limit size is reached
        if(this.currentIndex >= this.list.length)
        {
            //1. replace the 'old' list with the 'extended' list
            this.list = this.extendMyList();
        }
        // 2. add the new number to the current Index in the 'extended' array.
        this.list[this.currentIndex] = value;

        //3. increase the current index by one.
        this.currentIndex++;
    }

    //Method - function to extend the array list
    private int[] extendMyList()
    {
        //1. Make new array with size 40 (20 + 20)
        //int[] newList = new int[40];
        int[] newList = new int[this.list.length + 20]; //making list dynamic: add size 20 to old list size

        //2. and loop through the old array to get its elements into new array
        for (int i = 0; i <= this.list.length-1; i++) {
            newList[i] = this.list[i]; //copy elements from old list to new list
        }
        return newList; //return the new list with the extended size.
    }

    //Method - function to add a value to a desired index
    public void add(int indexToAdd, int value)
    {
        // if the index to be added is smaller than 0 and bigger than current 'last' index
        if(indexToAdd < 0 && indexToAdd >= this.currentIndex)
        {
            //then throw out of bound exception
            throw new IndexOutOfBoundsException("Index "+indexToAdd+" is out of bounds!");
        }

        //else if the limit size is reached
        if(this.currentIndex >= this.list.length)
        {
            //then extend the list
            this.list = this.extendMyList();
        }

        //Ex - list:  1, 4, 50, 23, 5, 7, 0
        //index:      0, 1,  2,  3, 4, 5, 6
        // and locate the the index i want to add.
        for(int i = 0; i <= this.currentIndex-1; i++) //++ -> get then increment
        {
            //if the found index is the index i want to add
            if (i == indexToAdd)
            {
                //shift the list items by one to right.
                for(int k = (this.currentIndex+1); k > i; k--)
                {
                    this.list[k] = this.list[k-1];
                }
            }
        }

        this.list[indexToAdd] = value;

        //increase the current index by 1.
        this.currentIndex++;
    }

    //Method - function to delete a value by index
    public void remove(int indexToDelete)
    {
        //if the index to be deleted is smaller than 0 and bigger than current 'last' index
        if(indexToDelete < 0 && indexToDelete >= this.currentIndex)
        {
            throw new IndexOutOfBoundsException("Index "+indexToDelete+" is out of bounds!");
        }

        //list:  1, 4, 50, 23, 5, 7
        //index:  0, 1,  2,  3, 4, 5
        // locate the wished index to delete.
        for(int i = 0; i <= this.list.length-1; i++) //get then increment
        {
            // if the found index is the index i want to delete
            if (i == indexToDelete)
            {
                //then shift the list items by one to left.
                for(int k = i; k < this.list.length-1; k++)
                {
                    //list[2] = list[2+1];
                    this.list[k] = this.list[k + 1];
                }
            }
        }
        //and decrease the current index by 1.
        this.currentIndex--;
    }

    //Method - function to get a value by index
    public int get(int index){

        if(index < 0 && index >= this.currentIndex) {
            throw new IndexOutOfBoundsException("Index "+index+" is out of bounds!");
        }

        return this.list[index]; //get wanted index from list
    }

    //Method - Function to get the list size
    public int size() {
        // returns last current index in list
        return this.currentIndex;
    }

    //Method - Function to clear the array list
    public void clear(){
        //make new list with size 20
        this.list = new int[20];
        this.currentIndex = 0; //start at 0
    }
    //Method - toString
    public String toString(){
        String txt = "[";

        for (int i = 0; i < this.currentIndex-1; i++){
            txt += this.list[i]+", ";
        }
        txt += this.list[(this.currentIndex-1)];

        return txt+"]";
    }
}
