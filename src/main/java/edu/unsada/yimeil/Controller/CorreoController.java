package edu.unsada.yimeil.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/correo")

public class CorreoController {

        //  {crear 2 metodos
    //1- getAllMails
    //2- SendMails}

        @GetMapping("/mostrardatos")
        public void mostrardatos(){
            System.out.println("hola mundo");
        }
}
