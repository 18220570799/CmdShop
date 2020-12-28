import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        while (bo) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");

            String username = sc.next();

            System.out.println("请输入密码：");
            String password = sc.next();

            //File file = new File("C:\\Users\\lenovo\\IdeaProjects\\CmdShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadExcel readExcel = new ReadExcel();
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername().trim()) && password.equals(users[i].getPassword().trim())) {
                    System.out.println("登录成功");
                    bo=false;
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }

}
