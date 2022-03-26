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

public class Food2Pv6 implements Supplier<FlexMessage>{
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
                .url("https://i.pinimg.com/originals/c6/04/f3/c604f36c4fc175a607f2e919308b9c0c.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำข่างปอง")
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
                            .text("วัตถุดิบ\n1.ผักกระเจียว 300 กรัม\n2.หอมแดง2-4 หัว\n3.ตะไคร้ 1-2 ต้น\n4.กะปิ 1 ช้อนโต๊ะ\n5.พริกแห้ง 10 เม็ด ใส่ความเผ็ดตามใจชอบ\n6.เกลือป่น ½ช้อนชา\n7.กระเทียม 7-10 กลีบ\n8.น้ำมันสำหรับทอด\n9.แป้งข้าวเหนียวและแป้งข้าวเจ้า ในอัตราส่วน 1:1 อาจจะใช้แป้งทอดกรอบสำเร็จรูปก็ได้\n10.น้ำส้มสายชู 2 ช้อนโต๊ะ\n11.น้ำตาลทราย3ช้อนโต๊ะ\n12.ถั่วลิสงคั่ว 2 ช้อนโต๊ะ\n13.แตงกวา 1 ผล\nวิธีการทำ\n1.นำดอกกระเจียวมาล้างน้ำให้สะอาด วางให้สะเด็ดน้ำ แล้วนำมาหั่นฝอย\n2.นำแป้งข้าวเหนียว ข้าวเจ้า ผสมกับหอมแดงซอย กะปิ  พริกป่น เติมน้ำเล็กน้อย แล้วนำดอกกระเจียวที่หั่นฝอยเตรียมไว้ลงไปคลุกเค้าให้เข้ากัน บางคนจะเติมน้ำพริกแกงเผ็ดลงไปด้วย เพิ่มรสชาดได้อีกแบบนึงค่ะ\n3. จากนั้นตั้งกระทะใส่น้ำมันให้ร้อนแล้วนำส่วนผสมที่เตรียมไว้ลงไปทอดได้เลย  และเวลาทอดให้ตักทีละน้อย ทำขนาดพอดีคำจะดีกว่า ทอดพอเหลืองกรอบ ตักขึ้นพักไว้ให้สะเด็ดน้ำมัน\n4.ระหว่างรอมาทำน้ำจิ้ม ซอยกระเทียม แตงกวา เป็นชิ้นเล็กๆ เติมน้ำส้มสายชู น้ำตาล ใส่เกลือเล็กน้อย ชิมรสชาติตามชอบ ให้มีรสชาติเปรี้ยวนำหวานตามค่ะ และเติมถั่วลิสงคั่วลงไป คนให้เข้ากันอีกครั้งเป็นอันใช้ได้\n5.เสริฟคู่กับจิ้มน้ำหรือจะทานกับน้ำพริกกะปิ ก็เข้ากันดีและนี่คืออัตลักษณ์ด้านอาหารของชาวไทใหญ่ ที่มีความโดดเด่นในการใช้พืชผักพื้นบ้านที่หาได้ง่ายในท้องถิ่นมาประกอบเป็นอาหารที่มีคุณค่าทางโภชนาการ ทานได้ทุกเพศทุกวัยไม่จำกัด")
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
    
