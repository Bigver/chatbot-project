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

public class Food3Pv9 implements Supplier<FlexMessage> {
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
                .url("https://f.ptcdn.info/182/062/000/plyunw3nhfKkwjdK5zs-o.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำน้ำยาปลาตะโกก")
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
                            .text("วัตถุดิบ\n 1. ปลาตะโกก 3 กิโลกรัม\n 2. หอมแดง 500 กรัม\n 3. กระเทียม 400 กรัม\n 4. กระชาย 550 กรัม\n 5. ข่า 150 กรัม\n 6. ตะไคร้ 50 กรัม\n 7. พริกแห้ง 100 กรัม\n 8. มะพร้าวขูด 2 กิโลกรัม คั้นแยกเป็นหัว และ หางกะทิ\n 9. กะปิ 40 กรัม\n 10. น้ำปลา\n 11. น้ำตาลทราย 2 ช้อนโต๊ะ\nวิธีทำ\n1. เตรียมส่วนประกอบ ปอกหอมแดง ปอกกระเทียม กระชายส่วนแรกหั่นเป็นชิ้นเล็กๆ ซอยตะไคร้ สับข่า ตัดพริกแห้งเป็นท่อน กระชายส่วนที่ 2 ตัดแต่งแล้วผ่าสี่แฉกตรงปลาย หั่นปลาเป็นชิ้น ต้มให้สุก แกะเอาแต่เนื้อ ตะโกกก้างเยอะ ต้องระวังเลือกก้างออกให้ดี (ปลา 3 กิโลกรัม จะได้เนื้อประมาณ 1200 กรัม) \n 2. ใส่หอมแดง กระเทียม กระชาย ข่า ตะไคร้ พริกแห้ง ลงไปในหม้อ เติมน้ำพอท่วมเปิดไฟ รอจนเดือดแล้วหรี่ไฟเคี่ยวประมาณ 30 นาที ใส่กะปิลงไป จากนั้นเคี่ยวต่ออีก 30 นาทีจึงปิดไฟ\n 3. นำปลาที่แกะเนื้อแล้ว รวมกับส่วนประกอบข้อ 2 ที่เคี่ยวเสร็จ นำมาปั่นจนละเอียด (เดิมใช้วิธีโขลก เพราะเนื้อจะฟูกว่า แต่เพื่อถนอมร่างกาย แม่เลยปั่นแทน) เทใส่ในหม้อ\n 4. นำหม้อที่ใส่ส่วนประกอบใน ข้อ 3 ตั้งไฟ เทหางกะทิลงไป รอจนเดือด หรี่ไฟ จากนั้นคนเป็นระยะ ร่วมกับทยอยเทหัวกะทิลงไป ใช้เวลาเคี่ยวประมาณ 1 ชั่วโมง ชิม ปรุงรสด้วยน้ำปลา น้ำตาลทรายจากนั้นใส่กระชายส่วนที่สองลงไป รอจนเดือด เคี่ยวต่ออีก 10 นาทีแล้วปิดไฟ")
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