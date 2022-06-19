package cn.fr13nds;

import cn.fr13nds.impl.IMongoHelper;
import cn.fr13nds.pojo.User;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMongodbApplicationTests {
    @Autowired
    private IMongoHelper iMongoHelper;

    @Test
    void contextLoads() {
    }

    @Test
    public void save() {
//        User user = new User();
//        user.setUsername("save one");
//        user.setPassword("1");
//        iMongoHelper.save(user);

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("save list");
            user.setPassword(1 + i + "");
            list.add(user);
        }
        iMongoHelper.saveList(list);
    }

    @Test
    public void remove() {
        User user = new User();
        user.setId(new ObjectId("62aeaa6efe29af53aaeecc2a"));
        iMongoHelper.removeById(user);
    }

    @Test
    public void update() {
        String[] keys = new String[]{"password"};
        String[] values = new String[]{"111111111"};
        iMongoHelper.updateById(keys, values, new ObjectId("62aeaa6efe29af53aaeecc2d"), User.class);
    }

    @Test
    public void findAll() {
//        List<User> list = iMongoHelper.findAll(User.class);

        String[] fields = new String[]{"username"};
        List<User> list = iMongoHelper.findAll(fields, User.class);
        System.out.println(list);
    }

    @Test
    public void findByMap() {
        String[] keys = new String[]{"username"};
        String[] values = new String[]{"save one"};
//        List<User> list = iMongoHelper.findByMap(keys, values, User.class);

        String[] fields = new String[]{"password"};
        List<User> list = iMongoHelper.findByMap(keys, values, fields, User.class);
        System.out.println(list);
    }

    @Test
    public void findById() {
//        User user = (User) iMongoHelper.findById(new ObjectId("62aeaa6efe29af53aaeecc29"), User.class);
        String[] fields = new String[]{"_id"};
        User user = (User) iMongoHelper.findById(new ObjectId("62aeaa6efe29af53aaeecc29"), fields, User.class);
        System.out.println(user);
    }
}
