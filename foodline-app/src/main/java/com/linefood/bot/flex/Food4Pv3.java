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

public class Food4Pv3 implements Supplier<FlexMessage> {
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
                .url("https://food.mthai.com/app/uploads/2017/12/Sa-Makheu001.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำส้ามะเขือ")
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
                            .text("ส่วนผสม\n1.มะเขือขื่น หรือคนเหนือ เรียกมะเขือแจ้ 5 ลูก\n2.น้ำปู๋ 2 ช้อนโต๊ะ\n3.ตะไคร้ซอย 1 ช้อนโต๊ะ\n4.หอมแดง 2 ลูก\n5.กะปิ 1/2 ช้อนชา\n6.น้ำปลาร้าลำ 1 ช้อนโต๊ะ\n7.ดอกเกลือ 1 หยิบมือ\n8.พริกหนุ่ม แล้วแต่ชอบ ชอบเผ็ดมากก็ใส่เยอะ\n9.กระเทียมไทย 1 หัว\nวิธีทำ\nนำพริกหนุ่ม กะปิห่อใบตอง หอมแดง และกระเทียมนำไปย่างไฟให้หอม จากนั้นก็นำมาตำให้ละเอียด\nหั่นครึ่งมะเขือแจ้แล้วซอยเป็นเส้นบางๆ แล้วนำไปแช่น้ำเกลือ จนมะเขือหายขม จากนั้นก็นำขึ้นมาจากน้ำ บีบเอาน้ำออกให้หมด\nนำมะเขือใส่ชาม ใส่ตะไคร้ และน้ำพริกที่ตำไว้ จากนั้นก็ใส่น้ำปู๋ และน้ำปลาร้า คลุกให้เข้ากัน แล้วตักใส่จาน\nเสิร์ฟพร้อมกับแคบหมูและข้าวเหนียว\n")
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