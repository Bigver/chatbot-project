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
public class Food1Pv6 implements Supplier<FlexMessage> {
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
                .url("https://www.maeban.co.th/upload_images/image/features/curry_original.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงฮังเล")
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
                            .text("วัตถุดิบ\n1พริกชี้ฟ้าแดงแห้งแช่น้ำ 30 กรัม\n2.เกลือ 5 กรัม\n3.ตะไคร้ 30 กรัม\n4.ขมิ้นสด 10 กรัม\n5.กระเทียมไทย 15 กรัม\n6.ข่า 15 กรัม\n7.หอมแดง 30 กรัม\n8.กะปิ 10 กรัม\n9.น้ำมันรำข้าว 20 กรัม\n10.หมูสามชั้น 500 กรัม\n11.ผงฮังเล 7 กรัม\n12.น้ำปลา (แบ่งใส่ 2 รอบ) 20 กรัม\n13.น้ำสะอาด 300 กรัม\n14.ขิง 20 กรัม\n15.กระเทียมดอง 15 กรัม\n16.น้ำมะขามเปียก 30 กรัม\n17.น้ำตาลปี๊บ 30 กรัม\nวิธีทำ\n1.หั่นหมูสามชั้นแล้วเตรียมไว้ก่อน จากนั้นไปตำพริกแกง\n2.ตำพริกชี้ฟ้าแดงแห้งแช่น้ำกับเกลือ ตามด้วยตะไคร้ซอย ขมิ้นสด กระเทียมไทย ข่า และหอมแดง ตำจนเข้ากัน จากนั้นก็ใส่กะปิตำรวมลงไปด้วตั้ง\n3.ตั้งหม้อใส่น้ำมันเล็กน้อย จากนั้นนำหมูสามชั้นลงไปผัดกับพริกแกง ผัดจนหมูพอสุกเสร็จแล้วก็เติมผงฮังเล\n4.ใส่น้ำสะอาดลงไป ปรุงรสด้วยน้ำปลา น้ำมะขามเปียก และน้ำตาลปี๊บ ใส่ขิงและกระเทียมดองลงไป ต้มจนน้ำแกงงวด เสร็จแล้วก็ตักใส่ถ้วยเสิร์ฟ")
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