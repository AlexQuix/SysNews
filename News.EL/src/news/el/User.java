package news.el;


import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    //PROPIEDADES ------------------
    private int IdUser;

    private int IdRole;

    private String Name;
    
    private String LastName;
    
    private String Email;
    
    private String Password;

    private String PasswordConfirm;
    
    private LocalDate RegistreDate;
    
    private String ProfilePhoto;
    
    private byte IsAdmin;
    
    private Role Role;
     
    
    
    private ArrayList<News> News;
    
    //CONSTRUCTORES ----------------
    public User() {
    }
    
    public User(int IdUser, int IdRole, String Name, String LastName, String Email, String Password, LocalDate RegistreDate, String ProfilePhoto, byte IsAdmin) {
        this.IdUser = IdUser;
        this.IdRole = IdRole;
        this.Name = Name;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.RegistreDate = RegistreDate;
        this.ProfilePhoto = ProfilePhoto;
        this.IsAdmin = IsAdmin;
    }
   
    
    //METODOS GET Y SET --------------
    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPasswordConfirm() {
        return PasswordConfirm;
    }

    public void setPasswordConfirm(String PasswordConfirm) {
        this.PasswordConfirm = PasswordConfirm;
    }

    public LocalDate getRegistreDate() {
        return RegistreDate;
    }

    public void setRegistreDate(LocalDate RegistreDate) {
        this.RegistreDate = RegistreDate;
    }

    public String getProfilePhoto() {
        return ProfilePhoto;
    }

    public void setProfilePhoto(String ProfilePhoto) {
        this.ProfilePhoto = ProfilePhoto;
    }

    public byte getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(byte IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }

    public ArrayList<News> getNews() {
        return News;
    }

    public void setNews(ArrayList<News> News) {
        this.News = News;
    }
}
