package com.linefood.bot.flex;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class Food1Pv2 implements Supplier<FlexMessage> {
    public FlexMessage get() {
        final Image heroBlock = createHeroBlock();
        final Box bodyBlock = createBodyBlock();

        final Bubble bubbleContainer = Bubble.builder()
                .hero(heroBlock)
                .body(bodyBlock)
                .build();
        return new FlexMessage("Restaurant", bubbleContainer);
    }

    private Image createHeroBlock() {
        return Image.builder()
                .url("https://www.museumthailand.com/upload/evidence/1498128173_88248.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำข้าวฟืน")
                .weight(Text.TextWeight.BOLD)
                .size(FlexFontSize.XL)
                .build();
        
        final Box info = createInfoBox();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(title,info))
                .build();
    }

    private Box createInfoBox() {
        final Box place = Box.builder()
                .layout(FlexLayout.BASELINE)
                .spacing(FlexMarginSize.SM)
                .contents(asList(
                        Text.builder()
                            .text("ส่วนผสม\n1.แป้งถั่วลันเตา 300 กรัม\n2.น้ำสะอาด 2 ลิตร\n3.เกลือป่น 1 ช้อนตวง\n4.น้ำปูนใสสำหรับทำแบบทอด 100 มล.\n5.น้ำมันพืช\nวิธีทำ\nเวลาเตรียมส่วนผสม: 5 นาที\nเวลาปรุงอาหาร: 1 ชั่วโมง 5 นาที\n1.แป้งที่ใช้\n2.ละลายแป้งถั่วลันเตา เกลือป่น ด้วยน้ำสะอาด 1 ลิตร\n3.พักแป้งไว้ 30 นาที แบ่งอีกส่วนไว้ทำข้าวแรมฟืนแบบทอด ประมาณ 400 กรัม ผสมน้ำปูนใส 100 กรัม และน้ำสะอาดอีก 500 กรัม แยกไว้อีกชุด\n4.ต้มน้ำสะอาดที่เหลืออีก 500 กรัมให้เดือด\n5.เทแป้งถั่วลันเตาที่ผสมน้ำสะอาด 600 กรัมลงผสมกับน้ำสะอาดที่ต้มเดือด400กรัม กวนให้แป้งสุกใส\nส่วนแป้งที่ใส่น้ำปูนใส กวนแยก กวนให้แป้งสุกดี เทใส่ถาดพักไว้ให้เย็นเช่นเดียวกัน\n6.เทใส่ถาดพักไว้ให้เย็น\n7.หั่นชิ้นขนาดตามชอบ จะได้ข้าวแรมฟืนแบบนิ่ม จะนำไปยำ หรือทานเล่นก็อร่อย\n8.ข้าวแรมฟืนที่ใส่น้ำปูนใส เซ็ทตัวดีแล้วหั่นชิ้น ทอดในน้ำมันร้อนให้สุกกรอบ\n9.ข้าวแรมฟืนแบบทอดพร้อมทาน ทานคู่กับน้ำจิ้มเปรี้ยวหวาน\n ")
                            .wrap(true)
                            .color("#666666")
                            .flex(5)
                            .build()
                )).build();
        
        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .margin(FlexMarginSize.LG)
                .spacing(FlexMarginSize.SM)
                .contents(asList(place))
                .build();
    }

}