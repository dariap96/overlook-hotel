package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.Services.AdminService;
import itmo.com.overlook.hotel.Services.ClientService;
import itmo.com.overlook.hotel.Services.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final ClientService clientService;
    private final AdminService adminService;
    private final DirectorService directorService;

    public UserController(ClientService clientService, AdminService adminService, DirectorService directorService){
        this.clientService = clientService;
        this.adminService = adminService;
        this.directorService = directorService;
    }

    @GetMapping
    public void index(){

    }
}
