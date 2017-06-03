package common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class CellWorld {
	static int height;
	static int width;
	int[][] cellWorld;
	int[][] cellWorldNext;
	int counter = 0;
	ArrayList<Point> coordinate;
	public void initialize(ArrayList<Point> input){
		coordinate = (ArrayList<Point>)(input.clone());
		int listLength = coordinate.size();
		for (int i = 0; i < listLength; i++){
			Point point = coordinate.get(i);
			int x = point.x;
			int y = point.y;
			cellWorld[x][y] = 1;
		}
	
	}
	public CellWorld(int H, int W){
		cellWorld = new int[H][W];
		height = H;
		width = W;
	}
	public ArrayList<Point> Next(){
		cellWorldNext = cellWorld.clone();
		int state;
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				state = checkState(i, j);
				if (state == 3){
					cellWorldNext[i][j] = 1;
				}
				else if (state == 2){
					continue;
				}
				else{
					cellWorldNext[i][j] = 0;
				}
			}
		}
		
		
		
		ArrayList<Point> coordinateNext = new ArrayList<Point>();
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				if (cellWorldNext[i][j] == 1){
					Point newpoint = new Point(i, j);
					coordinateNext.add(newpoint);
				}
			}
			
		}
		
		return coordinateNext;
	}
	public int checkState(int x, int y){
		int cellCounter = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++){
				int ix = x+i;
				int jy = y+j;
				if (x==0&&y==0)
					continue;
				if (boundCheck(ix, jy)){
					if (cellWorld[ix][jy] == 1)
						cellCounter++;
				}
					
			}
		return cellCounter;
		
	}
	private boolean boundCheck(int ix, int jy) {
		if (ix < 0 || ix >= width)
			return false;
		else if (jy < 0 || jy >= height)
			return false;
		else 
			return true;
	}

	public String Next_JSON() {
		JSONArray result = new JSONArray();
		java.util.List<Point> items=new ArrayList<Point>();
		items = this.Next();
		for (Point item:items
				) {
			JSONObject json = new JSONObject();
			json.put("x",item.x);
			json.put("y", item.y);
			result.add(json);
		}
		return result.toString();
	}
	public static void main(String[] args){
		test_init();
		System.out.println("------------------");
		test_next();
	}
	public static void test_init(){
		ArrayList<Point> input = new ArrayList<Point>();
		CellWorld newCellWorld = new CellWorld(3,3);
		Point p1 = new Point(1, 0);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 2);
		input.add(p1);
		input.add(p2);
		input.add(p3);
		newCellWorld.initialize(input);
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorld[i][j] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
				System.out.println();
		}
		
		
	}
	public static void test_next(){
		ArrayList<Point> input = new ArrayList<Point>();
		CellWorld newCellWorld = new CellWorld(3,3);
		Point p1 = new Point(1, 0);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 2);
		input.add(p1);
		input.add(p2);
		input.add(p3);
		newCellWorld.initialize(input);
		newCellWorld.Next();
		for(int i=0;i<newCellWorld.width;i++)
		{
			for(int j=0;j<newCellWorld.height;j++)
			{
				if(newCellWorld.cellWorldNext[i][j] == 1)
				{
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
				System.out.println();
		}


	}

	

}

//
//		import javafx.scene.control.Cell;
//
//
//		import java.awt.*;
//		import java.util.ArrayList;
//		import java.util.List;
//
///**
// * Created by hhy on 2017/6/3.
// */
//public class Cellworld {
//	class Cell{
//		int x;
//		int y;
//	}
//	public static java.util.List<Point> Init(){
//		java.util.List<Point> result=new ArrayList<Point>();
//		result.add(new Point(0, 0));
//		result.add(new Point(0, 1));
//		return result;
//	}
//
//	public static ArrayList<Point> Next() {
//		ArrayList<Point> result=new ArrayList<Point>();
//		result.add(new Point(0, 0));
//		result.add(new Point(1, 1));
//		result.add(new Point(2, 2));
//		return result;
//	}
//
//	public static String Next_JSON() {
//		JSONArray result = new JSONArray();
//		java.util.List<Point> items=new ArrayList<Point>();
//		items = Next();
//		for (Point item:items
//				) {
//			JSONObject json = new JSONObject();
//			json.put("x",item.x);
//			json.put("y", item.y);
//			result.add(json);
//		}
//		return result.toString();
//	}
//
//	public static void main(String[] arg) {
//		test_init();
//		test_next();
//		System.out.println(Next_JSON());
//	}
//
//	public static void test_init() {
//		java.util.List<Point> result ;
//		java.util.List<Point> expect = new ArrayList<Point>();
//		expect.add(new Point(0, 1));
//		expect.add(new Point(0, 0));
//
//		result = Init();
//		boolean b = result.containsAll(expect) && expect.containsAll(result);
//		if (b) {
//			System.out.println("test ok");
//		}else {
//			System.out.println("test failed");
//		}
//	}
//
//	public static void test_next() {
//		java.util.List<Point> result ;
//		java.util.List<Point> expect = new ArrayList<Point>();
//		expect.add(new Point(0, 1));
//
//		result = Next();
//		boolean b = result.containsAll(expect) && expect.containsAll(result);
//		if (b) {
//			System.out.println("test ok");
//		}else {
//			System.out.println("test failed");
//		}
//	}
//}
