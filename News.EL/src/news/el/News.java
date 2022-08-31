package news.el;


import java.time.LocalDate;

public class News {
    
    //PROPIEDADES ------------------
    private int IdNews;
    
    private int IdUser;
    
    private String Tittle;
    
    private String Category;
    
    private String Description;
    
    private LocalDate DateNews;
    
    private String ImageNews;
    
    private User User;
    
    
    //CONSTRUCTORES ----------------
    public News() {
    }

    public News(int IdNews, int IdUser, String Tittle, String Category, String Description, LocalDate DateNews, String ImageNews) {
        this.IdNews = IdNews;
        this.IdUser = IdUser;
        this.Tittle = Tittle;
        this.Category = Category;
        this.Description = Description;
        this.DateNews = DateNews;
        this.ImageNews = ImageNews;
    }

    //METODOS GET Y SET --------------
    public int getIdNews() {
        return IdNews;
    }

    public void setIdNews(int IdNews) {
        this.IdNews = IdNews;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDate getDateNews() {
        return DateNews;
    }

    public void setDateNews(LocalDate DateNews) {
        this.DateNews = DateNews;
    }

    public String getImageNews() {
        return ImageNews;
    }

    public void setImageNews(String ImageNews) {
        this.ImageNews = ImageNews;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    } 
}
