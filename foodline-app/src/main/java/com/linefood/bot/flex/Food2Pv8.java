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

public class Food2Pv8 implements Supplier<FlexMessage> {
    @Override
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
                .url("https://cooking.teenee.com/side-dish/img8/5087.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงแคไก่")
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
                            .text("วัตถุดิบ\n 1.เครื่องแกงแค¼ ถ้วย\n  2.สะโพกไก่สับเป็นชิ้นขนาดพอคำ 500 กรัม \n  3.ผักเผ็ด  1 ถ้วย\n 4.ถั่วฝักยาวหั่นท่อน  ½  ถ้วย\n 5.มะเขือพวง   ¼  ถ้วย\n  6.มะเขือเปราะผ่าสี่ซีก  5 ลูก\n 7.ใบตำลึง  1 ½  ถ้วย \n  8.ยอดชะอม  ½  ถ้วย\n 9.ผักชีฝรั่งหั่นหยาบ  ¼  ถ้วย\n 10.ใบพริก  ¼  ถ้วย\n  11.ใบชะพลู (ผักแค) หั่นหยาบ  ¼  ถ้วย\n 12.เครื่องแกง  ¼  ถ้วย\n 12.น้ำปลา  1 ช้อนโต๊ะ\n  13.น้ำเปล่า  3-4 ถ้วย \n 14.น้ำมันพืช  2-3 ช้อนโต๊ะ\n  วิธีทำ\n  1.ผัดเครื่องแกงกับน้ำมันจนมีกลิ่นหอม ใส่เนื้อไก่ลงผัดจนสุก เติมน้ำลงไป ตั้งไฟให้ส่วนผสมเดือด\n  2.ใส่ผักเผ็ด ถั่วฝักยาว มะเขือพวง มะเขือเปราะ ตำลึง ยอดชะอม ผักชีฝรั่ง ใบพริก และใบชะพลูลงไป\n  3.ปรุงรสด้วยน้ำปลา คนให้ส่วนผสมเข้ากันอีกครั้ง ยกลงจากเตา")
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