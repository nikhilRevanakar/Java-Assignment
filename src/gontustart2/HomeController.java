package gontustart2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String homeInit()
    {
        return "home";
    }
    @RequestMapping("/showForm")
    public String showForm(Model model)
    {
    	Employee e=new Employee();
    	model.addAttribute("employee", e);
    	return "next-page";
    }
    
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("employee") Employee theEmployee,Model model)
    {
    	System.out.println("Employee id is="+theEmployee.getEid());
    	System.out.println("Employee name is="+theEmployee.getEname());
    	System.out.println("Employee city is="+theEmployee.getCity());
    	return "process-form";
    }
    
    
}