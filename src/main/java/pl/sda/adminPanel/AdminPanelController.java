package pl.sda.adminPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminPanelController {

    @ModelAttribute("module")
    String module() {
        return "adminPanel";
    }

    @GetMapping("/adminPanel")
    @Secured("ROLE_ADMIN")
    String adminPanel() {
        return "admin/adminPanel";
    }

}
