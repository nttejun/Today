package today;

import com.sun.javafx.binding.StringFormatter;

/**
 * Created by nttej on 2017-09-23.
 */
public class UserDO {

    private String userId;
    private String userPassword;
    private String userName;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = this.userId;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = this.userPassword;
    }

    public String getUserName(){ return userName; }

    public void setUserName(String userName){ this.userName = this.userName; }

}
