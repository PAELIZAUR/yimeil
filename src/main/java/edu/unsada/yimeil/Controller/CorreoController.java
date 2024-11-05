package edu.unsada.yimeil.Controller;

import edu.unsada.yimeil.models.Correo;
import edu.unsada.yimeil.repository.CorreoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/correo")

public class CorreoController {

        @Autowired
        private CorreoRepo correoRepo;
        //  {crear 2 metodos
    //1- getAllMails
    //2- SendMails}

        @GetMapping("/mostrardatos")
        public void mostrardatos(){
            System.out.println("hola mundo");
        }
        @GetMapping ("/getAllCorreo")
        public ResponseEntity<?>GetAllCorreo(){


            List<Correo> correos = (List<Correo>) correoRepo.findAll();
            return ResponseEntity.ok(correos);

        }
}
