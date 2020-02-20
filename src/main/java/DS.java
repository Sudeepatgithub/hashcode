import java.util.Comparator;
import java.util.TreeSet;

public class DS {

    private String libStr;
    private String books;
    TreeSet<Book> bookSet = new TreeSet<>(new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            if(o1.weight > o2.weight){
                return -1;
            }else{
                return 1;
            }
        }
    });
    Library library = new Library();
    int id;

    @Override
    public String toString() {
        return "DS{" +
                "libStr='" + libStr + '\'' +
                ", books='" + books + '\'' +
                ", bookSet=" + bookSet +
                ", library=" + library +
                ", id=" + id +
                '}';
    }

    public TreeSet<Book> getBookSet() {
        return bookSet;
    }

    public Library getLibrary() {
        return library;
    }

    public void sortWeight(){

    }

    public void setLibStr(String libStr) {
        this.libStr = libStr;
        library.setNoOfBooks(Long.parseLong(libStr.split(" ")[0]));
        library.setSetupTime(Long.parseLong(libStr.split(" ")[1]));
        library.setDaily(Long.parseLong(libStr.split(" ")[2]));
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
        for (String s : books.split(" ")) {
            int i = Integer.parseInt(s);
            Book book = new Book();
            book.setId(i);
            book.setWeight(Main.bookScoresMap.get(i));
            bookSet.add(book);
        }
    }


    public long getTotalScore() {
        long sum = 0;
        for (Book i : bookSet) {
            sum += Main.bookScoresMap.get(i.getWeight());
        }
        return sum;
    }
}
