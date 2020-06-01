package bean;
import java.io.Serializable;
public class Student {
     public String id;
     public  String userName;
     public  String xb;
     public  String mima;
 
     public Student(String id,String userName,String xb,String mima) {
    super();
    this.id = id;
    this.userName = userName;
    this.xb = xb;
    this.mima = mima;
     }

     public Student() {
        super();
      }

public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getXb() {
    return xb;
}
public void setXb(String xb) {
    this.xb = xb;
}
public String getMima() {
    return mima;
}
public void setMima(String mima) {
    this.mima = mima;
}
 
}