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

public class Food1Pv5 implements Supplier<FlexMessage> {
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
                .url("https://sangkae.files.wordpress.com/2013/02/e0b8ade0b8b2e0b8abe0b8b2e0b8a3e0b980e0b8abe0b899e0b8b7e0b8ad_e0b981e0b89ee0b8a3e0b988_e0b895e0b98be0b8b3e0b980e0b895e0b8b2.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำตำเตา")
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
                            .text("วัตถุดิบ\n1.เตา\n2.พริกชี้ฟ้า\n3.กระเทียม\n4.ข่าซอย\n5.ตะไคร้ซอย\n6.น้ำปลาร้าต้มสุก\n7.มะเขือขื่นซอย\n8.มะแว้ง\n9.น้ำปลา\nวิธีทำ\n1.ล้างเตาให้สะอาด เอาไปลวง(อย่าลวกนาน จะทำให้เตาสุกเกิน เป็นสีน้ำตาล) หั่นพอหยาบ พักไว้\n2.ระหว่างที่กำลังต้มเตา อยู่นั้น ก็ให้ทำน้ำพริกสำหรับตำเตาไว้เลยครับ โดยให้นำ พริกชี้ฟ้า (ปริมาณตามใจชอบ) กระเทียม 2 หัว ข่าซอย 10 กรัม และ ตะไคร้ซอย 10 กรัม มาโขลกรวมกันภายในครกให้ละเอียด ก็ถือเป็นน้ำพริกสำหรับ เมนูนี้แล้ว\n3.นำเตาที่ต้มเรียบร้อยแล้ว มากรองเอาน้ำออก แล้วนำเตามาใส่ในถ้วยใบใหญ่ จากนั้น ให้ตักน้ำพริกในครก น้ำปลาร้าต้มสุก 1 ทัพพี มะเขือขื่นซอย 3 ผล และ มะแว้ง10 ผล ลงไปคลุกเคล้ากับเตา แล้วก็ปรุงรสจนได้รสชาติที่ต้องการครับ เมื่อทำการปรุงรสเรียบร้อยแล้ว ก็ถือว่าเสร็จสิ้นในการทำอาหารเมนูนี้\n")
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