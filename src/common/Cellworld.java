package common;


import javafx.scene.control.Cell;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhy on 2017/6/3.
 */
public class Cellworld {
    class Cell{
        int x;
        int y;
    }
    public static List<Point> Init(){
        List<Point> result=new ArrayList<Point>();
        result.add(new Point(0, 0));
        result.add(new Point(0, 1));
        return result;
    }

    public static ArrayList<Point> Next() {
        ArrayList<Point> result=new ArrayList<Point>();
        result.add(new Point(0, 0));
        result.add(new Point(1, 1));
        result.add(new Point(2, 2));
        return result;
    }

    public static String Next_JSON() {
        JSONArray result = new JSONArray();
        List<Point> items=new ArrayList<Point>();
        items = Next();
        for (Point item:items
             ) {
            JSONObject json = new JSONObject();
            json.put("x",item.x);
            json.put("y", item.y);
            result.add(json);
        }
        return result.toString();
    }

    public static void main(String[] arg) {
        test_init();
        test_next();
        System.out.println(Next_JSON());
    }

    public static void test_init() {
        List<Point> result ;
        List<Point> expect = new ArrayList<Point>();
        expect.add(new Point(0, 1));
        expect.add(new Point(0, 0));

        result = Init();
        boolean b = result.containsAll(expect) && expect.containsAll(result);
        if (b) {
            System.out.println("test ok");
        }else {
            System.out.println("test failed");
        }
    }

    public static void test_next() {
        List<Point> result ;
        List<Point> expect = new ArrayList<Point>();
        expect.add(new Point(0, 1));

        result = Next();
        boolean b = result.containsAll(expect) && expect.containsAll(result);
        if (b) {
            System.out.println("test ok");
        }else {
            System.out.println("test failed");
        }
    }
}
