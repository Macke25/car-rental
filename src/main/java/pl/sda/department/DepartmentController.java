package pl.sda.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;



    @RequestMapping("department")
    public String getAllDepartment(Model model) {

        List<Department> department = departmentDao.findAll();
        model.addAttribute("department", department);
        return "home/department";
    }
}
