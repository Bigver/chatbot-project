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

public class Food1Pv3 implements Supplier<FlexMessage> {
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
                .url("https://img.wongnai.com/p/1968x0/2020/06/03/b9f20f641dcd47e59bc1d04f0fdc09c7.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงเห็ดเผาะ")
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
                            .text("วัตถุดิบ\n1.เห็ดเผาะในน้ำเกลือ 100 กรัม\n2.ยอดมะขาม 2 ถ้วย\n3.วัตถุดิบพริกแกง\n4.ข่าซอย 1 ช้อนโต๊ะ\n5.พริกแห้ง 5 เม็ด\n6.ตะไคร้ซอย 1 ช้อนโต๊ะ\n7.กระเทียม 4 กลีบ\n8.กะปิ 1 ช้อนโต๊ะ\n9.เกลือ 1 ช้อนชา \nวิธีทำ\nSTEP 1 : โขลกพริกแกง\nวิธีแกงเห็ดเผาะเริ่มจากตำพริกแกง โขลกข่าซอย พริกแห้ง ตะไคร้ซอย กระเทียม กะปิ และเกลือ ให้ละเอียดเข้ากันใส่เครื่องพริกแกงลงในครกโขลกให้เข้ากัน\nSTEP 2 : ตั้งหม้อน้ำแกง\nตั้งหม้อต้มน้ำให้เดือด ใส่พริกแกงที่โขลกไว้ แล้วใส่เห็ดเผาะลงไป ใช้เวลาต้มประมาณ 15 นาที จากนั้นใส่ยอดมะขามอ่อน ปิดไฟตักใส่ถ้วยแกงเห็ดเผาะพร้อมเสิร์ฟ\nตั้งน้ำให้เดือด ใส่เครื่องพริกแกงที่ตำไว้ ตามด้วยเห็ดเผาะ ต้มประมาณ 15 นาทีใส่ยอดมะขามอ่อนตามลงไป ปิดไฟ ตักใส่ถ้วยพร้อมเสิร์ฟ \n")
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