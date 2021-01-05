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

            InputStream inPro = Class.forName("Test").getResourceAsStream("/Porduct.xlsx");
            ReadUsersExcel readExcel = new ReadUsersExcel();
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername().trim()) && password.equals(users[i].getPassword().trim())) {
                    System.out.println("登录成功");
                    bo=false;
                    /*
                    显示商品信息
                     */
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[]=readProductExcel.getAllProduct(inPro);
                    for (Product product:products){
                        System.out.print(product.getID());
                        System.out.print("\t"+product.getName());
                        System.out.print("\t"+product.getPrice());
                        System.out.println("\t"+product.getDescription());
                    }
                    int count=0;
                    Product productes[]=new Product[3];
                    System.out.println("请输入商品ID，把该商品加入购物车:");
                    String pid =sc.next();
                    ReadProductExcel readProductExcel1=new ReadProductExcel();
                    inPro=null;
                    inPro = Class.forName("Test").getResourceAsStream("/Porduct.xlsx");
                    Product product=readProductExcel.getproductById(pid,inPro);
                    if (product!=null){
                       productes[count++]=product;
                    }
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }

}
