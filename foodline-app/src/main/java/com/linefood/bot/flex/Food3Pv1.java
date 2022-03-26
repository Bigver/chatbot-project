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

public class Food3Pv1 implements Supplier<FlexMessage> {
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
                .url("https://img.wongnai.com/p/800x0/2020/02/04/13a5a80b873b4aa0b4f829d337a91004.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำน้ำพริกอ่อง")
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
                        .text("วัตถุดิบ\n1.มะเขือเทศเชอร์รี 20 ลูก \n2.หมูสับติดมัน 300 กรัม \n3.พริกแห้ง 5 เม็ด\n4.หมูสับติดมัน 300 กรัม \n5.กระเทียม 1 หัว (สำหรับผัดในเครื่องแกง)  \n6.หอมแดง 2 หัว \n7.กะปิ ½ ช้อนโต๊ะ \n8.เกลือ 1 ช้อนชา \n9.น้ำตาล 1 ช้อนชา \n10.น้ำมัน 1 ช้อนโต๊ะ \n11.ต้นหอม / ผักชี 1 ต้น \n12.น้ำเปล่า ½ ถ้วย \nวิธีทำ\nSTEP 1 : เตรียมเครื่องน้ำพริกอ่อง\n-โขลกน้ำพริก โดยใส่ หอมแดง กระเทียม พริกแห้ง เกลือ และกะปิ โขลกให้ละเอียด \nSTEP 2 : ผัดเครื่อง \n-ตั้งกระทะใส่น้ำมันเอากระเทียมบุบลงเจียว ให้มีสีเหลืองเล็กน้อย \n-เอาน้ำพริกที่โขลกไว้ใส่ลงไปผัดให้หอม ใส่หมูสับตามลงไปผัด หากมันดูแห้งเกินไปเติมน้ำเล็กน้อย\n-พอหมูใกล้สุกใส่มะเขือเทศตามลงไป ผัดจนมะเขือเทศสุกเละ ปรุงรสด้วยน้ำตาลและน้ำปลา \nSTEP 3:จัดเสริฟ\n-ปิดไฟแล้วตักใส่ถ้วย โรยหน้าด้วยต้นหอม ผักชีซอย เพียงเท่านี้ “น้ำพริกอ่อง” รสลำ ๆ ก็พร้อมรับประทานแล้วจ้ะ!")
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
