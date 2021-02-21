package main.dummy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DummyDatabase {

    public static String mime = "wtdb";

    public static boolean addObject(File file, Object object) throws IOException
    {
        if(file.getName().endsWith(mime))
        {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println(object.toString());
            pw.close();
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean containsObject(File file, Object object) throws IOException
    {
        if(file.getName().endsWith(mime))
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean IsGood = false;
            while(br.ready())
            {
                String line = br.readLine();
                if(line.trim().equals(object.toString()))
                {
                    IsGood = true;
                }
            }
            br.close();
            return IsGood;
        }
        else
        {
            return false;
        }
    }

    public static boolean removeObject(File file, Object object) throws IOException
    {
        if(file.getName().endsWith(mime))
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean IsGood = false;
            ArrayList<String> linestoadd = new ArrayList<String>();
            while(br.ready())
            {
                String line = br.readLine();
                if(!line.trim().equals(object.toString()))
                {
                    linestoadd.add(line.trim());
                }
                else
                {
                    IsGood = true;
                }
            }
            br.close();
            BufferedWriter fileclearer = new BufferedWriter(new FileWriter(file));
            fileclearer.write("");
            fileclearer.close();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            for(String linetoadd : linestoadd)
            {
                pw.println(linetoadd);
            }
            pw.close();
            return IsGood;

        }
        else
        {
            return false;
        }
    }

    public static ArrayList<String> getContents(File file) throws IOException
    {
        ArrayList<String> contents = new ArrayList<String>();
        if(file.getName().endsWith(mime))
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready())
            {
                contents.add(br.readLine());
            }
            br.close();
        }
        return contents;
    }
}