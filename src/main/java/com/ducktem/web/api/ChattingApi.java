package com.ducktem.web.api;


import com.ducktem.web.entity.*;
import com.ducktem.web.service.ChattingService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductPreviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

@Controller
public class ChattingApi {

    @Autowired
    private ChattingService chattingService;

    @Autowired
    private ProductPreviewService productPreviewService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/chatting")
    public String chatting(Model model, @RequestParam(required = false, name = "returnURL") String url, ChatRoom chatRoom, HttpServletRequest request, @AuthenticationPrincipal DucktemUserDetails user) {
        if(url != null) {

            return "redirect:/product/"+ url;
        }

        ProductPreview productPreview = productPreviewService.get(chatRoom.getProductId());
        Member seller = memberService.getMember(chatRoom.getSellerId());
        Member customer = memberService.getMember(chatRoom.getCustomerId());
        List<Chat> chattingList = chattingService.getChattingList(chatRoom,request);

        model.addAttribute("productPreview" , productPreview);
        model.addAttribute("seller", seller);
        model.addAttribute("customer", customer);
        model.addAttribute("chattingList", chattingList);
        model.addAttribute("user", user);


        return "member/chatting/index";
    }

    @ResponseBody
    @GetMapping("/chat/send")
    public Chat sendChat() {



        return null;
    }
}
