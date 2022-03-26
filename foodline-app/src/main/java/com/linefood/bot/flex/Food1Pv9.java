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

public class Food1Pv9 implements Supplier<FlexMessage> {
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
                .url("https://www.greenery.org/wp-content/uploads/2021/01/%E0%B8%A3%E0%B8%AA%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99_%E0%B8%AB%E0%B8%A1%E0%B8%B5%E0%B9%88%E0%B8%9E%E0%B8%B1%E0%B8%99-8.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำหมี่พันลับแล")
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
                            .text("วัตถุดิบ\n 1. ข้าวแคบ หรือแผ่นข้าวเกรียบทำจากแป้งข้าว\n2. เส้นหมี่แบบไม่ฟอกสี\n3. ไข่ไก่\n 4. ถั่วฝักยาวซอย\n 5. ถั่วงอกเด็ดหัว\n 6. กะหล่ำปลีซอย\n 7. ต้นหอม\n 8. ผักพื้นบ้านตามชอบ\n 9. เต้าหู้เเข็ง ฟองเต้าหู้\nวิธีทำน้ำยำ\n 1. น้ำตาลมะพร้าวอย่างดี\n 2. น้ำปลาดี\n 3. พริกป่น\n 4. น้ำมะนาวสด\nวิธีปรุง\n 1. ลวกเส้นหมี่ด้วยน้ำร้อน และนำขึ้นพักไว้ให้สะเด็ดน้ำ\n2. ลวกถั่วฟักยาว ถั่วงอก กะหล่ำปลี แค่พอสุก จากนั้นน็อกผักด้วยน้ำเย็นเพื่อให้ผักคงความกรอบไว้ และนำขึ้นพักให้สะเด็ดน้ำ\n3. เจียวไข่เป็นแผ่นบาง หั่นเป็นเส้นฝอยยาว พักไว้\n4. หั่นเต้าหู้แข็งเป็นชิ้นพอดีคำ และทอดจนกรอบนอกนุ่มใน พักไว้\n5. ทอดฟองเต้าหู้จนฟูกรอบ พักไว้\n6. ปรุงน้ำยำด้วยน้ำตาลมะพร้าว พริกป่น น้ำปลา และมะนาว ให้ได้สามรส ออกรสหวานนำ เค็มตาม ติดเปรี้ยวเพียงเล็กน้อย\n7. คลุกหมี่กับน้ำยำจนเข้ากันดี จากนั้นใส่เครื่องที่เตรียมไว้ตามลงไปคลุกให้เข้ากัน\n8. นำหมี่ยำห่อด้วยแผ่นข้าวแคบ และม้วนเป็นชิ้นยาว จัดใส่จานพักไว้สักครู่\n9. นำหมี่พันไปนึ่งให้แป้งนิ่มราว 5-10 นาที หรือสามารถนำหมี่พันพักไว้ในอุณหภูมิห้องราว 20-30 นาที แป้งจะค่อยๆ คลายตัวและนิ่มลง")
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