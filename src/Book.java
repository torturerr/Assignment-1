public class Book {
    private int id;
    private static int idGen=1;
    private String title;
    private String author;
    private int year;
    private boolean available;
    public Book(){
        id = idGen++;
        available=true;
    }
    public void setTitle(String title){
        if(title==null||title.isEmpty()){
            throw new IllegalArgumentException("The title cannot be null or empty");
        }
        this.title=title;
    }
    public void setAuthor(String author){
        if(author==null||author.isEmpty()){
            throw new IllegalArgumentException("Author must not be null or empty");
        }
        this.author=author;
    }
    public void setYear(int year){
        int Currentyear=2025;
        if(year<1500||year>Currentyear){
            throw new IllegalArgumentException("Year is not in the reasonable range");
        }
        this.year=year;
    }
    public Book(String title, String author, int year){
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }
    public boolean getAvailable(){
        return available;
    }
    public void markAsBorrowed(){
        available=false;
    }
    public void markAsReturned(){
        available=true;
    }
    @Override
    public String toString(){
        return "Book (id="+id+"title="+title+"author="+author+"year="+year+"available status="+available+")";
    }
}
