package com.ctrlcvs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
// @SpringBootTest(classes = ArticleController.class)
public class BlogApplicationTests {

    // @Autowired
    // private UserService userService;

    // private MockMvc mockMvc;
    //
    // @Before
    // public void setUp() {
    // mockMvc = MockMvcBuilders.standaloneSetup(new
    // ArticleController()).build();
    // }
    //
    // @Test
    // public void hello() throws Exception {
    // mockMvc.perform(
    // MockMvcRequestBuilders.get("/article/hello").accept(MediaType.APPLICATION_JSON))
    // .andExpect(status().isOk()).andExpect(content().string(equalTo("hello")));
    // }

    @Test
    public void tt() {
        String[] str = "signType=2&&courseId=oJNWV9GFpvRO3e4I8RK5wA&&nowTime=1509960547484"
                .split("&&");
        String ss = str[2].substring(str[2].indexOf("=") + 1, str[2].length());
        System.out.println(ss);
        System.out.println("str1=" + str[0] + "  str2=" + str[1] + "   str3=" + str[2]);
    }

    @Test
    public void match() {
        // String str = "被评量人1手机号";
        // String str2 = "被评量人[\\s\\S]*手机号";
        // System.out.println(str.matches(str2));

        String str = "陶帅宇_1864sdf";
        List<String> list = new ArrayList<>();
        list.add(str);
        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(u -> u.substring(0, u.indexOf("_")).replaceAll("", ""),
                        u -> u.substring(u.indexOf("_") + 1, u.length())));
        System.out.println(map.get("陶帅宇"));
    }

    @Test
    public void map() {
        String str = "signType=2&&courseId=oJNWV9GFpvRO3e4I8RK5wA&&nowTime=1509960547484";
        if (str.contains("signType")) {
            String[] strings = str.split("&&");
            System.out.println(
                    strings[1].substring(strings[1].indexOf("=") + 1, strings[1].length()));
        }
    }

    @Test
    public void ttt() {
    }

}
