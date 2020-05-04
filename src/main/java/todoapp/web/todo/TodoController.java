package todoapp.web.todo;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import todoapp.web.model.SiteProperties;

@Controller
public class TodoController {

    /*@RequestMapping("/todos")
    public ModelAndView todos() {
        ModelAndView mav = new ModelAndView("todos");
        return mav;
    }*/

    private Environment env;
    private SiteProperties properties;

    public TodoController(Environment env, SiteProperties properties) {
        this.env = env;
        this.properties = properties;
    }

    @RequestMapping("/todos")
    public  ModelAndView todos() {
        ModelAndView mav = new ModelAndView("todos");
        mav.addObject("site", properties);

        return mav;
    }
}
