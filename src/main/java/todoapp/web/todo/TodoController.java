package todoapp.web.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    @RequestMapping("/todos")
    public ModelAndView todos() {
        ModelAndView mav = new ModelAndView("todos");

        return mav;
    }
}
