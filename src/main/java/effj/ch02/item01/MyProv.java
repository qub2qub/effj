package effj.ch02.item01;

/**
 * Created by Denis on 26-02-2017
 */
public class MyProv implements Provider{
    static String getStr() {return "str2";};
    @Override
    public Service newService() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Provider.getStr());
        System.out.println(MyProv.getStr());
    }
}
