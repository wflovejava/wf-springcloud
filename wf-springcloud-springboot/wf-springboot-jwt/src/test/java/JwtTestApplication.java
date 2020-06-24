import com.wf.common.service.UserService;
import com.wf.jwt.WFJwtApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ：wf
 * @Date ：2020/6/24 11:13
 * @Describe：
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WFJwtApplication.class)
public class JwtTestApplication {
    @Autowired
    UserService userService;

    @Test
    public void test(){
        userService.queryById(1);
    }
}
