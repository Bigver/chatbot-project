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

public class Food2Pv1 implements Supplier<FlexMessage> {
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
                .url("https://i0.wp.com/goodlifeupdate.com/app/uploads/2019/08/%E0%B8%82%E0%B8%99%E0%B8%A1%E0%B8%88%E0%B8%B5%E0%B8%99%E0%B8%99%E0%B9%89%E0%B8%B3%E0%B9%80%E0%B8%87%E0%B8%B5%E0%B9%89%E0%B8%A2%E0%B8%A7-web.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำขนมจีนน้ำเงี้ยว")
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
                            .text("วัตถุดิบ\n1.หมูสับ 250 กรัม\n2.กระดูกหมู	1 กิโลกรัม \n3.เลือดหมูหั่นชิ้นพอคำ	2 ก้อน\n4.มะเขือส้ม หรือมะเขือเทศสีดาผ่าครึ่ง 3 ถ้วย \n5.เกลือป่น ½ ช้อนชา\n6.น้ำปลา 3 ช้อนโต๊ะ\n7.ดอกงิ้วแช่น้ำจนนุ่ม 10 ดอก\n8.ค้นหอมซอย ¼ ถ้วย\n9.กระเทียมเจียว ½ ถ้วย\n10.น้ำมันพืชสำหรับผัด\n11.ขนมจีนตามชอบ\n12.กะหล่ำปลี ผักกาดดอง มะนาวซีก และแคบหมูสำหรับเสิร์ฟเคียง\n13.(ส่วนผสมเครื่องแกง)พริกแห้งเม็ดใหญ่ 10 เม็ด เกลือป่น 1 ช้อนชา ข่าซอย 1  ช้อนโต๊ะ ตะไคร้ซอย	¼ ถ้วย รากผักชีซอย 5 ราก หอมเล็กซอย ¼ ถ้วย กระเทียมซอย 3 ช้อนโต๊ะ ถั่วเน่าย่างไฟ 1 แผ่น กะปิ 1 ช้อนโต๊ะ\nวิธีทำ\n1.เคี่ยวกระดูกหมูในหม้อด้วยไฟกลางจนเริ่มเปื่อย หรือประมาณ 40 นาที ลดไฟอ่อนลง เคี่ยวต่อ\n2.ทำพริกแกงโดยโขลกพริกแห้งกับเกลือให้แหลก ตามด้วยส่วนผสมที่เหลือ โขลกให้เข้ากันจนเนียนละเอียด\n3.ตั้งกระทะใส่น้ำมันด้วยไฟกลางพอร้อน ใส่พริกแกงลงผัดจนหอม ตามด้วยหมูสับผัดให้เข้ากันจนสุก\n4.แบ่งมะเขือส้มมาครึ่งหนึ่งใส่ลงไป ผัดสักครู่ให้กลิ่นและรสมะเขือส้มออกมา ปิดเตา ตักใส่หม้อซุปในข้อแรก ใส่ดอกงิ้วเคี่ยวต่อประมาณ 15 นาทีด้วยไฟกลางจนเดือด ใส่เลือด มะเขือส้มที่เหลือ ปรุงรสด้วยเกลือ และน้ำปลา เคี่ยวต่อสักครู่จนเลือดนุ่ม\n5.จัดขนมจีนใส่ชาม ราดน้ำเงี้ยว โรยต้นหอมและกระเทียมเจียว เสิร์ฟพร้อมกะหล่ำปลี และผักกาดดอง มะนาวซีก และแคปหมู")
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