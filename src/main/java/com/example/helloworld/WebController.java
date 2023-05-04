package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

//Đánh dấu đây là 1 controller
// Nơi tiếp nhận các request từ phía người dùng
@Controller
public class WebController {
    //Đón nhận request GET
    //Nếu người dùng request tới địa chỉ /
    @GetMapping("/")
    public String index(){
        return "index"; //trả về file index.html
    }
    @GetMapping("/about")
    public  String about(){
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
            //Request param "name" sẽ dc gán giá trị vào biến String
            @RequestParam(name = "name", required = false,defaultValue = "")String name,
            //Model là 1 object của spring boot, dc gắn vào trong mọi request
            Model model
    ){
        //Gắn vào model giá trị name nhận dc
        model.addAttribute("name", name);
        return "hello"; //trả về hello.html cùng thông tin trong object Model
    }
    @GetMapping("/profile")
    public String profile(Model model){
        //Tạo ra thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("Fullname", "Nguyễn Đức Khánh"));
        profile.add(new Info("Nickname", "KhánhIT"));
        profile.add(new Info("website", "KuponJP.net"));

        //Đưa thông tin ra model
        model.addAttribute("KITProfile", profile);

        //trả về template profile.html
        return  "profile";
    }


}
