package com.soliduslabs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemReader {
    private Pattern pattern;
    private static ItemReader itemReader;
    private ItemReader()
    {
        pattern = Pattern.compile("(.*<id>).*,(\\d+<price>)");
    }
    public static ItemReader getInstanse()
    {
        if(itemReader==null)
        {
            itemReader = new ItemReader();
        }
        return itemReader;
    }
    public Item readLine(String line)
    {
        Matcher matcher = pattern.matcher(line);
        int price = Integer.parseInt(matcher.group("price"));
        String id = matcher.group("id");
        return new Item(id,price);
    }
}
