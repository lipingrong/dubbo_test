import com.pingrong.core.bean.UserInfo;
import com.pingrong.core.dao.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestOne {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    public void tests() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(10);
        userInfo.setName("新来的");
        userInfoMapper.insert(userInfo);
    }
}
