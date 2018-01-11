package com.ctrlcvs;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrlcvs.excel.user;
import com.ctrlcvs.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
        List<String> list = new ArrayList<>();
        list.add("小陶");
        list.add("小花");
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        // TODO 将object 放进context
        context.setVariable("message", list);
        List value = parser.parseExpression("#message").getValue(context, List.class);
        value.forEach(System.out::println);
    }

    @Test
    public void method() throws IOException {
        String str = "小陶1";
        if (str.contains("1")) {
            str += "haha";
        } else if (str.contains("花花")) {
            str += "huahua";
        }
        System.out.println(str);
    }

}
