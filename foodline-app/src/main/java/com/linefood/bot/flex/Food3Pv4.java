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

public class Food3Pv4 implements Supplier<FlexMessage> {
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
                .url("https://pbs.twimg.com/media/E4gEBBkUUAEj9R_.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำยำฮก")
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
                            .text("วัตถุดิบ\n1.ฮกงัวหรือรกวัว\n2.ผักหอมด่วนหรือสะระแหน่\n3.เมล็ดมะแขว่นและ เมล็ดหอมป้อมหรือผักชี\n4.หอมขาวหรือกระเทียม\n5.ผักไผ่หรือผักแพรว\n6.พริกแห้ง\n7.ข่าตะไคร้\nวิธีทำ\n1.นำฮกวัวหรือรกวัวไปต้มใส่ข่า ตระไคร้ ให้สุก หั่นเป็นชิ้นพอคำ\n2.นำเมล็ดผักชี พริกแห้ง เมล็ดมะแขว่นไปคั่วไฟให้สุก แล้วนำมาโขลกใส่กระเทียมให้ละเอียด\n3.นำน้ำพริกที่โขลกไว้ไปผัดในน้ำมันให้หอม แล้วใส่รกวัวที่หั่นไว้ลงไปคลุกเคล้าให้เข้ากัน จากนั้นเติมน้ำที่ต้มรกวัวลงไป  รอให้น้ำเดือดอีกครั้งหนึ่ง\n4.ปิดไฟแล้วใส่ต้นหอมผักชีที่หั่นไว้ลงไป ก็สามารถนำมารับประทานได้เลย \n")
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