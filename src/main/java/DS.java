import java.util.TreeSet;

public class DS {

    private String libStr;
    private String books;
    TreeSet<Integer> bookSet = new TreeSet<>();
    Library          library = new Library();



    public TreeSet<Integer> getBookSet() {
        return bookSet;
    }

    public Library getLibrary() {
        return library;
    }


    public void setLibStr(String libStr) {
        this.libStr = libStr;
        library.setN(Long.parseLong(libStr.split(" ")[0]));
        library.setT(Long.parseLong(libStr.split(" ")[1]));
        library.setM(Long.parseLong(libStr.split(" ")[2]));
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
        for (String s : books.split(" ")) {
            int i = Integer.parseInt(s);
            bookSet.add(i);
        }
    }

    public long getTotalScore(){
        long sum = 0;
        for(int i : bookSet){
            sum+=Main.bookScoresMap.get(i);
        }
        return sum;
    }

}
