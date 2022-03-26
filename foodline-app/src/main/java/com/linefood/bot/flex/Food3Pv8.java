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

public class Food3Pv8 implements Supplier<FlexMessage> {
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
                .url("https://farm3.staticflickr.com/2947/15287933559_14bbef7c51_z.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแกงโฮะ")
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
                            .text("วัตถุดิบ\n1.เนื้อหมู200 กรัม\n2.ใบกระเพรา50 กรัม\n3.ใบมะกรูด5 ใบ\n4.มะเขือ5 ลูก\n5.มะเขือพวง100 กรัม\n6.ตะไคร้2 หัว\n7.กระเทียม5 กลีบ\n8.หน่อไม้ดองสำเร็จรูป200 กรัม\n9.ผงกะหรี่15 กรัม\n10.วุ้นเส้น200 กรัม\n11.แกงเขียวหวาน300 กรัม\n12.แกงเผ็ด200 กรัม\n13.แกงฮังเล500 กรัม\n14.น้ำปลา2 ช้อนชา\n15.ซีอิ๊วขาว2 ช้อนชา\n16.ผงชูรส1/2 ช้อนชา\n17.ถั่วฝักยาว150 กรัม\n18.น้ำมันพืช2 ช้อนโต๊ะ \n วิธีทำ\n1.สไลด์หมูเป็นแผ่นบางๆ หั่นมะเขือเป็นชิ้นพอดีคำ ตะไคร้ ฉีกใบมะกรูดและใบกระ\n2.ตั้งเตาให้ร้อนเทน้ำมันลงไปเกลี่ยให้ทั่วกระทะ ใส่กระเทียมลงไปคั่วให้หอม ตามด้วยหมูสดผัดให้สุกหอม\n3.ใส่หน่อไม้ดองลงไปผัด เมื่อหน่อไม้เริ่มอ่อนตัวใส่ มะเขือ มะเขือพวง ถั่วฝักยาว ใบกระเพรา ใบมะกรูด ตะไคร้ ลงไปผัดให้หอมสุก\n4.เทผงกระหรี่ลงไปคลุกเคล้าให้ทั่ว ตามด้วยแกงเผ็ด แกงเขียวหวาน แกงฮังเลลงไปผัดให้เข้ากัน\n5.ปรุงรสด้วยน้ำปลา ซีอิ๊วขาว ผงชูรส ชิมรสตามชอบ สามารถลดเพิ่มได้ตามต้องการ หากขาดหวานสามารถเติมน้ำตาลได้\n6.ใส่วุ้นเส้นลงไปผัดเป็นอย่างสุดท้ายจะได้ไม่เละจนเกินไป ดูจนวุ้นเส้นกลายเป็นเส้นใสก็ตักใส่จาน พร้อมเสิร์ฟค่ะ\n")
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
