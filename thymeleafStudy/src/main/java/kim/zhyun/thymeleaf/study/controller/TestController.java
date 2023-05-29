package kim.zhyun.thymeleaf.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TestController {

    @GetMapping("/")
    public String print(Model model) {
        model.addAttribute("var", "변수 보냄 - controller");
        model.addAttribute("link", "/test");

        List<Integer> list  = IntStream
                                .range(0, 10)
                                .boxed()
                                .collect(Collectors.toList());
        model.addAttribute("list", list);

        return "index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("var", "변수 보냄 - test()");
        return "index";
    }

}
