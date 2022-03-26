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

public class Food4Pv8 implements Supplier<FlexMessage> {
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
                .url("https://img-global.cpcdn.com/recipes/68ff591b3e2ecfbb/680x482cq70/%E0%B8%A3%E0%B8%9B-%E0%B8%AB%E0%B8%A5%E0%B8%81-%E0%B8%82%E0%B8%AD%E0%B8%87-%E0%B8%AA%E0%B8%95%E0%B8%A3-%E0%B9%81%E0%B8%81%E0%B8%87%E0%B8%AB%E0%B8%A2%E0%B8%A7%E0%B8%81%E0%B8%81%E0%B8%A5%E0%B8%A7%E0%B8%A2%E0%B9%83%E0%B8%AA%E0%B9%84%E0%B8%81%E0%B8%9A%E0%B8%B2%E0%B8%99.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงหยวกกล้วย")
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
                            .text("วัตถุดิบ\n 1.หยวกกล้วยอ่อน 500 กรัม\n2.เนื้อหมู 450 กรัม\n3.พริกแกงเผ็ด 200 กรัม (หรือประมาณตามชอบ) \n4.น้ำปลา 3-4 ช้อนโต๊ะ (หรือประมาณตามชอบ) \n5.กะทิ 250 มิลลิลิตร\n6.น้ำเปล่า 650 มิลลิลิตร\nวิธีทำ\n1.ตัดส่วนบนของลำต้นกล้วย แล้วลอกเอากาบออกให้เหลือเฉพาะกาบอ่อนด้านในหยวกกล้วย (ใช้กล้วยตานี หรือกล้วยน้ำว้าก็ได้  เลือกต้นอ่อนที่ยังไม่ออกปลีดีที่สุด)  จากนั้นนำมาหั่นให้ได้ขนาดที่พอเหมาะ ล้างน้ำและแช่เตรียมไว้โดยบีบมะนาวลงไปซีกหนึ่ง ช่วยลดรสฝาดและป้องกันหยวกกล้วยดำ\n2.หยวกกล้วยมีใยกล้วยบาง ๆ ที่ยืดยาวพันกัน (เป็นเหตุให้คนโบราณไม่นิยมทำในงานศพเพราะเชื่อว่าผู้จากไปจะยังผูกพันหรือยังมีห่วง ไปไม่สงบ) ให้ใช้ตะเกียบไม้คนวน ๆ เพื่อเกี่ยวเส้นใยออกมาบ้าง หยวกกล้วยจะได้เป็นชิ้น ไม่ติดกัน\n3.ผัดพริกแกงกับน้ำมันจนหอม เลือกใช้พริกแกงเผ็ดมากหรือเผ็ดน้อยก็ได้ตามชอบ\n4.นำเนื้อหมูหั่นชิ้นลงไปผัดกับพริกแกงจนเริ่มสุก ใครชอบเนื้อไก่ ก็ใช้ได้เช่นกัน ระหว่างนี้ให้ปรุงรสด้วยน้ำปลา\n5.เติมน้ำเปล่าลงไปให้ท่วมเนื้อหมูตั้งต่อจนน้ำเดือด\n6.ใส่หยวกกล้วยที่หั่นเตรียมไว้ แล้วค่อย ๆ คนให้จนหยวกกล้วยยุบตัว\n7.หากรู้สึกน้ำแกงน้อยไปอย่าเพิ่งเติมน้ำ รอจนหยวกกล้วยสุกดีเพื่อรักษาความเข้มข้นของน้ำแกง\n8.หยวกกล้วยสุกแล้วเทน้ำกะทิลงไปได้เลย จากนั้นผัดผสมไปมาให้เข้ากัน แล้วปิดไฟเตรียมเสิร์ฟ")
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