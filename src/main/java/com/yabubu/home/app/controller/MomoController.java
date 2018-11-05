package com.yabubu.home.app.controller;

import com.yabubu.home.domain.entity.Praise;
import com.yabubu.home.domain.service.PraiseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/momo")
public class MomoController {

    private final PraiseService praiseService;

    public MomoController(PraiseService praiseService) {
        this.praiseService = praiseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getTop(Model model) {
        // DBから一覧を取得
        List<Praise> praiseList = praiseService.getAllPraise();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        model.addAttribute("format", format);
        model.addAttribute("praiseList", praiseList);
        return "momo/top";
    }

    @RequestMapping(value = "regist", method = RequestMethod.GET)
    public String getRegist(Model model) {
        model.addAttribute("praise", new Praise());
        return "momo/regist";
    }

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public String postRegist(@ModelAttribute Praise praise) {
        praiseService.registerPraise(praise);
        return "top";
    }
}
