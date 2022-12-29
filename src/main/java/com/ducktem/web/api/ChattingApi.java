package com.ducktem.web.api;


import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.ChattingService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String chatting(ChatRoom chatRoom) {
        ProductPreview productPreview = productPreviewService.get(chatRoom.getProductId());
        Member Seller = memberService.getMember(chatRoom.getCustomerId());
        Member customer = memberService.getMember(chatRoom.getSellerId());

        List<Chat> chattingList = chattingService.getChattingList(chatRoom);

        return "member/chatting/detail";
    }


}
