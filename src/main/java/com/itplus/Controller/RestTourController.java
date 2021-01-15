package com.itplus.Controller;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itplus.Model.BookTourDTO;
import com.itplus.Model.UserDTO;
import com.itplus.Service.UserService;
import com.itplus.Util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


import com.itplus.Model.TourDTO;
import com.itplus.Service.TourService;

import javax.mail.MessagingException;

@RestController
@RequestMapping(value = "/tour", produces = "application/json")
public class RestTourController {

    @Autowired
    TourService tourService;

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/")
    public String listAllTour(@Nullable @RequestParam String q) throws JsonProcessingException {
        List<TourDTO> list;
        if (q != null) {
            list = tourService.search(q);
        } else {
            list = tourService.getAllTour();
        }
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping(value = "/category/{id}/")
    public String listTourByCategory(@PathVariable int id) throws JsonProcessingException {
        List<TourDTO> list = tourService.getTourByCategory(id);
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping(value = "/{id}/")
    public String listTourById(@PathVariable int id) throws JsonProcessingException {
        TourDTO list = tourService.getTourById(id);
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping(value = "/promotion/")
    public String withPromotion() throws JsonProcessingException {
        List<TourDTO> list = tourService.listTourHasPromotion();
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping(value = "/promotion/{id}/")
    public String listTourByPromotion(@PathVariable int id) throws JsonProcessingException {
        List<TourDTO> list = tourService.getTourByPromotion(id);
        return objectMapper.writeValueAsString(list);
    }

    @PostMapping(value = "/book/")
    public String bookTour(@RequestBody BookTourDTO bookTourDTO) throws MessagingException, JsonProcessingException {
        UserDTO user = userService.getUserById(bookTourDTO.getUserId());
        TourDTO tour = tourService.getTourById(bookTourDTO.getTourId());
        HashMap<String, Object> map = new HashMap<>();
        if (user != null) {
            if (tour != null) {
                EmailUtil.sendEmailBookTour(user, tour);
                map.put("message", "Information has been sent to your mail");
                map.put("success", true);
            } else {
                map.put("message", "Tour not found");
                map.put("success", false);
            }
        } else {
            map.put("message", "User not found");
            map.put("success", false);
        }
        return objectMapper.writeValueAsString(map);
    }
}
