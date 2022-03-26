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

public class Food2Pv5 implements Supplier<FlexMessage> {
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
                .url("https://static.thairath.co.th/media/4DQpjUtzLUwmJZZSCIu3J3tHG3Yq4R7tNFTSKnYtmrm6.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำหลู้หมู")
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
                            .text("วัตถุดิบ\n1.เนื้อหมูสับ เครื่องในหมูทอดกรอบ ไตหมู มันหมู เลือดหมู\n2.น้ำต้มกะปิ\n3.น้ำกระเทียมดอง\n4.ใบมะนาว มะกรูด ตระไคร้ทอดกรอบ\n5.หอมแดงเจียว\n6.กระเทียมเจียว\n7.พริกลาบ\n8.ผักไผ่ซอย\n9.ต้นหอม ผักชีซอย\nวิธีทำ\n1.คั้นเลือดสดด้วยใบตะไคร้ เพื่อดับกลิ่นคาวเลือด\n2.ใส่น้ำต้มซุป พริกลาบ น้ำกระเทียมดอง และน้ำต้มกะปิ ลงในชามเลือด คนให้เข้ากัน\n3.ใส่หมูสับ ลงในชามส่วนผสม\n4.ใส่ไตหมู และมันหมู คนให้เข้ากัน\n5.ใส่ใบมะนาวทอดกรอบ ใบมะกรูดทอดกรอบ ตะไคร้ทอดกรอบ หอมแดงเจียว กระเทียมเจียว ผักไผ่ และผักชีต้นหอม คนให้เข้ากัน\n6.ใส่เครื่องในทอดกรอบ คนให้เข้ากัน\n")
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