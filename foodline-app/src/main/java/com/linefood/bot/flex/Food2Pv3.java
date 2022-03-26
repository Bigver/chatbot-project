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

public class Food2Pv3 implements Supplier<FlexMessage> {
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
                .url("https://img.wongnai.com/p/1968x0/2018/12/31/451f888364134173983747b05f83b4ac.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงแคกบ")
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
                            .text("ส่วนผสม\n1.กบ\n2.พริกแห้ง\n3.ตะไคร้\n4.ข่า\n5.กระเทียม\n6.มะข่วง\n7.มะแขว่น\n8.ปลาร้า\n9.ข้าวคั่ว\n10.ผักต่างๆ\n11.น้ำปลา\n12.น้ำสะอาด 500 ml\nวิธีทำ\nเวลาเตรียมส่วนผสม: 30 นาที\nเวลาปรุงอาหาร: 15 นาที\n1.นำกบไปย่างเผาไฟ\nเคล็ดลับ: เพื่อจะได้ผ่าท้องล้างใส้ได้ง่ายขึ้น\n2.ชำเหละกบและล้วงล้างให้สะอาด และสับๆๆๆเป็นชิ้นๆ\n3.เตรียมเครื่องปรุงต่างๆให้ครบแล้วโขลกรวมกันให้ละเอียด ยกเว้นปลาร้าไว้ทีหลัง\n4.โขลกทุกอย่างละเอียดแล้วก็ใส่ปลาร้าลงไปคลุกเคล้าให้เข้ากัน\n5.นำเครื่องปรุงที่โขลกละเอียดแล้วลงไปคั่วกับกบ\nเคล็ดลับ: ใช้ไฟกลางๆ คั่วจนหอม ถ้าแห้งมาก เหยาะน้ำได้นิดหน่อย ไม่ต้องใส่น้ำมัน\n6.คั่วจนหอมแล้วก็เติมน้ำลงไปได้\n7.พอเดือดแล้วก็ใส่ผักที่ล้างเตรียมไว้ลงไป\n8.อย่าลืมใส่ดอกงิ้วด้วย\n9.ไกล้สุกแล้วใส่ข้าวคั่วในขั้นตอนสุดท้าย คนๆให้ทั่วกัน\n10.ข้าวคั่วหอมๆ ใส่มากน้ำแกงก็จะข้นๆ ปรับปริมาณตามชอบ\n11.สุกแล้ว ปรุงรส น้ำปลา ตามชอบ \n")
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