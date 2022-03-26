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

public class Food1Pv7 implements Supplier<FlexMessage> {
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
                .url("https://ikasalong.com/wp-content/uploads/2020/04/larb-moo-final-dip.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำลาบลำปาง")
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
                            .text("วัตถุ\n1.เนื้อหมูสันใน 300 กรัม\n2.เครื่องในหมู200กรัม\n3.เลือดหมู1/2ถ้วยn\4.ผักไผ่2ช้อนโต๊ะ\n5.พริกลาบ3ช้อนโต๊ะ\n6.กระเทียมเจียว1ช้อนโต๊ะ\n7.พริกขี้หนูแห้งทอด5เม็ด\nวิธีทำ\n1.ขั้นตอนแรกให้เราเอาเนื้อหมูที่เตรียมไว้ก่อนหน้านี้ มาทำการหั่นเป็นชิ้นเล็กๆไว้ก่อน\n2.ขั้นตอนที่สองนี้ให้ทำการสับหมูได้เลย โดยในขณะที่สับอยู่นั้นให้ใส่เลือดหมูลงและสับไปด้วยด้วยทีละน้อย\n3.ขั้นตอนที่สามให้ทำการสับหมูไปเรื่อยๆ จนกระทั่งหมูละเอียดและนิ่มดีพอ\n4.ขั้นตอนที่สี่ ให้นำเอาเครื่องในหมูต้มและหนังหมูต้มที่เตรียมไว้ก่อนหน้านี้มาทำการหั่นเป็นชิ้นบางๆ\n5.ขั้นตอนที่ห้า ให้นำเอาเลือดหมู น้ำต้มเครื่องในหมู พริกลาบเหนือ ผสมกันและทำการคนให้เข้ากัน\n.6ขั้นตอนที่หก ให้นำเอาหมูสับละเอียดที่สับไว้ก่อนหน้านี้ใส่ลงไป แล้วคลุกเคล้าให้เข้ากัน\n7.ขั้นตอนที่เจ็ด ให้ใส่เครื่องในหมูและหนังหมูที่ได้ทำการหั่นไว้แล้วก่อนหน้านี้ลงไป\n.8ขั้นตอนสุดท้าย ใส่ผักไผ่ที่ซอยไว้แล้ว และผักชีต้นหอมซอยลงไป แล้วทำการคลุกเคล้าให้เข้ากัน ตักใส่จานแล้วโรยหน้าด้วยหอมเจียว ทานคู่กับผักแกล้มเอาตามที่ชอบ เป็นอันเสร็จ เมนูนี้จะเรียกว่า “ลาบหมูดิบ”")
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
