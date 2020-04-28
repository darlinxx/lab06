package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String home(Model model, String opcja, CalculatorForm dane) {
        if(dane.getX() == null) dane.setX(0);
        if(dane.getY() == null) dane.setY(0);
        if(dane.getZ() == null) dane.setZ(0);
        if(dane.getOperacja() == null) dane.setOperacja("+");
        if(opcja != null){
            switch(opcja){
                
                case "dodaj":
                    int z=dane.getX()+ dane.getY();
                    dane.setZ(z);
                    dane.setOperacja("+");
                    break;
                case "odejmij":
                    z=dane.getX()- dane.getY();
                    dane.setZ(z);
                    dane.setOperacja("-");
                    break;
                case "pomnoz":
                    z=dane.getX()* dane.getY();
                    dane.setZ(z);
                    dane.setOperacja("*");
                    break;
            }
        }
        String operacja=dane.getOperacja();
        model.addAttribute("operacja",operacja);
        
        Integer x=dane.getX();
        model.addAttribute("x",x);
        
        Integer y=dane.getY();
        model.addAttribute("y",y);
        
        Integer z=dane.getZ();
        model.addAttribute("z",z);
        
        
        return "home";
   
    
    
    
    }
    
}
