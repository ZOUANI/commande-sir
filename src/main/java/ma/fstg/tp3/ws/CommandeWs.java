package ma.fstg.tp3.ws;

import ma.fstg.tp3.bean.Commande;
import ma.fstg.tp3.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecom/commande")
public class CommandeWs {
    // save post, find get, update put, delete delete
    // lien(string int char ..) : pathVariable body (bean) : reuestBody

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }
    @GetMapping("/total/{total}")
    public List<Commande> findByTotal(@PathVariable double total) {
        return commandeService.findByTotal(total);
    }
    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }

    @Autowired
    private CommandeService commandeService;
}
