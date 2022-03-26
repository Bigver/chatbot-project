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

public class Food3Pv7 implements Supplier<FlexMessage> {
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
                .url("https://i.ytimg.com/vi/t9NCXpRkjLs/maxresdefault.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีหลามบอน")
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
                            .text("วัตถุดิบ\n\n1.บอนต้นอ่อน500กรัม\n2.ใบมะกรูด5ใบ\nเครื่องแกง\n1.พริกแห้ง15เม็ด\n2หอมแดง7หัว\n3.ข่าหั่น1ช้อนโต๊ะ\n4.ตะไคร้หั่น2ช้อนโต๊ะ\n5.เม็ดผักชี1ช้อนโต๊ะ\n6.เกลือ1ช้อนชา\nวิธีการทำ\n1.ปอกเปลือกบอน หั่นเป็นท่อน ล้างน้ำ นำไปนึ่ง นึ่งให้สุกจนเละ ประมาณ 30 นาที พักไว้\n2.โขลกเครื่องแกงรวมกันให้ละเอียด\n3.ผสมเครื่องแกงกับบอนนึ่งคนให้เข้ากัน\n4.ใส่ส่วนผสมลงในกระบอกไม้ไผ่\n5.นำไปย่างไฟ คอยเติมน้ำ ใช้ไม้คนไปมา\n6.เมื่อหลามบอนสุกแล้ว ผ่าครึ่งกระบอกไม้ไผ่ นำมารับประทานได้")
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


