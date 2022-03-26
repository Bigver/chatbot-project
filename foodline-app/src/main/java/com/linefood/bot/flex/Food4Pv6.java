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

public class Food4Pv6 implements Supplier<FlexMessage> {
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
                .url("https://static.thairath.co.th/media/Dtbezn3nNUxytg04agCxz3X5mgMISDGWXTpu23dHUqsoCG.webp")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำจอผักกาด")
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
                            .text("วัตถุดิบ\n1.ผักกวางตุ้ง\n2.เนื้อหมูสามชั้น หรือซี่โครงหมู\n3.หอมแดง\n4.กระเทียม\n5.กะปิ\n6.น้ำมะขามเปียก\n7.พริกแห้งคั่ว\n8.เกลือป่น\n9.ถั่วเน่าแข็บย่างไฟ (จะใส่หรือไม่ใส่ก็ได้)\nวิธีทำจอผักกาด\n1.ตั้งน้ำให้เดือด ใส่เนื้อหมูลงไป ต้มจนกว่าเนื้อหมูจะเปื่อยดี\n2.โขลกกระเทียม หอมแดง ให้พอแหลก หลังจากนั้นใส่ลงไปในหม้อต้ม\n3.เติมกะปิลงไปเล็กน้อย\n4.รอจนเดือด ให้หั่นผักกวางตุ้งใส่ตามลงไป\n5.โขลกถั่วเน่าแข็บให้ละเอียด ใส่เพิ่มลงไป\n6.เริ่มปรุงรส ใส่เกลือ แล้วคนให้เกลือละลา\n7.เมื่อเริ่มเดือด ให้ใส่น้ำมะขามเปียก คนให้ทั่ว แล้วยกลงจากเตาได้เล\n8.เคล็ดลับเพิ่มความอร่อย ให้เจียวกระเทียมกับพริกขี้หนูแห้งในน้ำมัน แล้วใส่เพิ่มลงไปในหม้อจอผักกาด\n9.ตักใส่ถ้วย นำพริกคั่วแห้งตกแต่งให้ดูสวยงาม ยกเสิร์ฟได้เลย")
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


    
