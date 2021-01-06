package lael.javaspring.api_doc.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户登录信息", description = "用于判断用户是否存在")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name="account",value = "用户名",dataType = "String", position = 0)
    private String account;
    @ApiModelProperty(value = "密码",position =1)
    private String password;

    public UserModel(String account, String password) {
        this.account = account;
        this.password = password;
    }
    public UserModel() {
        this.account = "defaultAccount";
        this.password = "defaultPassword";
    }
    @Override
    public String toString() {
        return "UserModel [account=" + account + ", password=" + password + "]";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
