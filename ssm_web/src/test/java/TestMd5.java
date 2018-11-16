import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestMd5 {

    @Test
    public void test(){

        Md5Hash md5 = new Md5Hash("123","ha",2);

        System.out.println(md5.toString());
    }
}
