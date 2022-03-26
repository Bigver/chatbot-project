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

public class Food4Pv4 implements Supplier<FlexMessage> {
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
                .url("https://img.kapook.com/u/surauch/movie2/bake-egg.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำไข่ป่าม")
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
                            .text("วัตถุดิบ\n1.เกลือป่น\n2.ไข่ไก่\n3.หมูสับ\n4.พริกไทยป่น\n5.ต้นหอมซอย\n6.พริกขี้หนูแดงซอย\n7.กระทงใบตอง\nวิธีทำ\n1.ตีผสมไข่ไก่กับเกลือป่น และพริกไทยป่นพอเข้ากัน จากนั้นเทลงในกระทงใบตองประมาณ 1/2 ของกระทง\n2.ใส่หมูสับ ไส้กรอกหรือปูอัด โรยหน้าด้วยพริกขี้หนูแดงซอย และต้นหอมซอย\n3.นำไข่ป่ามไปย่างบนเตาถ่านด้วยไฟอ่อน หรือวางลงบนกระทะแล้วนำขึ้นตั้งไฟอ่อน ย่างจนไข่ขึ้นฟู และสุกทั่วทั้งหมด จัดใส่จาน แต่งให้สวยงาม พร้อมรับประทาน\n")
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