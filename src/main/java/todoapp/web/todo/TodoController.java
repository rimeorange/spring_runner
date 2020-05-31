package todoapp.web.todo;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import todoapp.core.todos.application.TodoFinder;
import todoapp.web.convert.TodoToSpreadsheetConverter;
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
    private TodoFinder todoFinder;

    public TodoController(Environment env, SiteProperties properties, TodoFinder todoFinder) {
        this.env = env;
        this.properties = properties;
        this.todoFinder = todoFinder;
    }

    @RequestMapping("/todos")
    public  ModelAndView todos() {
        ModelAndView mav = new ModelAndView("todos");
        mav.addObject("site", properties);
        mav.addObject(new TodoToSpreadsheetConverter().convert(todoFinder.getAll()));
        return mav;
    }
}
