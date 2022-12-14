package com.sukhoev.psms.registration;

import com.sukhoev.psms.appuser.entity.AppUser;
import com.sukhoev.psms.appuser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @RequestMapping
    public String registration(Model model) {
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "registration";
    }

    @PostMapping()
    public String registration(@ModelAttribute RegistrationRequest registrationRequest) {

        registrationService.registration(registrationRequest);
        return "confirm-email";
    }

    @GetMapping(path = "{token}")
    public String confirm(@PathVariable("token") String token) {
        registrationService.confirmationToken(token);
        return "email-confirmed";
    }
}

