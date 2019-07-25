import org.jaxen.function.StringFunction;

import java.io.*;
import java.util.*;
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLenth = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String[comSize];        //保存字符串
        String temp;                                 //临时字符串
        int [] coords = new int[comSize];                   //现有字符串
        int attempts = 0;                                   //目前测试的字符串
        boolean success = false;                             //找到合适位置吗
        int location;                                   //目前起点

        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1){
            incr = gridLenth;
        }

        while (!success & attempts++<200){
            location = (int) (Math.random()*gridSize);
            System.out.print("try"+location);
            int x = 0;
            success = true;
            while (success && x < comSize){
                if (grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize){
                        success = false;
                    }
                    if (x>0 && (location % gridLenth == 0)){
                        success = false;
                    }else {
                        System.out.print("used"+location);
                        success = false;
                    }
                }
            }
            //int x = 0;
            int row;
            int column;
            System.out.println("\n");
            while (x < comSize){
                grid[coords[x]] = 1;
                row = (int) (coords[x]/gridLenth);
                column = coords[x]%gridLenth;
                temp = String.valueOf(alphabet.charAt(column));

                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
                System.out.print("coord "+x+"="+alphaCells.get(x-1));

            }
            System.out.println("\n");
        }
        return alphaCells;
    }
}
