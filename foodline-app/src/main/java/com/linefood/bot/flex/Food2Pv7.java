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

public class Food2Pv7 implements Supplier<FlexMessage> {
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
                .url("https://i.ytimg.com/vi/Jvf4KMuuoEQ/maxresdefault.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("แกงแคไก่เมือง")
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
                            .text("วัตถุดิบ\nส่วนผสมเครื่องแกง\n1.พริกชี้ฟ้าแห้ง หั่นท่อนแช่น้ำ7 เม็ด\n2.กระเทียมหั่นหยาบ2 ช้อนโต๊ะ\n3.ตะไคร้ซอย1 ต้น\n4.หอมเล็กซอย2 ช้อนโต๊ะ\n5.กะปิ1 ช้อนโต๊ะ\n6.เกลือป่น1 ช้อนชา\n7.ปลาร้า½-1 ช้อนโต๊ะ\nวิธีทำ เครื่องแกง\nโขลกส่วนผสมทั้งหมดเข้าด้วยกันให้ละเอียด จะได้เครื่องแกง ประมาณ ¼ถ้วย\nส่วนผสมสำหรับทำ แกงแคไก่\n1.สะโพกไก่สับเป็นชิ้นขนาดพอคำ500 กรัม\n2.ผักเผ็ด1 ถ้วย\n3.ถั่วฝักยาวหั่นท่อน½ถ้วย\n4.มะเขือพวง¼ถ้วย\n5.มะเขือเปราะผ่าสี่ซีก5 ลูก\n6.ใบตำลึง1½ถ้วย\n7.ยอดชะอม½ถ้วย\n8.ผักชีฝรั่งหั่นหยาบ¼ถ้วย\n9.ใบพริก¼ถ้วย\n10.ใบชะพลู (ผักแค) หั่นหยา¼ถ้วย\n11.เครื่องแกง¼ถ้วย\n12.น้ำปลา1 ช้อนโต๊ะ\n13.น้ำเปล่า3-4 ถ้วย\n14.น้ำมันพืช2-3 ช้อนโต๊ะ\nวิธีทำ\n1.ผัดเครื่องแกงกับน้ำมันจนมีกลิ่นหอม ใส่เนื้อไก่ลงผัดจนสุก เติมน้ำลงไป ตั้งไฟให้ส่วนผสมเดือด\n2.ใส่ผักเผ็ด ถั่วฝักยาว มะเขือพวง มะเขือเปราะ ตำ ลึง ยอดชะอม ผักชีฝรั่ง ใบพริก และใบชะพลูลงไป\n3.ปรุงรสด้วยน้ำปลา คนให้ส่วนผสมเข้ากันอีกครั้ง ยกลงจากเตา ตักเสิร์ฟได้ทันที")
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


    
