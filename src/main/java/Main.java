import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static HashMap<Integer, Integer> bookScoresMap = new HashMap<>();

    public static void main(String[] args) {

        File myObj = new File("last.txt");
        int B, L = 0, D = 0;
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
                ds.id = counter - 1;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<Integer> iterator = libraryMap.keySet().iterator();
        List<DS> dsList = new ArrayList<>();

        while (iterator.hasNext()) {
            int key = iterator.next();
            DS ds = libraryMap.get(key);
            dsList.add(ds);
        }

        dsList.sort((o1, o2) -> {
            long score1 = o1.library.noOfBooks / o1.library.daily;
            long score2 = o2.library.noOfBooks / o2.library.daily;

            if (score1 > score2) {
                return 1;
            }
            else if(score1 < score2){
                return -1;
            }else{
                return 0;
            }
        });

        int tempCount = D;
        List<DS> copyList = new ArrayList<>();

        for(int i=0;i<dsList.size();i++){
            DS item = dsList.get(i);
            tempCount -= item.library.setupTime;
            if(tempCount >=0){
                copyList.add(item);
            }
        }

        String result = "";

        //dsList.forEach(System.out::println);
        result += copyList.size() + "\n";
        int tdays = D, remDays = 0;
        Set<Book> processedBooks = new HashSet<>();
        for (int i = 0; i < copyList.size(); i++) {
            DS item = copyList.get(i);
            item.removeProcessed(processedBooks);
            result+= item.id + " " + Math
                    .min(((tdays - item.library.setupTime) * item.library.daily), item.bookSet.size())+"\n";
            tdays -= item.library.setupTime;

            for (Book book : item.bookSet) {
                if (processedBooks.add(book)) {
                    String s = book.id + " ";
                    result+= s ;
                }
            }

            result+="\n";
        }

        try (FileWriter fileWriter = new FileWriter("./output2")) {
            fileWriter.write(result);
        }
        catch (IOException e) {
            // exception handling
        }


    }

    static HashMap<Integer, Integer> buildBookMap(String scores) {
        String[] str = scores.split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            map.put(i, Integer.valueOf(str[i]));
        }
        return map;
    }
}
