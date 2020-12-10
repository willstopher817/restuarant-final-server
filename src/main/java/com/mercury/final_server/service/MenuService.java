package com.mercury.final_server.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import com.mercury.final_server.bean.Sample;
import com.mercury.final_server.bean.User;
import com.mercury.final_server.bean.UserProfile;
//import javafx.scene.chart.ScatterChart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mercury.final_server.bean.Menu;
import com.mercury.final_server.dao.MenuDao;
import com.mercury.final_server.http.Response;

@Service
public class MenuService {

    private final Logger LOGGER = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    ServletContext context;

    @Autowired
    MenuDao menuDao;

    public List<Menu> getMenu() {
        return menuDao.findAll();
    }

    public Menu getOneFood(long id) {
        return menuDao.findById(id).get();
    }

    public Response addOneFood(Menu food) {
        // TODO: validation.
        try {
            menuDao.save(food);
//            // TODO: send email. assume username is the email for now
//            emailService.sendSimpleMessage(user.getUsername(), "Account Created", user.getUsername() + ", your account is created!");
            return new Response(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new Response(false, 400, e.getMessage());
        }

    }

    // cache moved to dao for updating purpose
    public Response updateMenu(Menu food) {
        try {
            Menu f = menuDao.getOne(food.getId());
            f.setName(food.getName());
            f.setPrice(food.getPrice());
            f.setCategory(food.getCategory());
            f.setImage(food.getImage());
            menuDao.save(f);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }

    // remove from cache.
    @CacheEvict(value = "menu", key = "#id")
    public Response deleteFood(long id) {
        try {
            menuDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }
}
