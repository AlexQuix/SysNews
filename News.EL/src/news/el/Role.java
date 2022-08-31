
package news.el;
import java.util.ArrayList;

public class Role {
    //PROPIEDADES -----------------
    private int IdRole;
    
    private String RoleName;
    
    private ArrayList<User> Users;

    //CONSTRUCTORES ----------------
    public Role() {
    }

    public Role(int IdRole, String RoleName) {
        this.IdRole = IdRole;
        this.RoleName = RoleName;
    }
    
    //METODOS GET Y SET ------------

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }
}
