package pl.sda.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerDao workerDao;


    @RequestMapping("worker")
    public String getAllWorker(Model model) {

        List<Worker> worker = workerDao.findAll();
        model.addAttribute("worker", worker);
        return "home/worker";
    }
}
