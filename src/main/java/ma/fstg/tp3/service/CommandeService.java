package ma.fstg.tp3.service;

import ma.fstg.tp3.bean.Commande;
import ma.fstg.tp3.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {

    public int save(Commande commande){
        if(findByRef(commande.getRef())!=null){
            return -1;
        }else if(commande.getTotal()<commande.getTotalPaye()){
            return -2;
        }else{
            commandeDao.save(commande);
            return 1;
        }
    }
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    public List<Commande> findByTotal(double total) {
        return commandeDao.findByTotal(total);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
    @Transactional
    public int deleteByRef(String ref) {
        return commandeDao.deleteByRef(ref);
    }

    @Autowired
    private CommandeDao commandeDao;
}
