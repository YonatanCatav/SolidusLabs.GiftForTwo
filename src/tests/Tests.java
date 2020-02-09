import com.soliduslabs.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static com.soliduslabs.GiftForTwo.getBestItems;
import static org.junit.Assert.assertEquals;

public class Tests {

    Item candyBar = new Item("Candy Bar", 500);
    Item Paperback =new Item("Paperback Book", 700);
    Item Detergent =new Item("Detergent", 1000);
    Item Headphones=new Item("Headphones", 1400);
    Item Earmuffs = new Item("Earmuffs", 2000);
    Item Bluetooth = new Item("Bluetooth Stereo", 6000);

    ArrayList<Item> items = new ArrayList<>(Arrays.asList(new Item[]{candyBar,Paperback,Detergent,Headphones,Earmuffs,Bluetooth}));

    @Test
    public void test1() throws IOException {
        assertEquals(getBestItems(items,1500), new ArrayList<>(Arrays.asList(new Item[]{Detergent, candyBar})));
    }
    @Test
    public void test2() throws IOException {
        assertEquals(getBestItems(items,2300), new ArrayList<>(Arrays.asList(new Item[]{ Headphones,Paperback})));
    }
    @Test
    public void test3() throws IOException {
        assertEquals(getBestItems(items,10000), new ArrayList<>(Arrays.asList(new Item[]{ Bluetooth,Earmuffs})));
    }
    @Test
    public void onlyOneItem() throws IOException {
        ArrayList<Item> oneItemCollection = new ArrayList<>(Arrays.asList(new Item[]{candyBar}));
        assertEquals(getBestItems(oneItemCollection,10000), new ArrayList<>(Arrays.asList(null,null)));
    }
    @Test
    public void noItems() throws IOException {
        ArrayList<Item> oneItemCollection = new ArrayList<>(Arrays.asList(new Item[]{}));
        assertEquals(getBestItems(oneItemCollection,10000), new ArrayList<>(Arrays.asList(null,null)));
    }
    @Test
    public void onlyTwoAndTheyAreTooMuch() throws IOException {
        ArrayList<Item> twoItemCollection = new ArrayList<>(Arrays.asList(new Item[]{candyBar,Bluetooth}));
        assertEquals(getBestItems(twoItemCollection,1), new ArrayList<>(Arrays.asList(null,null)));
    }
    @Test
    public void onlyTwoAndTheyAreFine() throws IOException {
        ArrayList<Item> twoItemCollection = new ArrayList<>(Arrays.asList(new Item[]{candyBar,Bluetooth}));
        assertEquals(getBestItems(twoItemCollection,candyBar.getPrice()+Bluetooth.getPrice()), new ArrayList<>(Arrays.asList(new Item[]{Bluetooth,candyBar})));
    }
}
