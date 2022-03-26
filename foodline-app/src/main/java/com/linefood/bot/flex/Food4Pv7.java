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

public class Food4Pv7 implements Supplier<FlexMessage> {
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
                .url("https://i.ytimg.com/vi/5KV8elVtwy8/maxresdefault.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีแกงแคหอย")
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
                            .text("วัตถุดิบ\n1. หอยขม 1 ถ้วย \n2.ข้าวคั่ว 1/2 ถ้วย\n3.ตำลึง 1/2 ถ้วย\n4.ชะพลู 1/2 ถ้วย\n5.ชะอม 1/2 ถ้วย\n6.ถั่วฝักยาว 1/4 ถ้วย\n7.มะเขือเปราะ มะเขือขาว มะเขือยาว 1/4 ถ้วย\n8.มะเขือพวง 1/4 ถ้วย\n9.ใบพริก 1/4 ถ้วย \n10.พริกขี้หนู 3 เม็ด\n11.ดอกงิ้วแห้ง 10 ดอก (แช่น้ำก่อนนำไปแกง)\n12.ข่าหั่น 4 แว่น\n13.ตะไคร้หั่นเป็นท่อน 1 ต้น\n14.ผักชีต้นหอมซอย 1 ช้อนโต๊ะ\nเครื่องแกง\n1.พริกแห้ง 10 เม็ด(พริกแห้งย่างไฟ ก็ได้ ต่างกันที่สี และความหอม)\n2.กระเทียม 5 กลีบ\n3.หอมแดง 5 หัว\n4.ปลาร้าหรือ กะปิ 1 ช้อนโต๊ะ\n5.เกลือ 1 ช้อนชา1. ล้างหอยขมให้สะอาด  แล้วตัดก้นหอยออก นำไปลวก แล้วแกะฝาหน้าหอยออก \n2.ตั้งไฟ ใส่น้ำมันเล็กน้อย  ใส่เครื่องแกงลงผัดให้หอม \n3.ใส่หอยลงผัดให้เข้ากัน เติมน้ำ เคี่ยวต่อจนหอยสุก \n4.ใส่ตะไคร้ และข่า\n5.ใส่ผักแกงแค(เลือกผักที่สุกช้าลงก่อน) คนให้ทั่ว \n6.พอเดือด ใส่ข้าวคั่ว คนให้เข้ากัน พอผักสุก ปิดไฟ")
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


    
