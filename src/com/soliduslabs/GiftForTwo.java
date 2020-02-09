package com.soliduslabs;

import javax.print.attribute.standard.JobStateReason;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GiftForTwo {

    private static Item getItem(String line,Pattern pattern)
    {
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        int price = Integer.parseInt(matcher.group("price"));
        String id = matcher.group("id");
        return new Item(id,price);
    }
    public static List<Item> getBestItems(List<Item> items,int sum)
    {
        if(items.size()<2)
        {
            return new ArrayList<>(Arrays.asList(null, null));
        }
        ListIterator<Item> decendingItemsIterator = items.listIterator();
        ListIterator<Item> ascendingItemsIterator = items.listIterator(items.size());

        Item selectedLowerPricePresent = null;
        Item selectedHigherPricePresent = null;
        int bestSum = 0;

        Item currentDecendingItem = decendingItemsIterator.next();
        Item currentAscendingItem = ascendingItemsIterator.previous();

        while(currentDecendingItem!=currentAscendingItem) {
            int currentItemsSum = currentDecendingItem.Price + currentAscendingItem.Price;
            if (currentItemsSum > sum) {
                currentAscendingItem = ascendingItemsIterator.previous();
            } else {
                if (bestSum < currentItemsSum) {
                    selectedLowerPricePresent = currentDecendingItem;
                    selectedHigherPricePresent = currentAscendingItem;
                    bestSum = currentItemsSum;
                }
                currentDecendingItem = decendingItemsIterator.next();
            }
        }
        return new ArrayList<>(Arrays.asList(selectedHigherPricePresent,selectedLowerPricePresent));
    }
    public static void main(String[] args) throws IOException {

        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream ("items.txt");
        ArrayList<Item> items = new ArrayList<>();
        int sum;

        if(args.length==2) {
            File initialFile = new File(args[0]);
            stream = new FileInputStream(initialFile);
            sum = Integer.parseInt(args[1]);
        }
        else
        {
            sum = Integer.parseInt(args[0]);
        }

        Pattern pattern = Pattern.compile("(?<id>.*), (?<price>\\d+)");
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        String line=r.readLine();
        while (line != null) {
            items.add(getItem(line,pattern));
            line=r.readLine();
        }
        List<Item> listItem = getBestItems(items,sum);
        if(listItem.get(0)==null&&listItem.get(1)==null)
        {
            System.out.println("Not possible");
        }
        else
        {
            System.out.println(listItem.get(0).Name + " " + listItem.get(0).getPrice() + ", " + listItem.get(1).Name + " " + listItem.get(1).getPrice() );
        }
    }
}
