package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Menu;
import com.mercury.final_server.bean.Sample;
import com.mercury.final_server.bean.User;
import com.mercury.final_server.dao.MenuDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenu() {
        return menuService.getMenu();
    }

    @GetMapping("/menu/{id}")
    public Menu getOneFood(@PathVariable long id) {
        return menuService.getOneFood(id);
    }

    @PostMapping("/menu")
    public Response addOneFood(@Valid @RequestBody Menu food) {
        return menuService.addOneFood(food);
    }

    @PutMapping("/menu")
    public Response updateMenu(@RequestBody Menu food) {
        return menuService.updateMenu(food);
    }

    @DeleteMapping("/menu/{id}")
    public Response deleteFoodFromMenu(@PathVariable int id) {
        return menuService.deleteFood(id);
    }
}
