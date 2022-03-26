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

public class Food4Pv2 implements Supplier<FlexMessage> {
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
                .url("https://img.wongnai.com/p/1968x0/2018/05/01/164c52cf508344a2b4942f0accc10879.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำแคบหมู")
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
                            .text("ขั้นตอน\n1.เตรียมหนังหมู และ มันหมูส่วนท้องอายุประมาณ 6 เดือน(ไม่มีไม่เป็นไร ใช้หนังหมูอายุมากกว่านี้ก็ได้แต่จะกรอบ และ พองน้อยลง) ล้างให้สะอาด แล้วนำมาขยี้เกลือ\n2. โกนขนขูดผิวด้วยมีดโกน \n(ถ้ามีดที่เราใช้ไม่คมให้เอาหนังหมูไปต้มให้สุกก่อนแล้วค่อยตัดเป็นชิ้นจะตัดแบ่งได้ง่ายกว่า) \n3.ตัดแบ่งหนังหมูเป็นท่อนสั้นหนาประมาณ 2 นิ้ว\n4.โกนขนเก็บตกอีกที นำลงต้มในน้ำเดือนประมาณ 3 ชั่วโมงแลัวตักขึ้นสะเด็ดน้ำ\n(ยิ่งต้มนาน จะทำให้แคบหมูยิ่งพองง่ายมากยิ่งขึ้นในขั้นตอนทอดรอบสอง) \n5.นำไปตากแดดให้แห้งแข็ง ให้เจลาตินในหนังหมูต้มเสร็จใหม่ ๆ ที่เหนียวแห้งลงและลดความเหนียว ช่วยป้องกันไม่ให้น้ำมันกระเด็นตอนเคี่ยวแคบหมู และทำยังทำให้แคบหมูฟูกรอบ\n6. ตั้งกระทะบนเตาใช้ไฟกลาง ใส่น้ำมันน้ำมันปาล์ม\n7.นำหนังหมูหรือมันหมูลงอ่างผสมแล้วปรุงรส และ แต่งสีด้วย ด้วย ซีอิ้วดำ ซีอิ้วขาวเกลือเล็กน้อยและผงปรุงรส นวดคุกเข่าให้เข้ากันแบบแห้ง ๆ แล้วนำลงเจียว\n8. นำลงเจียวไฟกลาง 2 ชั่วโมง และ ปรับเป็นไฟต่ำทอดต่อ 50 นาที แล้วปิดไฟ\n9. พักหมูแช่หมักไว้ในน้ำมัน 1 คืน\n( หากยังไม่ทอดเลยหลังจากแช่ไว้ ก็สามารถหยุดไว้ตรงขั้นตอนนี้ก่อนโดยนำขึ้นจากน้ำมันแล้วตักใส่ถุง เก็บรักษาได้ในตู้เย็น พอจะทอดค่อยนำ้หนังหมูมาละลาย แล้วแช่ในน้ำมันประมาณ 2 ชั่วโมงก็ทอดได้ ) \n10. ตั้งกระทะบนเตา ใส่น้ำมันน้ำมันปาล์มและน้ำมันหมูที่ได้จากการเจียวหนังหมูลงกระทะ ใช้ไฟอ่อนถึงกลาง รอน้ำมันเริ่มร้อน แล้วใส่ใบเตยลงไปผัดกับน้ำมัน\n11. นำหนังหมูที่แช่ในนำ้มันพักไว้ลงทอดในน้ำมันที่เดือดค่อย ๆ ใช้ ตะแกรง หรือ กระชอนทอดกดให้หนังหมูจมและเขย่าเบา ๆ ทอดไปเรื่อย ๆ จนฟูกรอบ\n12. เมื่อทอดจนได้สีสวยแล้วตักขึ้น พักให้สะเด็ดน้ำมัน รอให้เย็นแล้วนำใส่ในถุงซิปล็อคหรือกระปุกที่อากาศไม่เข้า เพื่อเก็บรักษาให้แคบหมูฟูกรอบ \n")
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