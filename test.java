import java.util.Scanner;

public class test {
    static int stunum=0;
    static StuData[] stu = new StuData[30];
    public static class StuData{
    StringBuilder name = new StringBuilder();
    Integer age = new Integer(0);
    Integer high = new Integer(0);
/*     char[] name;
    int age = 0;
    int high = 0; */
    }
    
    public static void main(String[] args) {
        
        int times = 3;
        String truename ="admin";
        String truepwd = "qwer";
        String name = new String();
        String pwd = new String();
        /* Console cons = System.console();
            String username = cons.readline("User name: ");
            char[] passwd = cons.readPassword("Password: "); 
            这个方法可以使密码不可见
            */
        Scanner user = new Scanner(System.in);
        Scanner password = new Scanner(System.in);
        while(times>0)
        {
            System.out.println("user:");
            name=user.nextLine();
            System.out.println("password:");
            pwd=password.nextLine();
/*             System.out.println(name);
            System.out.println(pwd); */
            if(name.equals(truename)&&pwd.equals(truepwd))
            {
                    System.out.println("登录成功！");
                    meau();
                    break;
            }
            else{
                times--;
                System.out.println("登录失败，还有"+times+"次机会！");
                
            }
            if(times==0)
            {
                System.out.println("登录超次，系统退出");
            }
        }
    }
    public static void meau()
    {
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.增加信息");
            System.out.println("2.删除信息");
            System.out.println("3.修改信息");
            System.out.println("4.浏览信息");
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            if(sc.hasNextInt())
            {
                int n = sc.nextInt();
                switch(n)
                {
                    case 1:
                        AddInfor();
                        break;
                    case 2:
                        delinfor();
                        break;
                    case 3:
                        changeinfor();
                        break;
                    case 4:
                        showData();
                        break;
                    case 0:
                        System.exit(0);
                        //break;
                    default:
                        meau();
                }
            }
        }  
    }
    public static void AddInfor()
    {
        if(stunum>=30) return ;
        StuData Student = new StuData();
        Scanner nameadd = new Scanner(System.in);
        Scanner ageadd = new Scanner(System.in);
        Scanner highadd = new Scanner(System.in);
        String flag = new String();
        System.out.println("姓名:");
        StringBuilder name1 = new StringBuilder(nameadd.nextLine());
        Student.name = name1;
        System.out.println("年龄:");
        flag=ageadd.nextLine();
        Student.age=Integer.parseInt(flag);
        System.out.println("身高:(单位:cm)");
        flag=highadd.nextLine();    
        Student.high=Integer.parseInt(flag);
        stu[stunum]=Student;
        stunum++;
    }
    public static void showData()
    {
        for (int i = 0; i < stunum; i++) {
            System.out.println("序号:"+i+" 姓名:"+stu[i].name+" 年龄:"+stu[i].age+" 身高:"+stu[i].high+"cm ");
        }
    }
    public static void delinfor()
    {
        showData();
        Scanner number = new Scanner(System.in);
        String flag = new String();
        Integer num = new Integer(0);
        System.out.println("请输入要删除的序号:");
        flag=number.nextLine();
        num = Integer.parseInt(flag);
        if(num<=stunum&&num>=0)
        {
            for (int i = num; i < stunum-1; i++) {
                stu[i]=stu[i+1];
            }
            stunum--;
        }
        else{
            System.out.println("输入错误，请重新输入");
            delinfor();
        }
    }
    public static void changeinfor()
    {
        showData();
        Scanner number = new Scanner(System.in);
        Scanner number1 = new Scanner(System.in);
        Scanner namec = new Scanner(System.in);
        String flag = new String();
        Integer num = new Integer(0);
        Integer num1 = new Integer(0);
        System.out.println("请输入要修改的序号:");
        flag=number.nextLine();
        num = Integer.parseInt(flag);//储存的序号
        System.out.println("请选择要修改的属性:\n1.姓名\n2.年龄\n3.身高");
        flag=number1.nextLine();
        num1 = Integer.parseInt(flag);//储存的修改项
        if(num1==1)
        {
            System.out.println("请输入修改后的名字:");
            StringBuilder flag1 = new StringBuilder(namec.nextLine());
            stu[num].name = flag1;
        }
        if(num1==2)
        {
            System.out.println("请输入修改后的年龄:");
            Integer flag1 = new Integer(namec.nextLine());
            stu[num].age = flag1;
        }
        if(num1==3)
        {
            System.out.println("请输入修改后的身高:");
            Integer flag1 = new Integer(namec.nextLine());
            stu[num].high = flag1;
        }
        else{
            System.out.println("输入错误");
        }
    }
    
}
