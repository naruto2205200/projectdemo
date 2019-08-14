package com.example.demo.utils;

import com.example.demo.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/1117:39
 */
public class UserUtils {


    public static List<User> getUserList(){
        List<User> resutl = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        user1.setAge(20);
        user1.setAddress("北京市昌平区回龙观");
        user1.setPhone("13100552565");
        user1.setHeadPortrait("../../images/0d4ad6027c3e143399bd2188fd61504b.jpg");
        resutl.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("张颂");
        user2.setAge(20);
        user2.setAddress("北京市海淀区西二旗");
        user2.setPhone("13100586565");
        user2.setHeadPortrait("../../images/6018121caab3a06b4b208545143fe13e.jpg");
        resutl.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("何苦");
        user3.setAge(15);
        user3.setAddress("河北省保定市阜平");
        user3.setPhone("18569542315");
        user2.setHeadPortrait("C:\\Users\\user\\Pictures\\Camera Roll\\u=2077870544,328407130&fm=26&gp=0.jpg");
        resutl.add(user3);

        User user4 = new User();
        user4.setId(4);
        user4.setName("周泽楷");
        user4.setAge(30);
        user4.setAddress("福建省厦门邵武");
        user4.setPhone("19158654263");
        resutl.add(user4);

        User user5 = new User();
        user5.setId(5);
        user5.setName("杨玉环");
        user5.setAge(35);
        user5.setAddress("福建省莆田石狮");
        user5.setPhone("18152645856");
        resutl.add(user5);

        User user6 = new User();
        user6.setId(6);
        user6.setName("李洛克");
        user6.setAge(15);
        user6.setAddress("甘肃省天水玉门");
        user6.setPhone("18568545685");
        resutl.add(user6);

        User user7 = new User();
        user7.setId(7);
        user7.setName("李玲玉");
        user7.setAge(13);
        user7.setAddress("甘肃省酒泉敦煌");
        user7.setPhone("13569693562");
        resutl.add(user7);

        User user8 = new User();
        user8.setId(8);
        user8.setName("赵珊珊");
        user8.setAge(8);
        user8.setAddress("北京市海淀区马连洼");
        user8.setPhone("19155585652");
        resutl.add(user8);

        User user9 = new User();
        user9.setId(9);
        user9.setName("马媛媛");
        user9.setAge(10);
        user9.setAddress("北京市海淀区西二旗");
        user9.setPhone("15566325265");
        resutl.add(user9);

        User user10 = new User();
        user10.setId(10);
        user10.setName("乾隆");
        user10.setAge(18);
        user10.setAddress("北京市西城区鼓楼");
        user10.setPhone("13785695456");
        resutl.add(user10);

        User user11 = new User();
        user11.setId(11);
        user11.setName("唐婷婷");
        user11.setAge(22);
        user11.setAddress("北京市西城区陶然亭");
        user11.setPhone("13896548565");
        resutl.add(user11);

        User user12 = new User();
        user12.setId(12);
        user12.setName("马欢欢");
        user12.setAge(32);
        user12.setAddress("湖北省武汉丹江口");
        user12.setPhone("18855565548");
        resutl.add(user12);

        User user13 = new User();
        user13.setId(13);
        user13.setName("王伟伟");
        user13.setAge(28);
        user13.setAddress("北京市通州区草房");
        user13.setPhone("18866963215");
        resutl.add(user13);

        User user14 = new User();
        user14.setId(14);
        user14.setName("应欢欢");
        user14.setAge(26);
        user14.setAddress("江西省南昌");
        user14.setPhone("13854568554");
        resutl.add(user14);

        User user15 = new User();
        user15.setId(15);
        user15.setName("李丹丹");
        user15.setAge(45);
        user15.setAddress("江苏省宜兴");
        user15.setPhone("13858545696");
        resutl.add(user15);

        return resutl;
    }
}
