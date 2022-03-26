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

public class Food3Pv6 implements Supplier<FlexMessage> {
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
                .url("https://ikasalong.com/wp-content/uploads/2020/04/Thua-nao-moe.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำถั่วเน่าเมอะ")
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
                            .text("วัตถุุดิบ\n1.ถั่วเหลือง1กิโลกรัม\n2.เกลือ3ช้อนโต๊ะ\nเครื่องเคียง\n1.พริกหนุ่ม\nวิธีการทำ\n1.ล้างถั่วเหลืองให้สะอาด แช่น้ำให้พองตัว\n2.ต้มน้ำเปล่า พอเดือด ใส่ถั่วเหลือง\n3.ต้มด้วยไฟแรง เติมน้ำเรื่อยๆ อย่าให้แห้ง จนถั่วสุกและเปื่อย\n4.หมักถั่วเหลืองต้ม\n5.ห่อด้วยใบตองตึงแห้ง หมักไว้ 3 วัน ให้ถั่วขึ้นราเล็กน้อย\n6.โขลกเกลือและถั่วเหลืองต้ม รวมกันให้ละเอียด ปรุงด้วยพริกย่างป่น ตักพักไว้\n7.ห่อด้วยใบตองกล้วย\n8.ย่างกับเตาถ่าน จะได้ถั่วเน่าเมอะที่หอมชวนรับประทาน")
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


    
