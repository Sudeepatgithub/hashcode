import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer,Integer> bookScoresMap = new HashMap<>();
    public static void main(String[] args) {

        File myObj = new File("text");
        int B, L = 0, D;
        String bookScores = "";
        int counter = 0;
        Map<Integer, DS> libraryMap = new HashMap<>(L);
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (counter == 0) {
                    String data = myReader.nextLine();
                    B = Integer.parseInt(data.split(" ")[0]);
                    L = Integer.parseInt(data.split(" ")[1]);
                    D = Integer.parseInt(data.split(" ")[2]);
                    counter++;
                }
                else if (counter == 1) {
                    String data = myReader.nextLine();
                    bookScores = data;
                    counter++;
                }
                else {
                    break;
                }
            }
            bookScoresMap = buildBookMap(bookScores);
            counter = 0;
            while (myReader.hasNextLine() && counter < L) {
                DS ds = new DS();
                ds.setLibStr(myReader.nextLine());
                ds.setBooks(myReader.nextLine());
                libraryMap.put(counter++, ds);
                ds.id = counter-1;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<Integer> iterator = libraryMap.keySet().iterator();
        List<DS> dsList = new ArrayList<>();

        while(iterator.hasNext()){
            int key = iterator.next();
            DS ds= libraryMap.get(key);
            dsList.add(ds);
        }

        dsList.sort((o1, o2) -> {
            long score1 = o1.library.noOfBooks/o1.library.daily;
            long score2 = o2.library.noOfBooks/o2.library.daily;

            if(score1 > score2){
                return 1;
            }else{
                return -1;
            }
        });

        dsList.forEach(System.out::println);

        
    }

    static HashMap<Integer,Integer> buildBookMap(String scores){
        String str[] = scores.split(" ");
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<str.length;i++){
           map.put(i, Integer.valueOf(str[i]));
        }
        return map;

    }
}
