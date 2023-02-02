//package com.mvc.springCRUD.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.*;
//
//
//import com.mvc.springCRUD.model.User;
//import com.mvc.springCRUD.services.UserService;
//
//@RestController
//@RequestMapping("/search")
//public class SearchController {
//  private final UserService userService;
//
//  public SearchController(UserService userService) {
//    this.userService = userService;
//  }
//
//  @GetMapping
//  public List<User> searchUsers(@RequestParam("query") String query) {
//    return userService.searchUsers(query);
//  }
//}
