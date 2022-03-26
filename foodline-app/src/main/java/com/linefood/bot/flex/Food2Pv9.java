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

public class Food2Pv9 implements Supplier<FlexMessage> {
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
                .url("https://www.dailynews.co.th/admin/upload/20170114/news_KWEjkHOKSw130734_533.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำข้าวพันผัก")
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
                            .text("วัตถุดิบ\n 1.แป้งข้าวเจ้า\n 2.ไข่ไก่สด\n 3.ผักต่าง ๆ (กะหล่ำปลีม่วง แครอท ผักบุ้ง คะน้า ฟักทอง ผักกาดขาว) \n 4.วุ้นเส้น\n 5.ผักชีฝรั่ง\n 6.ขึ้นฉ่าย\n 7.เนื้อหมูสับ\n 8.กระเทียมเจียว\n 9.แคบหมูไร้มัน\n 10.เต้าหู้\n 11.เกลือ\n12.น้ำสะอาด\n13.ซอสปรุงรส\n 14.ซอสพริก\n15.น้ำจิ้มสุกี้\n วิธีทำ\n 1.นำแป้งข้าวเจ้าผสมกับน้ำ คนละลายให้เป็นเนื้อเดียวกัน พักไว้ (หรือจะใช้แป้งหมักขนมจีนก็ได้) \n 2.เตรียมส่วนผสมอื่นให้พร้อม เช่น ผักที่เตรียมไว้นำมาล้าง ผึ่งให้สะเด็ดน้ำ ซอยหั่นเป็นชิ้นเล็กตามขนาดที่ต้องการ ส่วนวุ้นเส้นแช่น้ำจนนิ่ม แล้วตัดให้สั้นประมาณ 3-4 นิ้ว และไข่อีกส่วนหนึ่งก็ตีให้ฟูเตรียมไว้ในภาชนะ เนื้อหมูสับนำมารวนให้สุกเตรียมไว้ เต้าหู้นำไปต้มแล้วหั่นเป็นชิ้นเล็ก ๆ เตรียมไว้ แคบหมูตัดเป็นชิ้นเล็ก ๆ เตรียมไว้ กระเทียมก็เจียวให้หอมกรอบแล้วกรองเอาแต่กระเทียมเตรียมไว้\n 3.นำวุ้นเส้นและผักที่หั่นเตรียมไว้ทั้งหมดมาคลุกให้เข้ากันเพื่อให้มีสีสันสวยงาม ตั้งพักไว้ให้พร้อม จากนั้นนำหม้อปล่องหรือซึ้งนึ่งใส่น้ำให้เลยครึ่งหม้อ ปิดด้วยผ้าขาวบาง ผูกขึงผ้าด้วยเชือกให้ตึงแน่น นำหม้อขึ้นตั้งไฟ พอน้ำเดือดใช้ทัพพีตักแป้งที่เตรียมไว้ละเลงบนผ้าขาวระอุน้ำให้เป็นแผ่น ใช้ฝาครอบปิดไว้ประมาณ 3 นาที เปิดฝาออกแล้วละเลงไข่ที่ตีไว้ทับลงบนแป้งอีกรอบ ปิดฝาไว้อีกสักครู่\n 4.พอไข่สุก ให้นำส่วนผสมผักและวุ้นเส้นที่เตรียมไว้วางใส่ลงไปตรงกลางแป้ง ปิดฝาอีกครั้ง ประมาณ 3 นาที พอผักสุกก็ใช้ไม้พายพับแป้งห่อพันผักให้เรียบร้อย เท่านี้ก็เสร็จ")
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