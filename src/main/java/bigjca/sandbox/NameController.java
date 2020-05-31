package bigjca.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NameController {

    @Autowired
    private NameService nameService;

    @GetMapping("/name")
    public String getName() {
        return nameService.getName();
    }
}
