package com.rest.services;

import com.rest.models.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class CountryService {

    private static EntityManager em = Persistence.createEntityManagerFactory("ConnectionJPA").createEntityManager();
    
    //Вывод информации по id
    @RequestMapping("/country")
    @ResponseBody
    Country country(@RequestParam(value="id") int id){
        return em.find(Country.class, id);
    }
    
    //Вывод всех стран
    @RequestMapping("/all")
    @ResponseBody
    List<Country> all(){
        return em.createQuery("SELECT c FROM Country c").getResultList();
    }
    
    //Вывод топ 5
    @RequestMapping("/top5")
    @ResponseBody
    List<Country> top5(){
        return em.createQuery("SELECT c FROM Country c ORDER BY c.population DESC").setMaxResults(5).getResultList();
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CountryService.class, args);
    }
}
