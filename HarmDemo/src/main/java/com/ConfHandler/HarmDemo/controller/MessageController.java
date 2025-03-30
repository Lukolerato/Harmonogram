package com.ConfHandler.HarmDemo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.ConfHandler.HarmDemo.repository.MessageRepository;

// @RestController
// public class MessageControler {

//     @Autowired
//     private MessageRepository exampleRepository;

//     @GetMapping("/api/message")
//     public String getMessage() {
//         return exampleRepository.findMessageById();
//     }
// }
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // <--- Dodane CORS
public class MessageController {
    @GetMapping("/message")
    public String getMessage() {
        return "Wiadomość z backendu!";
    }
}
