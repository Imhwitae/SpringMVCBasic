package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("/response/hello")
                .addObject("data", "Hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "Hello!");

        return "/response/hello";
    }

    // 이 방식은 명시성이 너무 떨어지고 컨트롤러와 view의 이름이 맞는 경우가 많이 없어서 권장하지 않음
    @RequestMapping("/response/hello")  // 컨트롤러의 이름과 view의 논리적 이름이 같으면 타입을 void로 바꾸고 생략이 가능하다.
    public void responseViewV3(Model model) {
        model.addAttribute("data", "Hello!");
    }
}
