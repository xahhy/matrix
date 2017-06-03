import java.util.ArrayList;

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
			cellWorld[y][x] = 1;
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
				state = checkState(j, i);
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
		if (ix < 0 || ix > width)
			return false;
		else if (jy < 0 || jy > height)
			return false;
		else 
			return true;
	}

	public static void main(String args){
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
				System.out.println();
			}
		}
		
		
	}

	

}
